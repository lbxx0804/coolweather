package net.kboss.coolweather.util;

import android.os.Build;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;

/**
 * Created by Scan on 2016-01-27.
 */
public class HttpUtil {
    /*
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestProperty("AcceCharset", "utf-8");
                    if (connection.getResponseCode() == 200){
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        if (listener != null) {//回调onFinish方法
                            listener.onFinish(response.toString());
                        }
                     }
                }catch (Exception e){//回调出错
                    e.printStackTrace();
                    //Log.e("HttpUtil",e.getMessage()+"--------"+address);
                    if (listener != null){
                        listener.onError(e);
                    }
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }

            }
        }).start();

    }*/
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        HttpURLConnection connection = null;
                        try {
                            URL url = new URL(address);
                            connection = (HttpURLConnection)url.openConnection();
                            connection.setConnectTimeout(8000);
                            connection.setReadTimeout(8000);
                            connection.setRequestProperty("Accept-Charset", "UTF-8");
                            if(Build.VERSION.SDK_INT>13){
                                connection.setRequestProperty("Connection", "close");
                            }
                            InputStream inputStream = connection.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                            StringBuilder response = new StringBuilder();
                            String line;
                            while ((line = reader.readLine()) != null) {
                                response.append(line);
                            }
                            reader.close();
                            inputStream.close();
                            if (listener != null){
                                listener.onFinish(response.toString());
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                            if (listener != null){
                                listener.onError(e);
                            }
                        }finally {
                            if(connection != null){
                                connection.disconnect();
                            }
                        }
                    }
                }
        ).start();
    }

}
