package net.kboss.coolweather.util;

/**
 * Created by Scan on 2016-01-27.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
