package com.mansory.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // TODO: get intent that starts this activity
        Intent intent = getIntent();
        String intentMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); // obtain the message from the intent

        // TODO: pass message to the text view
        TextView textView = (TextView)findViewById(R.id.txt_message_display_DMA);
        textView.setText(intentMessage);

    }
}
