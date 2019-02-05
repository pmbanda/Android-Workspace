package com.mansory.vogellaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    private TextView data1;
    private TextView data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // obtain the intent to display
        Intent i = getIntent();
        String dataText1 = i.getStringExtra("Value1");
        String dataText2 = i.getStringExtra("Value2");

        data1 = (TextView) findViewById(R.id.text_view_data1);
        data2 = (TextView) findViewById(R.id.text_view_data2);

        data1.setText(dataText1);
        data2.setText(dataText2);
    }
}
