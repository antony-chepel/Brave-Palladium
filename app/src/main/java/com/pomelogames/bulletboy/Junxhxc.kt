package com.pomelogames.bulletboy

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk

class Junxhxc : Application() {
    companion object {
        const val eisokxzl = "00a756a3-35ac-4f81-9106-8255dd78d1d9"
        var UISDOJ: String? = ""
        var QOPSL: String? = "c11"
        var hysuzx = "appsChecker"
        var TFDTYS: String? = "d11"
        var hucjxmna = "link"
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(eisokxzl)

        Hawk.init(this).build()


    }
}