package com.mansory.vogellaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // private methods declaration
    public static String TAG = "com.mansory.vogellaandroid.MainActivity";
    private final int REQUEST_CODE = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void resultOnClick(View view) {
        // intent declaration
        Intent intent = new Intent(this, DisplayMessage.class);
        intent.putExtra("1", "Value (One) for Activity2");
        intent.putExtra("2", "Value (Two) for Activity2");

        // set the request code to any code you like,
        // you can identify the callback via this code
        startActivityForResult(intent,REQUEST_CODE);
    }
    public void submitOnClick(View view) {
        // intent declaration
        Intent intent = new Intent(this, DisplayMessage.class);
        intent.putExtra("1", "Value (One) for Activity2");
        intent.putExtra("2", "Value (Two) for Activity2");

        // start Target activity + com.mansory.vogellaandroid.DisplayMessage
        startActivity(intent);
    }
    public void dataOnClick(View view) {
        // intent instance for browser view
        Intent openBrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com/"));
        startActivity(openBrowserIntent);

    }
    public void callOnClick(View view) {
        // intent instance for browser view
        Intent callIFace = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "4054044141"));
        startActivity(callIFace);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // obtain value from the result
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                Toast.makeText(this, data.getStringExtra("return2"),
                        Toast.LENGTH_SHORT).show();
                Log.e(TAG, Integer.toString(resultCode));
                Log.e(TAG, Integer.toString(requestCode));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

