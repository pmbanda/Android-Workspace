package com.mansory.vogellaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserOverviewActivity extends AppCompatActivity {

    public static final int SUB_ACTIVITY_CREATE_USER = 10;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_overview);


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == SUB_ACTIVITY_CREATE_USER && resultCode == RESULT_OK){
//            Bundle extras = data.getExtras();
//
//            if (extras != null) {
//                String name = extras.getString(User.USER_NAME);
//                boolean gender = extras.getBoolean(User.USER_GENDER);
//                user = new User(name, gender);
//                updateUserInterface();
//            }
//        }
//    }
//
//    private void updateUserInterface() {
//        // TODO show the new user values in the UI
//
//    }
}
