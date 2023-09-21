package com.ag_tech.gdsc_pec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.ag_tech.gdsc_pec.databinding.ActivitySplashBinding

class splash : AppCompatActivity() {
    lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view= splashBinding.root
        setContentView(view)
         val animation = AnimationUtils.loadAnimation( applicationContext,R.anim.splash_anim)
          splashBinding.textViewgdsc.startAnimation(animation)
        splashBinding.textViewpec.startAnimation(animation)
       val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object: Runnable{
            override fun run() {
               val intent = Intent(this@splash,login_page::class.java)
                startActivity(intent)
                finish()
            }
        },5000)

    }
}