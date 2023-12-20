package com.android.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var registerLauncher: ActivityResultLauncher<Intent>
    private lateinit var logIn: EditText
    private lateinit var pw: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_login = findViewById<Button>(R.id.btn_login)
        logIn = findViewById<EditText>(R.id.editTx_id)
        pw = findViewById<EditText>(R.id.editTx_pw)
        btn_login.setOnClickListener {
            val strLogIn = logIn.text.toString()
            val strPw = pw.text.toString()
            if (strLogIn.isEmpty()) {
                Toast.makeText(this, "아이디를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                if (strPw.isEmpty()) {
                    Toast.makeText(this, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("dataFromSignInActivity", strLogIn)
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }
        }
        registerForActivityResult()
        val btn_join = findViewById<Button>(R.id.btn_join)
        btn_join.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            registerLauncher.launch(intent)
        }
    }
    fun registerForActivityResult(){
        registerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if( result.resultCode == RESULT_OK){
                var joinIdData= result.data?.getStringExtra("idData")
                var joinPwData = result.data?.getStringExtra("pwData")
                logIn.setText(joinIdData)
                pw.setText(joinPwData)
            }
        }
    }
}