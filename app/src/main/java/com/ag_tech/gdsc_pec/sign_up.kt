package com.ag_tech.gdsc_pec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.ag_tech.gdsc_pec.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.sign

class sign_up : AppCompatActivity() {
    lateinit var signUpBinding: ActivitySignUpBinding
    val auth :FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding=ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)
       signUpBinding.editTextSignupPassword.addTextChangedListener(object :TextWatcher
       {
           override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

           }

           override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

           }

           override fun afterTextChanged(p0: Editable?) {
               signUpBinding.textViewpasswordhint.visibility=View.VISIBLE
           }

       })
        signUpBinding.buttonsignup.setOnClickListener {
            val email = signUpBinding.editTextSignupEmail.text.toString()
            val password = signUpBinding.editTextSignupPassword.text.toString()
            signup(email, password)
        }

    }
    fun signup(email : String , password: String)
    {
        signUpBinding.progressBar.visibility= View.VISIBLE
        signUpBinding.buttonsignup.isClickable=false
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful)
            {
                Toast.makeText(applicationContext,"Your Account has been created", Toast.LENGTH_SHORT).show()
                finish()
                signUpBinding.progressBar.visibility=View.INVISIBLE
                signUpBinding.buttonsignup.isClickable=true
            }
            else{
                Toast.makeText(applicationContext,"Failed to create your account try after some time ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}