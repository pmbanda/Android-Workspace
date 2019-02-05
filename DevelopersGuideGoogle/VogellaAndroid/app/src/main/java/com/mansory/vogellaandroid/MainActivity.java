package com.mansory.vogellaandroid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "com.mansory.vogellaandroid";
    private final int REQUEST_CODE = 300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void passData(View view) {
        Intent i = new Intent(this, DisplayMessage.class);
        i.putExtra("Value1", "Value one for Display Message Activity");
        i.putExtra("Value2", "Value two for Display Message Activity");

        // set the request code to any code you like,
        // you can identify the callback via this code
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey1")) {
                Toast.makeText(this, data.getExtras().getString("returnKey1"),
                        Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("returnKey1", "Swinging on a star. ");
        data.putExtra("returnKey2", "You could be better then you are. ");

        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }

    public void getMessage(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com/"));
        startActivity(i);
        Log.i(TAG, "Hierba..............");
        Log.i(TAG, i.toString());
    }

    public static boolean isIntentAvailable(Context ctx, Intent intent) {

        final PackageManager mgr = ctx.getPackageManager();
        List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}
