package demo.natification.com.notification_demo.notificationBuilder;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by daniyar on 16/01/2018.
 */

public class NotificationReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("OnReceive", "received");

        PendingIntent noti = PendingIntent.getBroadcast(context,
            0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarms = (AlarmManager) context.getSystemService(
            Context.ALARM_SERVICE);

        alarms.cancel(noti);
        alarms.setExact(AlarmManager.RTC, (Long) (System.currentTimeMillis() + 10000), noti);

        Notification notification = new Notification.Builder(context)
            .setContentTitle("New mail: " + System.currentTimeMillis())
            .setSmallIcon(android.R.drawable.sym_action_chat)
            .setContentText("Hello")
            .setContentIntent(null).build();
        NotificationManager notificationManager =
            (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        notificationManager.notify((int)(System.currentTimeMillis()), notification);
    }
}
