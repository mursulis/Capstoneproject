package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

public class Settings extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView btn = (TextView) findViewById(R.id.citySelect);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, opening.class));
            }
        });

        textView = findViewById(R.id.AppWebsite);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView = findViewById(R.id.PrivacyPolicy);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}