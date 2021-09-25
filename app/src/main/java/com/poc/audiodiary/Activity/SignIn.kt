package com.poc.audiodiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.poc.audiodiary.MainActivity
import com.poc.audiodiary.R

class SignIn : AppCompatActivity() {

    lateinit var btnSignIn : Button
    lateinit var itlPasswordLogin : TextInputEditText
    lateinit var itlEmailLogin : TextInputEditText
    lateinit var mAuth : FirebaseAuth

//    lateinit var itlEmailLogin : TextInputEditText-


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnSignIn.setOnClickListener(View.OnClickListener {

            var email = itlEmailLogin.editableText.toString()
            var password = itlPasswordLogin.editableText.toString()
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            {
                itlEmailLogin.error="Fields can't be empty"
                itlPasswordLogin.error = "Fields can't be null"
            }
            else if (password.length<8)
            {
                Toast.makeText(this,"Password should be more than 8 characters",Toast.LENGTH_SHORT).show()

            }
            else
            {
                signIn(email,password)
            }



        })




    }

    private fun signIn(email: String, password: String) {
        mAuth = FirebaseAuth.getInstance()

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,
                OnCompleteListener {
                    val i = Intent(this, Diary::class.java)
                    startActivity(i)
                })


        }
}