package com.pomelogames.bulletboy

import java.io.File
import java.io.IOException
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import android.app.Activity
import com.pomelogames.bulletboy.Junxhxc.Companion.TFDTYS
import android.content.Intent
import com.pomelogames.bulletboy.Junxhxc.Companion.hucjxmna
import android.content.pm.PackageManager
import android.net.Uri
import com.pomelogames.bulletboy.Junxhxc.Companion.QOPSL
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.pomelogames.bulletboy.databinding.ActivityIopkbdaBinding
import org.json.JSONException
import org.json.JSONObject
import com.pomelogames.bulletboy.Junxhxc.Companion.UISDOJ


class Iopkbda : AppCompatActivity() {
    lateinit var wpsadoasdkxzcm: ActivityIopkbdaBinding
    lateinit var jksolxzc: WebView
    var tyuasididjjxz: ValueCallback<Array<Uri>>? = null
    var cvhs: String? = null
    private val eisa = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wpsadoasdkxzcm = ActivityIopkbdaBinding.inflate(layoutInflater)
        setContentView(wpsadoasdkxzcm.root)

        jksolxzc = wpsadoasdkxzcm.xccxz
        Snackbar.make(
            wpsadoasdkxzcm.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val iocxmm = CookieManager.getInstance()
        iocxmm.setAcceptCookie(true)
        iocxmm.setAcceptThirdPartyCookies(jksolxzc, true)
        riospl()
        val ybhkx: Activity = this
        jksolxzc.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(eopslx: WebView, pdsoxl: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(pdsoxl)) {
                        return false
                    }
                    if (fioslzxzxcmmx(pdsoxl)) {

                        val hbjkx = Intent(Intent.ACTION_VIEW)
                        hbjkx.data = Uri.parse(pdsoxl)
                        startActivity(hbjkx)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                eopslx.loadUrl(pdsoxl)
            }


            override fun onPageFinished(eolc: WebView, kolck: String) {
                super.onPageFinished(eolc, kolck)
                gyudjxcnznxc(kolck)
            }

            override fun onReceivedError(
                xbchk: WebView,
                usaiasdi: Int,
                nkofosdofkkcx: String,
                wpsoaslldlskdsmx: String
            ) {
                Toast.makeText(ybhkx, nkofosdofkkcx, Toast.LENGTH_SHORT).show()
            }


        }
        jksolxzc.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                zosaspdlxz: WebView, todoffksfkdo: ValueCallback<Array<Uri>>,
                bnjxz: FileChooserParams
            ): Boolean {
                tyuasididjjxz?.onReceiveValue(null)
                tyuasididjjxz = todoffksfkdo
                var weieijdjnzxxz: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (weieijdjnzxxz!!.resolveActivity(packageManager) != null) {

                    var qposlxcmzm: File? = null
                    try {
                        qposlxcmzm = tyudokkmcz()
                        weieijdjnzxxz.putExtra("PhotoPath", cvhs)
                    } catch (ex: IOException) {

                    }


                    if (qposlxcmzm != null) {
                        cvhs = "file:" + qposlxcmzm.absolutePath
                        weieijdjnzxxz.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(qposlxcmzm)
                        )
                    } else {
                        weieijdjnzxxz = null
                    }
                }
                val hxzyusaasa = Intent(Intent.ACTION_GET_CONTENT)
                hxzyusaasa.addCategory(Intent.CATEGORY_OPENABLE)
                hxzyusaasa.type = "image/*"
                val mkodiidjmmxc: Array<Intent?> =
                    weieijdjnzxxz?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val bhyudjnas = Intent(Intent.ACTION_CHOOSER)
                bhyudjnas.putExtra(Intent.EXTRA_INTENT, hxzyusaasa)
                bhyudjnas.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                bhyudjnas.putExtra(Intent.EXTRA_INITIAL_INTENTS, mkodiidjmmxc)
                startActivityForResult(
                    bhyudjnas, eisa
                )
                return true
            }


            @Throws(IOException::class)
            private fun tyudokkmcz(): File {
                var zoxpx = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!zoxpx.exists()) {
                    zoxpx.mkdirs()
                }


                zoxpx =
                    File(zoxpx.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return zoxpx
            }

        }

        jksolxzc.loadUrl(gjniisamk())
    }
    private fun njkcx(rospx: String) {

        OneSignal.setExternalUserId(
            rospx,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(bncxoaos: JSONObject) {
                    try {
                        if (bncxoaos.has("push") && bncxoaos.getJSONObject("push").has("success")) {
                            val eisoacxzoc = bncxoaos.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $eisoacxzoc"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (bncxoaos.has("email") && bncxoaos.getJSONObject("email").has("success")) {
                            val aoksxxz =
                                bncxoaos.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $aoksxxz"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (bncxoaos.has("sms") && bncxoaos.getJSONObject("sms").has("success")) {
                            val cksokowksad = bncxoaos.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $cksokowksad"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun fioslzxzxcmmx(soxl: String): Boolean {

        val qpqqoskdad = packageManager
        try {

            qpqqoskdad.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    private fun gjniisamk(): String {

        val eosp = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)



        val qposl: String? = Hawk.get(TFDTYS, "null")
        val epasdoasddkas:String? = Hawk.get(QOPSL, "null")
        val yuuxnxb: String? = Hawk.get(UISDOJ, "null")


        val fisokxkzxcmzcxm = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val qposlsaldxm = "sub_id_4="
        val hxz = "com.pomelogames.bulletboy"
        val eoplsx = "naming"
        val zops = "sub_id_6="
        val rusiaikxzzxc = "deviceID="
        val xkiwwodks = "sub_id_1="
        val wwwosd = Build.VERSION.RELEASE
        val ros = "ad_id="
        val ksisokx = "deeporg"
        val tyyxggxgxhc = "sub_id_5="

        val nkoxoxcxzk = Hawk.get(hucjxmna, "null")

        var jusikx = ""
        if (epasdoasddkas != "null"){
            jusikx = "$nkoxoxcxzk$xkiwwodks$epasdoasddkas&$rusiaikxzzxc$fisokxkzxcmzcxm&$ros$yuuxnxb&$qposlsaldxm$hxz&$tyyxggxgxhc$wwwosd&$zops$eoplsx"
            njkcx(fisokxkzxcmzcxm.toString())
        } else {
            jusikx = "$nkoxoxcxzk$xkiwwodks$qposl&$rusiaikxzzxc$fisokxkzxcmzcxm&$ros$yuuxnxb&$qposlsaldxm$hxz&$tyyxggxgxhc$wwwosd&$zops$ksisokx"
            njkcx(fisokxkzxcmzcxm.toString())
        }

        Log.d("TESTAG", "Test Result $jusikx")
        return eosp.getString("SAVED_URL", jusikx).toString()
    }
    var lopxxczxcju = ""
    fun gyudjxcnznxc(foxplx: String?) {
        if (!foxplx!!.contains("t.me")) {

            if (lopxxczxcju == "") {
                lopxxczxcju = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    foxplx
                ).toString()

                val guisokxzxczxc = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val tyueisj = guisokxzxczxc.edit()
                tyueisj.putString("SAVED_URL", foxplx)
                tyueisj.apply()
            }
        }
    }

    override fun onActivityResult(rpso: Int, vjsooadk: Int, aosp: Intent?) {
        if (rpso != eisa || tyuasididjjxz == null) {
            super.onActivityResult(rpso, vjsooadk, aosp)
            return
        }
        var bjis: Array<Uri>? = null


        if (vjsooadk == AppCompatActivity.RESULT_OK) {
            if (aosp == null || aosp.data == null) {
                bjis = arrayOf(Uri.parse(cvhs))
            } else {
                val pokcxkz = aosp.dataString
                if (pokcxkz != null) {
                    bjis = arrayOf(Uri.parse(pokcxkz))
                }
            }
        }
        tyuasididjjxz?.onReceiveValue(bjis)
        tyuasididjjxz = null
    }


    private var nkcxov = false
    override fun onBackPressed() {


        if (jksolxzc.canGoBack()) {
            if (nkcxov) {
                jksolxzc.stopLoading()
                jksolxzc.loadUrl(lopxxczxcju)
            }
            this.nkcxov = true
            jksolxzc.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                nkcxov = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    private fun riospl() {
        val odfksdofokdfkmzx = jksolxzc.settings

        odfksdofokdfkmzx.javaScriptEnabled = true
        odfksdofokdfkmzx.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        odfksdofokdfkmzx.pluginState = WebSettings.PluginState.ON
        odfksdofokdfkmzx.loadWithOverviewMode = true
        odfksdofokdfkmzx.useWideViewPort = true

        odfksdofokdfkmzx.setAppCacheEnabled(true)
        odfksdofokdfkmzx.domStorageEnabled = true
        odfksdofokdfkmzx.javaScriptCanOpenWindowsAutomatically = true
        odfksdofokdfkmzx.setSupportMultipleWindows(false)

        odfksdofokdfkmzx.displayZoomControls = false
        odfksdofokdfkmzx.allowFileAccess = true
        odfksdofokdfkmzx.setSupportZoom(true)
        odfksdofokdfkmzx.userAgentString = odfksdofokdfkmzx.userAgentString.replace("; wv", "")
        odfksdofokdfkmzx.allowContentAccess = true
        odfksdofokdfkmzx.builtInZoomControls = true

    }

}