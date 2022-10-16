package com.cardgame.fourcardsgame.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.cardgame.fourcardsgame.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "myPrefs"
    var prefUserName: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Todo: Make theme changing
        //Todo: get rid of the header with App






        var playerName = et_playerNameId.text
        btn_StartId.setOnClickListener {


            //Save Data to Shared Preferences
            prefUserName = getSharedPreferences(PREFS_NAME, 0)
            var editor: SharedPreferences.Editor = (prefUserName as SharedPreferences?)!!.edit()
            if(!TextUtils.isEmpty(et_playerNameId.text.toString())) {
                var userName = et_playerNameId.text.toString()
                editor.putString("userName", userName)
                editor.commit()
            } else
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()

            // Get data back from SharedPreferences
            var dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)
            if (dataBack.contains("userName")) {
                var savedUserName = dataBack.getString("userName", "user")
                Toast.makeText(this, "Hello, ${savedUserName.toString()}!", Toast.LENGTH_LONG).show()
            }




            // Simply Transfer Data to another activity

//          Toast.makeText(applicationContext, "Hello, $playerName!", Toast.LENGTH_LONG).show()
            var intent = Intent(this, NormalGameActivity::class.java)
            intent.putExtra("playerName", playerName)
            startActivity(intent)
        }




    }

    fun onCheckBoxClicked(view: View) {
        Log.d("Checks", "Checkbox clicked")
        view as CheckBox
//        btn_StartId.isEnabled = cb_termsId.isChecked==true && et_playerNameId.text.isEmpty()==false
        btn_StartId.isEnabled = cb_termsId.isChecked==true

    }



}