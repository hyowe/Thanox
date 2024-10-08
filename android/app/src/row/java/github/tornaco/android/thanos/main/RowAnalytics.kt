package github.tornaco.android.thanos.main

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.ktx.Firebase
import now.fortuitous.thanos.analytics.Analytics
import now.fortuitous.thanos.analytics.Event


class RowAnalytics : Analytics {
    private var firebaseAnalytics: FirebaseAnalytics? = null

    init {
        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics
    }

    override fun reportEvent(event: Event) {
        kotlin.runCatching {
            firebaseAnalytics?.logEvent(event.name) {
                event.params.forEach { (t, u) ->
                    param(t, u.toString())
                }
            }
        }
    }
}