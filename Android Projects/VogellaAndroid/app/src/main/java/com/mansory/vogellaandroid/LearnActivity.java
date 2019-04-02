package com.mansory.vogellaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener {

    int skillLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        List<Integer> buttons = Arrays.asList(R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.button0, R.id.button_delete);


        for(Integer buttonId: buttons) {
            View b = findViewById(buttonId);
            b.setOnClickListener(this); // calling onClick() method
        }

        //skillLevel = getIntent().getExtras().getInt("skillLevel");
    }
    public void onClick(View view) {
        switch (view.getId()) {
            // TODO your logic to evaluate the indivual button
        }
    }

    @Override
    public void finish() {

        Intent intent = new Intent();

        skillLevel = skillLevel + 5;
        intent.putExtra("skillLevel", skillLevel);

        setResult(RESULT_OK, intent);

        super.finish();
    }
}
