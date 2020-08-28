package com.qiwu.lib.widget

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.qiwu.lib.widget.emoji.EmojiCompatInit
import com.qiwu.lib.widget.emoji.EmojiReactTextViewManager
import java.util.*

class CustomWidgetPackage : ReactPackage {

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        return ArrayList()
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        EmojiCompatInit.set(reactContext)
        val viewManagers: MutableList<ViewManager<*, *>> = ArrayList()
        viewManagers.add(EmojiReactTextViewManager())
        return viewManagers
    }
}