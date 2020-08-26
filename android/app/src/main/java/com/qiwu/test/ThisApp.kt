package com.qiwu.test

import android.app.Application
import com.facebook.react.BuildConfig
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage
import com.qiwu.test.widget.CustomWidgetPackage
import java.util.*

class ThisApp : Application() {

    companion object {
        var sReactInstanceManager : ReactInstanceManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        val packages = ArrayList<ReactPackage>();
        packages.add(MainReactPackage())
        packages.add(CustomWidgetPackage())
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(new MyReactNativePackage());
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.
        sReactInstanceManager = ReactInstanceManager.builder()
            .setApplication(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackages(packages)
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.BEFORE_CREATE)
            .build()
    }


}