package com.ag_tech.gdsc_pec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ag_tech.gdsc_pec.databinding.ActivityMainBinding
import com.ag_tech.gdsc_pec.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class register_activity : AppCompatActivity() {
   lateinit var registerBinding: ActivityRegisterBinding
    val database = FirebaseDatabase.getInstance()
    val databaseReference : DatabaseReference = database.reference.child("users")
    val auth =  FirebaseAuth.getInstance()
    val user = auth.currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding= ActivityRegisterBinding.inflate(layoutInflater)
        val view = registerBinding.root
        setContentView(view)
        registerBinding.buttonregister.setOnClickListener {
            var registernumber :String = registerBinding.editTextTextRegisternumber.text.toString()
            var registername  :String = registerBinding.editTextname.text.toString()
            var yearsem : String = registerBinding.editTextyearsem.text.toString()
            var clubname :String = registerBinding.editTextclubname.text.toString()
            var phonenumber : String = registerBinding.editTextphone.text.toString()
            var deptname : String = registerBinding.editTextTextdeptname.text.toString()
            user?.let {
                val userid=it.uid
                databaseReference.child(userid).child("registernumber").setValue(registernumber)
                databaseReference.child(userid).child("registername").setValue(registername)
                databaseReference.child(userid).child("deptname").setValue(deptname)
                databaseReference.child(userid).child("yearsem").setValue(yearsem)
                databaseReference.child(userid).child("clubname").setValue(clubname)
                databaseReference.child(userid).child("phonenumber").setValue(phonenumber).addOnSuccessListener {
                    Toast.makeText(applicationContext,"registered succesfully",Toast.LENGTH_SHORT).show()
                       finish()
                }
            }


        }

    }
}