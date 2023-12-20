package com.android.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn_join = findViewById<Button>(R.id.btn_join2)
        btn_join.setOnClickListener {
            val editTx_newName = findViewById<EditText>(R.id.editTx_newName)
            val editTx_newId = findViewById<EditText>(R.id.editTx_newId)
            val editTx_newPw = findViewById<EditText>(R.id.editTx_newPw)
            val newName = editTx_newName.text.toString()
            val newId = editTx_newId.text.toString()
            val newPw = editTx_newPw.text.toString()

            when{
                newName.isEmpty() -> { Toast.makeText(this, "이름을 확인해주세요", Toast.LENGTH_SHORT).show()}
                newId.isEmpty() -> { Toast.makeText(this, "아이디를 확인해주세요", Toast.LENGTH_SHORT).show()}
                newPw.isEmpty() -> { Toast.makeText(this, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()}
                else -> {
                    Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignInActivity::class.java)
                    intent.putExtra("idData", newId)
                    intent.putExtra("pwData", newPw)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
}