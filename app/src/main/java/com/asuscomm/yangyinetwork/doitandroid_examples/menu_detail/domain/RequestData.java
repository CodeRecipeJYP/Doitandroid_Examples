package com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaeyoung on 2017. 5. 2..
 */

public class RequestData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator<RequestData>() { // ??
        @Override
        public RequestData createFromParcel(Parcel source) {
            return new RequestData(source);
        }

        @Override
        public RequestData[] newArray(int size) {
            return new RequestData[size];
        }
    };

    public RequestData(String request) {
        this.request = request;
    }

    public RequestData(Parcel source) {
        this.request = source.readString();
    }


    String request;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(request);
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "request='" + request + '\'' +
                '}';
    }
}
