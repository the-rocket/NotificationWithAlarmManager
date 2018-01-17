package demo.natification.com.notification_demo;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import demo.natification.com.notification_demo.notificationBuilder.NotificationReceiver;

public class MainActivity extends AppCompatActivity {


    private Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.d("main", "clicked");
                Log.d("main", view.getContext().getClass().getSimpleName());


                Intent intent = new Intent(view.getContext(), NotificationReceiver.class);

                PendingIntent noti = PendingIntent.getBroadcast(view.getContext(),
                    0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager alarms = (AlarmManager) view.getContext().getSystemService(
                    Context.ALARM_SERVICE);

                alarms.setExact(AlarmManager.RTC, (long) (System.currentTimeMillis() + 5000), noti);

                Notification notification = new Notification.Builder(view.getContext())
                    .setContentTitle("New mail from")
                    .setSmallIcon(android.R.drawable.sym_action_chat)
                    .setContentText("Hello Doni")
                    .setContentIntent(null).build();
                NotificationManager notificationManager =
                    (NotificationManager) view.getContext().getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(11, notification);
            }
        });
    }
}
