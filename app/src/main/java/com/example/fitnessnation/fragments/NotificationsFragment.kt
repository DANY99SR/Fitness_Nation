package com.example.fitnessnation.fragments

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fitnessnation.AlarmReceiver
import com.example.fitnessnation.R
import kotlinx.android.synthetic.main.fragment_notifications.*
import java.util.*

class NotificationsFragment : Fragment() {

    lateinit var alarm: AlarmManager
    lateinit var tp: TimePicker
    var hour:Int=0
    var min:Int=0
    lateinit var pi: PendingIntent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }

        alarm=activity?.getSystemService(ALARM_SERVICE) as AlarmManager
        var calendar:Calendar= Calendar.getInstance()
        tp=time as TimePicker

        var myIntent:Intent= Intent(activity, AlarmReceiver::class.java)
        btn_picktime.setOnClickListener(object:View.OnClickListener
        {
            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onClick(v: View?) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                {
                    calendar.set(Calendar.HOUR_OF_DAY,tp.hour)
                    calendar.set(Calendar.MINUTE,tp.minute)
                    calendar.set(Calendar.SECOND,0)
                    calendar.set(Calendar.MILLISECOND,0)
                    hour=tp.hour
                    min=tp.minute
                }
                else
                {
                    calendar.set(Calendar.HOUR_OF_DAY,tp.currentHour)
                    calendar.set(Calendar.MINUTE,tp.currentMinute)
                    calendar.set(Calendar.SECOND,0)
                    calendar.set(Calendar.MILLISECOND,0)
                    hour=tp.currentHour
                    min=tp.currentMinute
                }
                var hr_str:String=hour.toString()
                var min_str:String=min.toString()
                if(hour>12)
                {
                    hr_str=(hour-12).toString()
                }
                if(min<10)
                {
                    min_str="0$min"
                }
                set_alarm_text("Alarm set to: $hr_str : $min_str" )

                pi= PendingIntent.getBroadcast(activity,0,myIntent, PendingIntent.FLAG_UPDATE_CURRENT)
                Toast.makeText(activity,calendar.timeInMillis.toString(),Toast.LENGTH_LONG)
                alarm.setExact(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pi)
                saveData()
            }


        })

        btn_cancel.setOnClickListener(object:View.OnClickListener
        {
            override fun onClick(v: View?) {
                set_alarm_text("ALarm Off")
                pi= PendingIntent.getBroadcast(activity,0,myIntent, PendingIntent.FLAG_UPDATE_CURRENT)
                alarm.cancel(pi)
                //   sendBroadCast(myIntent)
                saveData()
            }

        })




    }

    private fun set_alarm_text(s:String)
    {
        texttime.setText(s)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channel: NotificationChannel = NotificationChannel("notify", "Channel", NotificationManager.IMPORTANCE_DEFAULT)

        val notificationManager: NotificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }


    private fun saveData() {

        val time  =texttime.text.toString();

        val context: Context? = activity
        val sharedPref =  getActivity()?.getSharedPreferences("sharedTime", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? = sharedPref?.edit() ;
        editor?.apply{
            putString("Time",time);

        }
        if (editor != null) {
            editor.commit()
        }

    }

    private fun loadData() {

        val sharedPref = getActivity()?.getSharedPreferences("sharedTime", Context.MODE_PRIVATE)

        val savedTime = sharedPref?.getString("Time", "").toString()

        texttime.setText(savedTime)

    }

}

