package com.ag_tech.gdsc_pec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.view.isVisible
import com.ag_tech.gdsc_pec.databinding.ActivityPasswordRecoveryBinding
import com.google.firebase.auth.FirebaseAuth

class password_recovery : AppCompatActivity() {
    lateinit var passwordRecoveryBinding: ActivityPasswordRecoveryBinding
    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        passwordRecoveryBinding= ActivityPasswordRecoveryBinding.inflate(layoutInflater)
        val view = passwordRecoveryBinding.root
        setContentView(view)
        val email = passwordRecoveryBinding.editTextRecoveryEmail.text.toString()
        sendrecoverlink(email)
    }

    private fun sendrecoverlink(recoverEmail: String) {

        passwordRecoveryBinding.buttonRecoverPassword.setOnClickListener {

           auth.sendPasswordResetEmail(recoverEmail).addOnCompleteListener { task->
                if(task.isSuccessful)
                {
                    Toast.makeText(applicationContext,"Reset password mail has sent successfully", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}