package com.ag_tech.gdsc_pec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ag_tech.gdsc_pec.databinding.ActivityProfileBinding
import com.ag_tech.gdsc_pec.databinding.ActivityUpdateBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class profile : AppCompatActivity() {
    lateinit var profileBinding: ActivityProfileBinding
    val database3 : FirebaseDatabase = FirebaseDatabase.getInstance()

    val reference3 :  DatabaseReference = database3.reference.child("users")
    val auth =  FirebaseAuth.getInstance()
    val user = auth.currentUser
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        profileBinding = ActivityProfileBinding.inflate(layoutInflater)
        val view = profileBinding.root
        setContentView(view)
        reference3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                user?.let{
                    val userid = it.uid
                    val profileregno : String =  snapshot.child(userid).child("registernumber").value as String
                    val profilefullname : String = snapshot.child(userid).child("registername").value as String
                    val profileyearsem : String = snapshot.child(userid).child("yearsem").value as String
                    val profiledeptname : String = snapshot.child(userid).child("deptname").value as String
                    val profilemobileno : String = snapshot.child(userid).child("phonenumber").value as String
                    val profileclubname : String = snapshot.child(userid).child("clubname").value as String
                    profileBinding.profileregno.text=" Reg Number : "+profileregno
                    profileBinding.profilefullname.text=" Full Name :  "+profilefullname
                    profileBinding.profiledeptname.text="Dept Name : "+profiledeptname
                    profileBinding.profileyearsem.text="Year-Sem :  "+profileyearsem
                    profileBinding.profileclubname.text="Club Name : "+profileclubname
                    profileBinding.profilemobileno.text="Mobile No :"+profilemobileno
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"You have not registered yet !", Toast.LENGTH_SHORT).show()
            }

        })
    }
}