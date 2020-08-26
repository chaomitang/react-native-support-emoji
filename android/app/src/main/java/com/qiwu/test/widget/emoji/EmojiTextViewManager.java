package com.qiwu.test.widget.emoji;

import android.text.Spannable;

import androidx.annotation.NonNull;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.text.ReactTextAnchorViewManager;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Author：qi.wu
 * Date：2020/8/18
 */
public class EmojiTextViewManager extends ReactTextAnchorViewManager<EmojiReactTextView, ReactTextShadowNode> {
    private static final String NAME = "SZEmojiText";

    @Nonnull
    @Override
    public String getName() {
        return NAME;
    }

    @Nonnull
    @Override
    protected EmojiReactTextView createViewInstance(@Nonnull ThemedReactContext reactContext) {
        return new EmojiReactTextView(reactContext);
    }

    @Override
    public void updateExtraData(@Nonnull EmojiReactTextView view, Object extraData) {
        ReactTextUpdate update = (ReactTextUpdate) extraData;
        if (update.containsImages()) {
            Spannable spannable = update.getText();
            TextInlineImageSpan.possiblyUpdateInlineImageSpans(spannable, view);
        }
        view.setText(update);
    }

    @Override
    public ReactTextShadowNode createShadowNodeInstance() {
        return new ReactTextShadowNode();
    }

    @Override
    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }

    @Override
    protected void onAfterUpdateTransaction(@NonNull EmojiReactTextView view) {
        super.onAfterUpdateTransaction(view);
        view.updateView();
    }

    @Override
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("topTextLayout", MapBuilder.of("registrationName", "onTextLayout"));
    }
}
