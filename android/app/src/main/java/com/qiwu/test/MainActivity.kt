package com.qiwu.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.ReactRootView


class MainActivity : AppCompatActivity() {
    private var mReactRootView: ReactRootView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mReactRootView = ReactRootView(this)
        mReactRootView?.startReactApplication(ThisApp.sReactInstanceManager, "TestReactSupportEmojiApp", null)

        setContentView(mReactRootView)
    }
}