package com.ayra.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.graphics.Color;
import android.view.WindowManager;
import android.view.ViewGroup;

public class ChatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Keyboard auto popup
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        );

        // Root layout
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.BLACK);
        root.setPadding(30, 30, 30, 30);

        // Chat area (placeholder)
        TextView title = new TextView(this);
        title.setText("Ayra Chat");
        title.setTextColor(Color.WHITE);
        title.setTextSize(20);
        title.setPadding(0, 0, 0, 20);

        // Input field
        EditText input = new EditText(this);
        input.setHint("စာရိုက်လို့ ရပါပြီ ကိုကို...");
        input.setHintTextColor(Color.GRAY);
        input.setTextColor(Color.WHITE);
        input.requestFocus();

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        root.addView(title, params);
        root.addView(input, params);

        setContentView(root);
    }
    }
