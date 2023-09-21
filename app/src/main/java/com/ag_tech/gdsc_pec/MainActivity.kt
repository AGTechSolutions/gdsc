package com.ag_tech.gdsc_pec

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag_tech.gdsc_pec.databinding.ActivityMainBinding
import com.denzcoskun.imageslider.models.SlideModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.gdsc))
        imageList.add(SlideModel(R.drawable.thambasir))
        imageList.add(SlideModel(R.drawable.pranawothi))
        imageList.add(SlideModel(R.drawable.gunadeep))
        imageList.add(SlideModel(R.drawable.monish))
        imageList.add(SlideModel(R.drawable.snehitha))
        imageList.add(SlideModel(R.drawable.bharathi))
        imageList.add(SlideModel(R.drawable.charan))
        imageList.add(SlideModel(R.drawable.vinay))

        mainBinding.imageSlider.setImageList(imageList)
        mainBinding.registerIcon.setOnClickListener {
            val intent = Intent(this@MainActivity,register_activity::class.java)
            startActivity(intent)

        }
        mainBinding.eventIcon.setOnClickListener {
            val intent = Intent(this@MainActivity,Events::class.java)
            startActivity(intent)

        }
        mainBinding.updateIcon.setOnClickListener {
            val intent = Intent(this@MainActivity,updateActivity::class.java)
            startActivity(intent)

        }
        mainBinding.contactIcon.setOnClickListener {
            val intent = Intent(this@MainActivity,contactActivity::class.java)
            startActivity(intent)

        }
        mainBinding.aboutIcon.setOnClickListener {
            val intent = Intent(this@MainActivity,aboutActivity::class.java)
            startActivity(intent)

        }
        mainBinding.signoutIcon.setOnClickListener {
          showdialogbox()
                 }
      mainBinding.bottomNavigationView.setOnItemSelectedListener {
          when(it.itemId)
          {
              R.id.profile -> changeactivity()


              else -> throw AssertionError()
          }

      }



    }



    private fun changeactivity(): Boolean {
        val intent = Intent(this@MainActivity,profile::class.java)
        startActivity(intent)


        return true
    }


    private fun showdialogbox() {
       var alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Signing Out")
            .setMessage("Are you sure ? ")
            .setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, which ->
              FirebaseAuth.getInstance().signOut()
                val intent = Intent(this@MainActivity,login_page::class.java)
                startActivity(intent)
                finish()
            })
        alertDialog.create().show()
    }


}