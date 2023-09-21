package com.ag_tech.gdsc_pec

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ag_tech.gdsc_pec.databinding.ActivityContactBinding


class contactActivity : AppCompatActivity() {
    lateinit var contactBinding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactBinding = ActivityContactBinding.inflate(layoutInflater)
        val view = contactBinding.root
        setContentView(view)
        contactBinding.imageViewfb.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.facebook.com/profile.php?id=61550729451983")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        contactBinding.imageViewinstagram.setOnClickListener {
            val uri: Uri = Uri.parse("https://instagram.com/gdsc_prathyusha?utm_source=qr&igshid=MzNlNGNkZWQ4Mg==")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        contactBinding.imageViewyoutube.setOnClickListener {
            val uri: Uri = Uri.parse("https://youtube.com/@PEC-GDSC-um5ls?si=N1H6DGzXsN_G9Juj")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        contactBinding.imageViewx.setOnClickListener {
            val uri: Uri = Uri.parse("https://twitter.com/GdscPrathy81450?t=m0ZCHR3uHhmHEMOV99QLWg&s=09")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}