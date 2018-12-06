package com.coolweather.android.gson;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/12/5/005.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
