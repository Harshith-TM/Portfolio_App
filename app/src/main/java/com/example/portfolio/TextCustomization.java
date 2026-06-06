package com.example.portfolio;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextCustomization {
    String text, top, bottom, finalText;
    SpannableString spannableString;
    String[] parts;

    public void HighlightsTextColor(TextView textView) {
        text = textView.getText().toString();
        parts = text.split("\n", 2);
        top = parts[0];
        bottom = parts[1];
        finalText = top + "\n" + bottom;
        spannableString = new SpannableString(finalText);

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#89E900")), 0, top.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.3f), 0, top.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
    }
    public SpannableString TitleTextColor(String textView){
        text = textView;
        parts = text.split("\n", 2);
        if (parts.length<2){
            return new SpannableString(text);
        }
        top = parts[0];
        bottom = parts[1];
        finalText = top + "\n" + bottom;
        spannableString = new SpannableString(finalText);

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), top.length() + 1, finalText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
    public void LabelUnderLine(TextView textView){
        SpannableString labelString = new SpannableString(textView.getText().toString());
        labelString.setSpan(new CustomUnderLineSpan(), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(labelString);
    }
    public static class CustomUnderLineSpan extends ReplacementSpan {

        @Override
        public int getSize(@NonNull Paint paint, CharSequence text, int start, int end,
                           @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(text, start, end);
        }

        @Override
        public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x,
                         int top, int y, int bottom, @NonNull Paint paint) {
            canvas.drawText(text, start, end, x, y, paint);
            float textWidth = paint.measureText(text, start, end);

            int oldColor = paint.getColor();
            paint.setColor(Color.parseColor("#89E900"));
            paint.setStyle(Paint.Style.FILL);
            float underlineHeight = 6f;
            float radius = 10f;

            canvas.drawRoundRect(
                    x,
                    y + 14,
                    x + textWidth,
                    y + 14 + underlineHeight,
                    radius,
                    radius,
                    paint
            );

            paint.setColor(oldColor);
        }
    }

}