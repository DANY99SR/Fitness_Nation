package com.example.fitnessnation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.LogInFragment

import com.example.fitnessnation.R
import com.example.fitnessnation.RecyclerViewAdapter
import com.example.fitnessnation.User
import com.example.fitnessnation.activitites.LoginActivity
import kotlinx.android.synthetic.main.fragment_log_in.Password
import kotlinx.android.synthetic.main.fragment_log_in.Username
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null
    private var loginButton: Button? = null
    private var vieww: View? = null
    lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerViewAdapter? = null

    companion object {
        fun newInstance() = SignUpFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //   Toast.makeText(activity?.applicationContext, "SignUp", Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        users = LoginActivity.fitnessRepository.getUsersTask();

        username = view!!.findViewById(R.id.Username)
        password = view!!.findViewById(R.id.Password)

        loginButton = view!!.findViewById(R.id.login_button)

        signup_button.setOnClickListener(View.OnClickListener {
            val username = Username.getText().toString()
            val password = Password.getText().toString()
            val weight = weight.getText().toString()
            var goalWeight = goalweight.getText().toString()

            val height = height.getText().toString()

            var gender: String = "female"
            var weight_choice:Boolean=true;

            if (female.isChecked() && weightloss.isChecked()) {
                gender = "female"
                weight_choice = false;

                SignUpButtonExecute(
                    username,
                    password,
                    weight,
                    height,
                    gender,
                    weight_choice,
                    goalWeight
                )
            } else if (female.isChecked() && weightgain.isChecked()) {
                gender = "female"
                weight_choice = true;


                SignUpButtonExecute(
                    username,
                    password,
                    weight,
                    height,
                    gender,
                    weight_choice,
                    goalWeight
                )
            }
            else if (male.isChecked && weightloss.isChecked) {
                gender="male"
                weight_choice = false;


                SignUpButtonExecute(
                    username,
                    password,
                    weight,
                    height,
                    gender,
                    weight_choice,
                    goalWeight
                )
            } else if (male.isChecked && weightgain.isChecked) {
                gender="male"
                weight_choice = true;


                SignUpButtonExecute(
                    username,
                    password,
                    weight,
                    height,
                    gender,
                    weight_choice,
                    goalWeight
                )
            } else {
                Toast.makeText(activity, "You didn't fill all the boxes", Toast.LENGTH_SHORT).show()

            }

            users = LoginActivity.fitnessRepository.getUsersTask();

        })
    }

    fun SignUpButtonExecute(
        username: String,
        password: String,
        weight: String,
        height: String,
        gender: String,
        weight_choice: Boolean,
        goalweight: String
    ) {

        val gw = goalweight.toIntOrNull()
        val w = weight.toIntOrNull()
        val h = height.toIntOrNull()
        if (w == null || h == null || gw == null) {
            Toast.makeText(
                activity,
                "Weight, goalweight and height should be numbers",
                Toast.LENGTH_SHORT
            ).show()
        } else {

            if (username == "" || password == "") {
                Toast.makeText(activity, "You didn't fill all the boxes", Toast.LENGTH_SHORT).show()
            } else {

                val user = User(username, w, h, password, weight_choice, gender, gw)

                Toast.makeText(activity, user.getUsername(), Toast.LENGTH_LONG)
                if (findUser(user)) {
                    Toast.makeText(activity, "User is already registered", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    LoginActivity.fitnessRepository.addUserTask(user);

                    Toast.makeText(activity, "Succesfully registered!", Toast.LENGTH_SHORT).show()
                    toTheLoginFragment();
                }


            }
        }


    }


    private fun toTheLoginFragment() {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.primary_frame_s_session, LogInFragment.newInstance())
        transaction.addToBackStack(LogInFragment.toString())
        transaction.commit()
    }

    fun findUser(user: User): Boolean {
        for (usr in users!!) {
            if (usr.getUsername().equals(user.getUsername())) return true
        }
        return false
    }

}

