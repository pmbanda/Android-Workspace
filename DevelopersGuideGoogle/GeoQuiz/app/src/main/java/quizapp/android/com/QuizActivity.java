package quizapp.android.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("FieldCanBeLocal")
public class QuizActivity extends AppCompatActivity {

    // constant fields declaration maintained on all the objects instance and statics
    private final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final String CHEAT_INDEX = "cheater";
    private static final int REQUEST_CODE_CHEAT = 0;
    private boolean mIsCheater;

    // Fields for class instance
    @SuppressWarnings("FieldCanBeLocal")
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private ImageButton mPreviousButton;
    private ImageButton mNextButton;
    private TextView mQuestionTextView;

    private final Question[] mQuestionBank = new Question[]{

            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_obama, true),
            new Question(R.string.question_strawberry, true),

    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // check the bundle instance
        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0); // assign default if value not found
            mIsCheater = savedInstanceState.getBoolean(CHEAT_INDEX, false); // assign default if value not found
        }


        Log.d(TAG, "onCreate(bundle) called: "); // debugging log message

        // Set the first question connected to the first reference
        mQuestionTextView = findViewById(R.id.question_text_view);
        updateQuestion();

        // Set listener for the True button
        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(view -> {
            //Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            checkAnswer(true);
        });

        // Set listener for the False button
        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(view -> {
            //Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            checkAnswer(false);
        });

        // Set listener for the Previous button
        mPreviousButton = findViewById(R.id.previous_button);

        mPreviousButton.setOnClickListener(view -> {
            // Increment the index
            if (mCurrentIndex >= 1)
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
            else
                mCurrentIndex = 0;

            updateQuestion();

        });

        // Set listener for the Cheat button
        mCheatButton = findViewById(R.id.cheat_button);

        mCheatButton.setOnClickListener(view -> {

            // start cheat activity
            Toast.makeText(QuizActivity.this, R.string.title_activity_cheat, Toast.LENGTH_SHORT).show();

            // Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
            // Encapsulate Intent method

            boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
            Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);

            // TODO: Start intent without need for result
            //startActivity(intent); // Start the intent

            // TODO: Retrieve result from sub intent
            startActivityForResult(intent, REQUEST_CODE_CHEAT);

        });

        // Set listener for the Next button
        mNextButton = findViewById(R.id.next_button);

        mNextButton.setOnClickListener(view -> {
            // Increment the index
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            mIsCheater = false;
            updateQuestion();

        });
    }

    // Update question
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        //Log.d(TAG, "Updating question text for question #" + mCurrentIndex, new Exception());
        mQuestionTextView.setText(question);
    }

    // Check questions boolean value
    private void checkAnswer(boolean userPressedTrue) {

        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId;

        // check if the user cheated
        if (mIsCheater) {

            messageResId = R.string.judgment_toast;

        } else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }


        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK || data == null) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHEAT)
            mIsCheater = CheatActivity.wasAnswerShown(data);
    }

    // Override bundle to maintain the configuration change during the objects runtime
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState(bundle)");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        savedInstanceState.putBoolean(CHEAT_INDEX, mIsCheater);
    }

    // Android life cycle events and methods

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called: "); // debugging log message
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called: "); // debugging log message
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called: "); // debugging log message
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called: "); // debugging log message
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called: "); // debugging log message
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.quiz, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//
//    }


}
