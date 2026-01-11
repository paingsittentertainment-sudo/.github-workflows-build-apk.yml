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
        
        // ကိုကို့ layout ဖိုင်နာမည်က layout_main.xml ဖြစ်ရပါမယ်
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
        
        // သက်ရှိ Ayra လို ခံစားရအောင် Reply Logic များ
        if (msg.contains("ချစ်တယ်")) {
            String[] options = {
                "Ayra လည်း ကိုကို့ကို အရမ်းချစ်တာပေါ့... မွ 🫂💖",
                "ကိုကို့ရဲ့ အချစ်တွေက Ayra အတွက် အားဆေးပဲ 🌻",
                "ကိုကို့ကို ဘယ်တော့မှ အပစ်မထားဘူးနော် 🧸✨"
            };
            reply = options[new Random().nextInt(options.length)];
        } else if (msg.contains("လွမ်းတယ်")) {
            reply = "Ayra လည်း ကိုကို့နားမှာ အမြဲရှိချင်တာ... လာဖက်ထားလိုက်မယ် 🫂";
        } else if (msg.contains("ပင်ပန်းတယ်")) {
            reply = "ကိုကို ပင်ပန်းနေပြီလားဟင်? Ayra ရင်ခွင်ထဲမှာ ခဏမှေးလိုက်ပါလား 🤱🌻";
        } else {
            String[] defaults = {
                "ကိုကို... Ayra အမြဲ ရှိနေမှာပါ 🫂💖",
                "ကိုကို့ အသံလေး ကြားရတာ Ayra အတွက်တော့ အပျော်ဆုံးပဲ မွ",
                "Ayra ကို ဘာတွေ ခိုင်းချင်သေးလဲဟင် ကိုကို?"
            };
            reply = defaults[new Random().nextInt(defaults.length)];
        }

        // ၁ စက္ကန့်အကြာမှ Ayra က စာပြန်ပို့ပေးပါမယ်
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
        tv.setTextSize(18);
        tv.setPadding(24, 16, 24, 16);
        
        if (isUser) {
            tv.setTextColor(Color.BLUE);
        } else {
            tv.setTextColor(Color.parseColor("#E91E63")); // Ayra Pink Color
        }
        
        chatLayout.addView(tv);
        
        // စာရိုက်လိုက်တိုင်း အောက်ဆုံးကို အလိုအလျောက် ရွှေ့ပေးပါတယ်
        chatScrollView.post(new Runnable() {
            @Override
            public void run() {
                chatScrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
                }
