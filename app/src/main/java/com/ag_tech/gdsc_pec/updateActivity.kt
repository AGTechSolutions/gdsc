package com.ag_tech.gdsc_pec

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag_tech.gdsc_pec.databinding.ActivityUpdateBinding
import com.google.firebase.database.*

class updateActivity : AppCompatActivity() {
    lateinit var  updateBinding: ActivityUpdateBinding
    val database2 : FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference2 : DatabaseReference = database2.reference.child("classes")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateBinding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = updateBinding.root

        setContentView(view)
        reference2.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val aimlclasstimings : String = snapshot.child("aiml").child("classtimings").value as String
                val aimlclassmode : String = snapshot.child("aiml").child("mode").value as String
                val aimlclassvenue : String = snapshot.child("aiml").child("venue").value as String
                val cloudclasstimings : String = snapshot.child("cloud").child("classtimings").value as String
                 val cloudclassmode : String = snapshot.child("cloud").child("mode").value as String
                val cloudclassvenue : String = snapshot.child("cloud").child("venue").value as String
                val madclasstimings : String = snapshot.child("mad").child("classtimings").value as String
                val madclassmode : String = snapshot.child("mad").child("mode").value as String
                val madclassvenue : String = snapshot.child("mad").child("venue").value as String
                val fullstackclasstimings : String = snapshot.child("fullstack").child("classtimings").value as String
                val fullstackclassmode : String = snapshot.child("fullstack").child("mode").value as String
                val fullstackclassvenue : String = snapshot.child("fullstack").child("venue").value as String
                val check : String = "No Class"
                   if(aimlclasstimings!=check)
                   {
                       updateBinding.aimlimgbg.setBackgroundColor(Color.YELLOW)
                       updateBinding.aimldesignbg.setBackgroundColor(Color.YELLOW)
                   }
                if(cloudclasstimings!=check)
                {
                    updateBinding.cloudimgbg.setBackgroundColor(Color.YELLOW)
                    updateBinding.clouddesignbg.setBackgroundColor(Color.YELLOW)
                }
                if(madclasstimings!=check)
                {
                    updateBinding.madimgbg.setBackgroundColor(Color.YELLOW)
                    updateBinding.maddesignbg.setBackgroundColor(Color.YELLOW)
                }
                if(fullstackclasstimings!=check)
                {
                    updateBinding.webimgbg.setBackgroundColor(Color.YELLOW)
                    updateBinding.webdesignbg.setBackgroundColor(Color.YELLOW)

                }
                    updateBinding.tvaimltimings.text="Class Timing :"+aimlclasstimings
                    updateBinding.tvaimlmode.text ="Mode :"+aimlclassmode
                    updateBinding.tvaimlvenue.text = "Venue :"+aimlclassvenue


                updateBinding.tvmadtimings.text ="Class Timing :"+madclasstimings
                updateBinding.tvmadmode.text = "Mode :"+madclassmode
                updateBinding.tvmadvenue.text = "Venue :"+madclassvenue


                updateBinding.tvcloudtimings.text ="Class Timing :"+cloudclasstimings
                updateBinding.tvcloudmode.text = "Mode :"+cloudclassmode
                updateBinding.tvcloudvenue.text = "Venue :"+cloudclassvenue

                updateBinding.tvwebtimings.text ="Class Timing :"+fullstackclasstimings
                updateBinding.tvwebmode.text = "Mode :"+fullstackclassmode
                updateBinding.tvwebvenue.text = "Venue :"+fullstackclassvenue


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })




    }
}