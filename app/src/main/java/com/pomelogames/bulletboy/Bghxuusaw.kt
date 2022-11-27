package com.pomelogames.bulletboy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pomelogames.bulletboy.databinding.ActivityBghxuusawBinding
import kotlin.random.Random

class Bghxuusaw : AppCompatActivity() {
    private lateinit var sidjxi : ActivityBghxuusawBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sidjxi = ActivityBghxuusawBinding.inflate(layoutInflater)
        setContentView(sidjxi.root)
        val psdosll = listOf(
            "Scarab points : 100",
            "Scarab points : 200",
            "Scarab points : 500",
            "Scarab points : 800",
            "Scarab points : 1000",
        )

        sidjxi.usdb.text = psdosll[Random.nextInt(5)]
        sidjxi.wpsodallasd.setOnClickListener {
            startActivity(Intent(this,Usoijxzis::class.java))
        }
    }
}