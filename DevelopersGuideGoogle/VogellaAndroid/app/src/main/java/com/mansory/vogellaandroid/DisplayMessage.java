package com.mansory.vogellaandroid;

import android.content.Intent;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.util.Log.println;

public class DisplayMessage extends AppCompatActivity {

    // private variables
    private TextView textData1;
    private TextView textData2;
    private static String TAG = "com.mansory.vogellaandroid.DisplayMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String dataText1 = intent.getStringExtra("1");
        String dataText2 = intent.getStringExtra("2");

        textData1 = (TextView) findViewById(R.id.txtData1);
        textData2 = (TextView) findViewById(R.id.txtData2);

        textData1.setText(dataText1);
        textData2.setText(dataText2);
    }
    @Override
    public void finish() {
        // Prepare data intent for return to the caller
        Intent data = new Intent();
        data.putExtra("return1", "DisplayMessage:: Swinging on a star. ");
        data.putExtra("return2", "DisplayMessage:: You could be better then you are. ");

        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }
}
