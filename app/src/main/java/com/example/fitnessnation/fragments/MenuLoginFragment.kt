package com.example.fitnessnation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fitnessnation.LogInFragment

import com.example.fitnessnation.R
import kotlinx.android.synthetic.main.fragment_menu_login.*


class MenuLoginFragment : Fragment() {


    companion object{
        @JvmStatic
        fun newInstance()=MenuLoginFragment()
    }



        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

          val view=inflater.inflate(R.layout.fragment_menu_login, container, false)


            return view;
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

           btn_login.setOnClickListener {
                toTheLoginFragment()
                  Toast.makeText(getActivity()?.getApplicationContext(), "Log In", Toast.LENGTH_LONG).show();
            }

            btn_sign_up.setOnClickListener {
                toTheSignUpFragment()
                Toast.makeText(getActivity()?.getApplicationContext(), "Sign Up", Toast.LENGTH_LONG).show();
            }



        }



        private fun toTheLoginFragment()
        {
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.primary_frame_s_session, LogInFragment.newInstance())
            transaction.addToBackStack(LogInFragment.toString())
            transaction.commit()
        }

    private fun toTheSignUpFragment()
    {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.primary_frame_s_session,SignUpFragment.newInstance())
        transaction.addToBackStack(SignUpFragment.toString())
        transaction.commit()
    }




}
