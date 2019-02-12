package com.mansory.vogellaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
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

        Log.i(TAG, "Data..... Text");
        Log.i(TAG, openBrowserIntent.toString());
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // obtain value from the result
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                Toast toast = new Toast(this);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.makeText(this, data.getStringExtra("return1"),
                        Toast.LENGTH_SHORT).show();

                Toast.makeText(this, data.getStringExtra("return2"),
                        Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

   /* @Override
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
*/