package com.example.fitnessnation.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompatSideChannelService
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.fitnessnation.R
import com.example.fitnessnation.User
import com.example.fitnessnation.activitites.BottomNavigationActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticsFragment : Fragment() {
    private var user: User? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_statistics, container, false)
        user=BottomNavigationActivity.user;
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user=  BottomNavigationActivity.fitnessRepository.getUserByNameTask(user?.getUsername())

        old_weight.setText(user?.weight.toString())
        goal_weight.setText(user?.goalWeight.toString())







        btn_result.setOnClickListener({



            var old=old_weight.getText().toString().toIntOrNull()
            var goal=goal_weight.getText().toString().toIntOrNull()
            var current=current_weight.getText().toString().toIntOrNull()

            if(user?.choice==true && current!=null)//if it wants to gain weight
            {
                Toast.makeText(activity,"GAIN",Toast.LENGTH_LONG).show()
                if( current >= goal!!)
                {
                    Toast.makeText(activity,"CONGRATULATIONS YOU REACHED YOUR GOAL",Toast.LENGTH_LONG).show()
                }
                else
                {

                    Toast.makeText(activity,"DON'T QUIT YOU WILL REACH YOUR GOAL",Toast.LENGTH_LONG).show()
                }

            }
            else if(user?.choice==false && current!=null)//if it wants to gain loss
            {

                if( current <= goal!!)
                {
                    Toast.makeText(activity,"CONGRATULATIONS YOU REACHED YOUR GOAL",Toast.LENGTH_LONG).show()
                }
                else
                {

                    Toast.makeText(activity,"DON'T QUIT YOU WILL REACH YOUR GOAL",Toast.LENGTH_LONG).show()
                }


            }
            else
            {
                Toast.makeText(activity,"Type your current weight",Toast.LENGTH_LONG).show()
            }
            if (current != null) {
                if (goal != null) {

                    BottomNavigationActivity.fitnessRepository.updateUser(current,goal,user?.getUsername())

                    user=  BottomNavigationActivity.fitnessRepository.getUserByNameTask(user?.getUsername())

                    old_weight.setText(user?.weight.toString())
                    goal_weight.setText(user?.goalWeight.toString())


                }
            };
        })







    }
}
