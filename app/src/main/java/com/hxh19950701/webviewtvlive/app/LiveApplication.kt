package com.hxh19950701.webviewtvlive.app

import android.app.Application
import com.hxh19950701.webviewtvlive.misc.setApplication
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.QbSdk.PreInitCallback

class LiveApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setApplication(this)
        cacheDir.listFiles()?.forEach { it.delete() }
        QbSdk.initX5Environment(this, object : PreInitCallback {
            override fun onCoreInitFinished() = Unit
            override fun onViewInitFinished(isX5: Boolean) = Unit
        })
    }
}