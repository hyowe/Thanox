/*
 * (C) Copyright 2022 Thanox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package github.tornaco.android.thanos.core.app.usage;

import android.os.Parcel;
import android.os.Parcelable;

import github.tornaco.android.thanos.core.annotation.Keep;
import github.tornaco.android.thanos.core.pm.Pkg;

@Keep
public class PkgCpuUsageStats implements Parcelable {
    public Pkg pkg;
    public String cpuRatioString;

    protected PkgCpuUsageStats(Parcel in) {
        pkg = in.readParcelable(Pkg.class.getClassLoader());
        cpuRatioString = in.readString();
    }

    public PkgCpuUsageStats(Pkg pkg, String cpuRatioString) {
        this.pkg = pkg;
        this.cpuRatioString = cpuRatioString;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(pkg, flags);
        dest.writeString(cpuRatioString);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PkgCpuUsageStats> CREATOR = new Creator<PkgCpuUsageStats>() {
        @Override
        public PkgCpuUsageStats createFromParcel(Parcel in) {
            return new PkgCpuUsageStats(in);
        }

        @Override
        public PkgCpuUsageStats[] newArray(int size) {
            return new PkgCpuUsageStats[size];
        }
    };
}
