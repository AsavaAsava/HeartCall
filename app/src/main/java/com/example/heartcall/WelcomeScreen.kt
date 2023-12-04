package com.example.heartcall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        findViewById<Button>(R.id.login_skip_btn).setOnClickListener{
            val intent = Intent(this,CallActivity::class.java)

            startActivity(intent)
        }

    }
}