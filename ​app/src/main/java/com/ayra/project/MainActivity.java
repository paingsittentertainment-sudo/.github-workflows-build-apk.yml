package com.ayra.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // အသစ်မှန်းသိသာအောင် နောက်ခံကို အနီရောင် (RED) အရင်စမ်းပါမယ်
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.RED); 
        layout.setPadding(40, 40, 40, 40);

        TextView text = new TextView(this);
        text.setText("AYRA FINAL PROJECT 🚀");
        text.setTextColor(Color.WHITE);
        text.setTextSize(24);
        text.setGravity(Gravity.CENTER);
        layout.addView(text);

        // စာရိုက်ကွက် (Keyboard သေချာပေါက်ပါရမည်)
        EditText input = new EditText(this);
        input.setHint("ဒီမှာ စာရိုက်ပါ ကိုကို...");
        input.setBackgroundColor(Color.WHITE);
        input.setTextColor(Color.BLACK);
        input.setPadding(30, 30, 30, 30);
        layout.addView(input);

        Button btn = new Button(this);
        btn.setText("SEND");
        layout.addView(btn);

        setContentView(layout);
    }
                                 }
