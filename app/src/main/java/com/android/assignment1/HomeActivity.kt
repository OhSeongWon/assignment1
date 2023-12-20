package com.android.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math.random
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val logInId = intent.getStringExtra("dataFromSignInActivity")
        val tv_realName = findViewById<TextView>(R.id.tv_realName)
        tv_realName.setText(logInId)

        val image = findViewById<ImageView>(R.id.ic_smile)

        var random = Random.nextInt(5)

        val imageResource = resources.getIdentifier("ic_${random}" ,"drawable", packageName)

        image.setImageResource(imageResource)

        val btn_finish = findViewById<Button>(R.id.btn_finish)
        btn_finish.setOnClickListener {
            finish()
        }
    }

}