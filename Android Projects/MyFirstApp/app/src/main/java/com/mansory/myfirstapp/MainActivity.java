package com.mansory.myfirstapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import junit.runner.Version;

public class MainActivity extends AppCompatActivity {

    private static EditText message;
    public static final String EXTRA_MESSAGE = "com.mansory.myfirstapp.Message "; // class name as tag
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: message pointer from the edit text box
        message = (EditText)findViewById(R.id.edit_text_message_MA);
    }

    public void sendMessage(View view) {

        //TODO: retrieve string message from edit text box
        String messageString = message.getText().toString();
        // TODO: new intent instance
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, messageString);
        startActivity(intent);
    }
}
