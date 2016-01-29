package net.kboss.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.kboss.coolweather.service.AutoUpdateService;

/**
 * Created by Scan on 2016-01-29.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);
        Log.d("AutoUpdateReceiver","自动更新天气");
    }
}
