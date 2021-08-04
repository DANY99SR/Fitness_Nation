package com.example.fitnessnation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.activitites.BottomNavigationActivity
import com.example.fitnessnation.activitites.LoginActivity
import kotlinx.android.synthetic.main.fragment_log_in.*

class LogInFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null

    private var loginButton: Button? = null
    private var vieww: View? = null

    companion object{
        fun newInstance()= LogInFragment()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_log_in, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loadData()

        users= LoginActivity.fitnessRepository.getUsersTask();


        username = view!!.findViewById(R.id.Username)
        password = view!!.findViewById(R.id.Password)

        loginButton = view!!.findViewById(R.id.login_button)

        login_button.setOnClickListener(View.OnClickListener {
            val username = Username.getText().toString()
            val password = Password.getText().toString()


            LoginButtonExecute(username, password)
        })




    }


    fun LoginButtonExecute(username: String, password: String) {
        if (username == "" || password == "") {
            Toast.makeText(activity, "You didn't fill one of boxes", Toast.LENGTH_SHORT).show()
        } else {
            val user = User()
            user.setUsername(username)
            user.setPassword(password)
            if (findUser(user)) {
                saveData()
                if(user.weight>0)
                {
                    // Toast.makeText(activity, "You are logged in", Toast.LENGTH_SHORT).show()
                }
                if(!user.choice)
                {
                    // Toast.makeText(activity, "You are logged in", Toast.LENGTH_SHORT).show()
                }


                //
                goToNextActivity(user)

            } else {
                Toast.makeText(activity, "No such user", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun goToNextActivity(user:User)
    {
        val intent = Intent(activity, BottomNavigationActivity::class.java)
        intent.putExtra("user",user);
        startActivity(intent)
    }


    fun findUser(user: User): Boolean {
        for (usr in users!!) {
            if (usr.username == user.username && usr.password == user.password)
            {
                user.weight = usr.weight;
                user.height = usr.height;
                user.gender = usr.gender;
                user.choice = usr.choice;
                user.goalWeight = usr.goalWeight;


                return true
            }
        }
        return false
    }


    private fun saveData() {

        val name  =Username.text.toString();
        val password = Password.text.toString();

        val context: Context? = activity
        val sharedPref =  getActivity()?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? = sharedPref?.edit() ;
        editor?.apply{
            putString("NAME",name);
            putString("PASSWORD",password);
            putBoolean("SWITCH",switch_remember.isChecked)
        }
        if (editor != null) {
            editor.commit()
        }

    }

    private fun loadData() {

        val sharedPref = getActivity()?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

        val savedSwitch= sharedPref?.getBoolean("SWITCH",false)
        var savedName: String="";
        var savedPass: String=""
        if (savedSwitch==true) {
            savedName = sharedPref?.getString("NAME", "").toString()
            savedPass = sharedPref?.getString("PASSWORD", "").toString()
        }
        Username?.setText(savedName);
        Password?.setText(savedPass);
        if (savedSwitch != null) {
            switch_remember.isChecked=savedSwitch
        }


    }

}