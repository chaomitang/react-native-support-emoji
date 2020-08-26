package com.qiwu.test.widget.emoji

import android.content.Context
import android.util.Log
import androidx.emoji.bundled.BundledEmojiCompatConfig
import androidx.emoji.text.EmojiCompat

class EmojiCompatInit {

    companion object {
        var already : Boolean? = null

        fun set(context: Context) {
            already?.let {
                return
            }
            try {
                val config: EmojiCompat.Config = BundledEmojiCompatConfig(context)
                EmojiCompat.init(config)
                already = true
            } catch (e: NoClassDefFoundError) {
                Log.e(
                    "SZEmojiTextViewManager",
                    "Emoji load failed, maybe you pkg is wrong with androidx"
                )
            }
        }
    }
}