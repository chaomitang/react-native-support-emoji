package com.qiwu.lib.widget.emoji

import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.views.text.ReactTextAnchorViewManager
import com.facebook.react.views.text.ReactTextShadowNode
import com.facebook.react.views.text.ReactTextUpdate
import com.facebook.react.views.text.TextInlineImageSpan
import javax.annotation.Nonnull

class EmojiReactTextViewManager : ReactTextAnchorViewManager<EmojiReactTextView, ReactTextShadowNode>() {
    val NAME = "EmojiText"

    @Nonnull
    override fun getName(): String {
        return NAME
    }

    override fun createViewInstance(context: ThemedReactContext): EmojiReactTextView {
        return EmojiReactTextView(context)
    }

    override fun updateExtraData(
        @Nonnull view: EmojiReactTextView,
        extraData: Any
    ) {
        val update = extraData as ReactTextUpdate
        if (update.containsImages()) {
            val spannable = update.text
            TextInlineImageSpan.possiblyUpdateInlineImageSpans(spannable, view)
        }
        view.setText(update)
    }

    override fun createShadowNodeInstance(): ReactTextShadowNode? {
        return ReactTextShadowNode()
    }

    override fun getShadowNodeClass(): Class<out ReactTextShadowNode>? {
        return ReactTextShadowNode::class.java
    }

    override fun onAfterUpdateTransaction(view: EmojiReactTextView) {
        super.onAfterUpdateTransaction(view)
        view.updateView()
    }

    override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any>? {
        return MapBuilder.of(
            "topTextLayout",
            MapBuilder.of("registrationName", "onTextLayout")
        )
    }
}
