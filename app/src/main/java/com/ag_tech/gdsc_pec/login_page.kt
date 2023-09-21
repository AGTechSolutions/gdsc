package com.ag_tech.gdsc_pec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ag_tech.gdsc_pec.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class login_page : AppCompatActivity() {
    lateinit var loginPageBinding: ActivityLoginPageBinding
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginPageBinding = ActivityLoginPageBinding.inflate(layoutInflater)
        var view = loginPageBinding.root
        setContentView(view)
        loginPageBinding.textViewregister.setOnClickListener {
            val intent = Intent(this@login_page,sign_up::class.java)
            startActivity(intent)

        }
        loginPageBinding.textViewforgotpassword.setOnClickListener {
            val intent = Intent (this@login_page,password_recovery::class.java)
            startActivity(intent)

        }
        loginPageBinding.buttonSignIn.setOnClickListener {
            val useremail = loginPageBinding.editTextUserEmail.text.toString()
            val userpassword = loginPageBinding.editTextUserPassword.text.toString()
            signin(useremail,userpassword)

        }
    }
    fun signin(useremail :String , userpassword : String)
    {
        auth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener { task->
            if(task.isSuccessful)
            {
               val intent = Intent(this@login_page,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(applicationContext,task.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if(user != null){
            val intent = Intent(this@login_page,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}