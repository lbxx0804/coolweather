package net.kboss.coolweather.util;

import android.text.TextUtils;

import net.kboss.coolweather.db.CoolWeatherDB;

/**
 * Created by Scan on 2016-01-27.
 * 用于解析和处理服务器返回的天气数据
 */
public class Utility {

    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String [] arrProvinces = response.split(",");
            if(arrProvinces != null && arrProvinces.length > 2){
                for (String p : arrProvinces){
                    String [] arrp = p.split("|");
                }
            }
        }
        return  false;
    }

}
