package com.pomelogames.bulletboy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.pomelogames.bulletboy.databinding.ActivityUsoijxzisBinding
import kotlin.random.Random

class Usoijxzis : AppCompatActivity() {

    val dusai = listOf(
        R.drawable.brill_1,
        R.drawable.brill_2,
        R.drawable.brill_3,
        R.drawable.brill_4,
        R.drawable.brill_5,
        R.drawable.brill_6,
        R.drawable.brill_7,
    )
    val udysbada = listOf(
        "Your bonus : x2",
        "Your bonus : x5",
        "Your bonus : x10",
        "Your bonus : x20",
        "Your bonus : x25",
        "Your bonus : x30",
        "Your bonus : x50",
    )

    val osap = listOf(
        "Your power : x2",
        "Your power : x50",
        "Your power : x30",
        "Your power : x45",
        "Your power : x60",
        "Your power : x120",
        "Your power : x160",

    )

    val kicokvkvxc = listOf(
        "Your chance : x2",
        "Your chance : x5",
        "Your chance : x6",
        "Your chance : x7",
        "Your chance : x8",
        "Your chance : x9",
        "Your chance : x10",


        )
    private var guxix: CountDownTimer? = null
    private lateinit var isaodkxzkcm : ActivityUsoijxzisBinding
    private var psodlsdk = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isaodkxzkcm = ActivityUsoijxzisBinding.inflate(layoutInflater)
        setContentView(isaodkxzkcm.root)

        if(psodlsdk == false) {
            isaodkxzkcm.topsl.setOnClickListener {
                vcjvjkkasda()

            }
        }
    }



    private fun rosikxmcna() =with(isaodkxzkcm) {
        val isdmxkzcm = dusai[Random.nextInt(7)]
        val stsyxh = kicokvkvxc[Random.nextInt(7)]
        val qosp= udysbada[Random.nextInt(7)]
        val dxz= osap[Random.nextInt(7)]

        opcx.text = stsyxh
        eosoa.text = qosp
        isadodka.text = dxz
        zlosa.setImageResource(isdmxkzcm)

        Handler().postDelayed({
            startActivity(
                Intent(this@Usoijxzis, Bghxuusaw::class.java)
            )
        },1000)


    }

    private fun vcjvjkkasda() = with(isaodkxzkcm){
        var awosa = 0
        guxix?.cancel()
        guxix = object : CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
                awosa++
                psodlsdk = true
                topsl.alpha = 0.7f
                if(awosa>6)awosa = 0
                opcx.text = osap[awosa]
                eosoa.text = udysbada[awosa]
                isadodka.text = udysbada[awosa]
                zlosa.setImageResource(dusai[awosa])

            }

            override fun onFinish() {
                rosikxmcna()
                psodlsdk = false
                topsl.alpha = 1.0f

            }

        }.start()

    }


}