package arpit.parekh.kotlinchaitanyaprashantproject.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityShowNotificationBinding

class ShowNotificationActivity : AppCompatActivity() {

    lateinit var binidng : ActivityShowNotificationBinding
    private lateinit var manager : NotificationManager
    private lateinit var channel: NotificationChannel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binidng = ActivityShowNotificationBinding.inflate(layoutInflater)
        setContentView(binidng.root)

        // we need system service called Notification Manager

        binidng.btnNotification.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                channel = NotificationChannel("101","My Channel",NotificationManager.IMPORTANCE_DEFAULT)
                manager.createNotificationChannel(channel)

            }else{

                manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }

            // pending intent

            //////////////  click on notification /////////////////////////

            val intent = Intent(this,ShowNotificationActivity::class.java)
            val pendingIntent : PendingIntent = PendingIntent.getActivity(this,101,intent,
                PendingIntent.FLAG_CANCEL_CURRENT)

            /////////////////////////////////////////////////////////

            val builder : NotificationCompat.Builder = NotificationCompat.Builder(this,"101")
                .setSmallIcon(R.drawable.ic_call)
                .setContentTitle("This is My Notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)  // click on notification
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentText("This is My Notification Message")


            manager.notify(0,builder.build())

        }

    }
}