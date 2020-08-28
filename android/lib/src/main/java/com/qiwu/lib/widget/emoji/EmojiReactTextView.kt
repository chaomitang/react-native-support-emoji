package com.qiwu.lib.widget.emoji

import android.annotation.SuppressLint
import android.content.Context
import android.text.InputFilter
import android.view.ActionMode
import androidx.core.widget.TextViewCompat
import androidx.emoji.widget.EmojiTextViewHelper
import com.facebook.react.views.text.ReactTextView

class EmojiReactTextView(context: Context) : ReactTextView(context) {

    private var mEmojiTextViewHelper: EmojiTextViewHelper? = null

    /**
     * Prevent calling [.init] multiple times in case super() constructors
     * call other constructors.
     */
    private var mInitialized = false

    init {
        if (!mInitialized) {
            mInitialized = true
            getEmojiTextViewHelper().updateTransformationMethod()
        }
    }

    override fun setFilters(filters: Array<InputFilter?>?) {
        super.setFilters(getEmojiTextViewHelper().getFilters(filters!!))
    }

    override fun setAllCaps(allCaps: Boolean) {
        super.setAllCaps(allCaps)
        getEmojiTextViewHelper().setAllCaps(allCaps)
    }

    private fun getEmojiTextViewHelper(): EmojiTextViewHelper {
        if (mEmojiTextViewHelper == null) {
            mEmojiTextViewHelper = EmojiTextViewHelper(this)
        }
        return mEmojiTextViewHelper!!
    }

    /**
     * See
     * [TextViewCompat.setCustomSelectionActionModeCallback]
     */
    @SuppressLint("RestrictedApi")
    override fun setCustomSelectionActionModeCallback(actionModeCallback: ActionMode.Callback?) {
        super.setCustomSelectionActionModeCallback(
            TextViewCompat
                .wrapCustomSelectionActionModeCallback(this, actionModeCallback!!)
        )
    }
}