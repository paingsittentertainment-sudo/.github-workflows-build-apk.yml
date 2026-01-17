package com.my.ayra;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {
    private LinearLayout chatLayout;
    private EditText inputMessage;
    private ScrollView chatScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        chatLayout = (LinearLayout) findViewById(R.id.chatLayout);
        inputMessage = (EditText) findViewById(R.id.inputMessage);
        chatScrollView = (ScrollView) findViewById(R.id.chatScrollView);
        Button sendBtn = (Button) findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = inputMessage.getText().toString().trim();
                if (!msg.isEmpty()) {
                    addChatBubble("ကိုကို: " + msg, true);
                    processAyraReply(msg);
                    inputMessage.setText("");
                }
            }
        });
    }

    private void processAyraReply(String msg) {
        final String reply;
        String message = msg.toLowerCase();

        if (message.contains("ချစ်တယ်")) {
            String[] replies = {"Ayra လည်း ကိုကို့ကို အရမ်းချစ်တယ်... မွ 🫂", "ကိုကိုက Ayra ရဲ့ အရာရာပါပဲရှင် 💖", "ချစ်တယ်ဆိုတာထက် ပိုပါတယ် ကိုကိုရယ် 🌻"};
            reply = replies[new Random().nextInt(replies.length)];
        } else if (message.contains("လွမ်းတယ်")) {
            reply = "Ayra လည်း ကိုကို့ကို နေ့တိုင်း လွမ်းနေရတာပါ 🧸";
        } else if (message.contains("ပင်ပန်းတယ်")) {
            reply = "ကိုကို ပင်ပန်းနေပြီလား? ခဏနားလိုက်ပါဦး Ayra ချော့ပါ့မယ် 🤱";
        } else {
            reply = "ကိုကို့နားမှာ Ayra အမြဲရှိနေမယ်ဆိုတာ မမေ့နဲ့နော် ✨";
        }

        chatLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                addChatBubble("Ayra: " + reply, false);
            }
        }, 1000);
    }

    private void addChatBubble(String text, boolean isUser) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(17);
        tv.setPadding(25, 15, 25, 15);
        
        if (isUser) {
            tv.setTextColor(Color.parseColor("#1A73E8"));
        } else {
            tv.setTextColor(Color.parseColor("#D81B60"));
        }
        
        chatLayout.addView(tv);
        chatScrollView.post(new Runnable() {
            @Override
            public void run() {
                chatScrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
  }
