package com.example.fitnessnation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.fitnessnation.R
import com.example.fitnessnation.User
import com.example.fitnessnation.activitites.LoginActivity
import com.example.fitnessnation.activitites.MainActivity
import kotlinx.android.synthetic.main.fragment_logo.*
import com.example.fitnessnation.AppDatabase

class LogoFragment : Fragment() {
    companion object {
        fun newInstance() = LogoFragment()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_logo, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val db = activity?.let { Room.databaseBuilder(it, AppDatabase::class.java, "meals").build() }

        btn_start.setOnClickListener {
            goToNextActivity()
        }
    }
    fun goToNextActivity()
    {
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
    }
}

