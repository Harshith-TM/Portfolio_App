package com.example.portfolio;

import android.os.Handler;
import android.widget.TextView;

public class AutoTypingText {

    private final String[] titles = {"Harshith\nTM","An Android\nDeveloper"};
    private String currentText,fullText;
    private int textIndex = 0;
    private int charIndex = 0;
    private boolean isDeleting = false;
    private final Handler handler = new Handler();
    private final TextCustomization textCustomization = new TextCustomization();

    public void TypingAnimation(TextView textView)
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                fullText = titles[textIndex];

                if(!isDeleting){
                    charIndex++;
                    if (charIndex>fullText.length()){
                        if (textIndex==titles.length-1){return;}
                        isDeleting = true;
                        handler.postDelayed(this,1000);
                        return;
                    }
                }else{
                    charIndex--;
                    if (charIndex<0){
                        isDeleting = false;
                        textIndex++;
                        charIndex = 0;
                        handler.postDelayed(this,500);
                        return;
                    }
                }
                currentText = fullText.substring(0, charIndex);
                textView.setText(textCustomization.TitleTextColor(currentText));
                handler.postDelayed(this,isDeleting?80:150);
            }
        };
        handler.post(runnable);
    }
}