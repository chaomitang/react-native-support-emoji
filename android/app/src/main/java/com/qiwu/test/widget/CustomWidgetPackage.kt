package com.qiwu.test.widget

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.qiwu.test.widget.emoji.EmojiCompatInit
import com.qiwu.test.widget.emoji.EmojiTextViewManager
import java.util.*

class CustomWidgetPackage : ReactPackage {

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        return ArrayList()
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        EmojiCompatInit.set(reactContext)
        val viewManagers: MutableList<ViewManager<*, *>> = ArrayList()
        viewManagers.add(EmojiTextViewManager())
        return viewManagers
    }
}