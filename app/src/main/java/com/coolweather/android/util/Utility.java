package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Administrator on 2018/12/4/004.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            Gson gson = new Gson();
            List<Province> provinces = gson.fromJson(response,
                    new TypeToken<List<Province>>(){}.getType());
            for(Province province : provinces){
                province.setProvinceCode(province.getId());
                province.save();
            }
            return true;
        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceCode){
        if(!TextUtils.isEmpty(response)){
            Gson gson = new Gson();
            List<City> cities = gson.fromJson(response,
                    new TypeToken<List<City>>(){}.getType());
            for(City city : cities){
                city.setProvinceCode(provinceCode);
                city.setCityCode(city.getId());
                city.save();
            }
            return true;
        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityCode){
        if(!TextUtils.isEmpty(response)){
            Gson gson = new Gson();
            List<County> counties = gson.fromJson(response,
                    new TypeToken<List<County>>(){}.getType());
            for(County county : counties){
                county.setCityCode(cityCode);
                county.save();
            }
            return true;
        }
        return false;
    }
}
