package github.tornaco.android.thanos.module.compose.common.widget

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource

@Composable
fun <T> MenuDialog(
    state: MenuDialogState<T>,
) {
    if (state.isShowing) {
        ThanoxDialog(
            onDismissRequest = {
                state.dismiss()
            },

            title = {
                DialogTitle(text = state.title)
            }) {

            state.message?.let {
                DialogMessage(text = it)
                StandardSpacer()
            }
            state.menuItems.forEach { dialogItem ->
                ListItem(
                    title = dialogItem.title,
                    text1 = dialogItem.summary,
                    icon = {
                        dialogItem.iconRes?.let {
                            Icon(painterResource(id = it), contentDescription = null)
                        }
                    },
                    onClick = {
                        state.dismiss()
                        state.onItemSelected(state._data, dialogItem.id)
                    })
            }

        }
    }
}


data class MenuDialogItem(
    val id: String,
    val title: String,
    val summary: String? = null,
    val iconRes: Int? = null
)

open class MenuDialogState<DATA>(
    val title: String,
    val message: String? = null,
    val menuItems: List<MenuDialogItem>,
    val onItemSelected: (DATA?, String) -> Unit
) :
    CommonDialogState() {
    var _data: DATA? = null

    fun show(data: DATA? = null) {
        _data = data

        show()
    }
}

@Composable
fun <T> rememberMenuDialogState(
    title: String,
    message: String? = null,
    menuItems: List<MenuDialogItem>,
    onItemSelected: (T?, String) -> Unit
): MenuDialogState<T> {
    return remember {
        MenuDialogState(title, message, menuItems, onItemSelected)
    }
}

open class CommonDialogState {
    private var _isShow by mutableStateOf(false)
    val isShowing get() = _isShow

    fun show() {
        _isShow = true
    }

    fun dismiss() {
        _isShow = false
    }
}

