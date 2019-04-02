package quizapp.android.com;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("FieldCanBeLocal")
public class CheatActivity extends AppCompatActivity {

    // constant fields declaration maintained on all the objects instance and statics
    private final String TAG = "CheatActivity";
    private static final String EXTRA_ANSWER_IS_TRUE = "quizapp.android.com.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "quizapp.android.com.geoquiz.answer_shown";

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private TextView mBuildLevelText;
    public static int mBuildLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // show the build level
        mBuildLevelText = findViewById(R.id.build_text);

        getApiLevel();

        // retrieve the boolean value from the communicating intent
        Intent intent = getIntent();
        mAnswerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = findViewById(R.id.answer_text_view);

        mShowAnswer = findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(view -> {
            if (mAnswerIsTrue)
                mAnswerTextView.setText(R.string.true_button);
            else
                mAnswerTextView.setText(R.string.false_button);

            setAnswerShownResult(true);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                int cx = mShowAnswer.getWidth() / 2;
                int cy = mShowAnswer.getHeight() / 2;
                float radius = mShowAnswer.getWidth();
                Animator anim = ViewAnimationUtils
                        .createCircularReveal(mShowAnswer, cx, cy, radius, 0);
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mAnswerTextView.setVisibility(View.VISIBLE);
                        mShowAnswer.setVisibility(View.INVISIBLE);
                    }
                });
                anim.start();

            } else {

                mAnswerTextView.setVisibility(View.VISIBLE);
                mShowAnswer.setVisibility(View.INVISIBLE);
            }
        });


    }

    private void getApiLevel() {

        mBuildLevel = Build.VERSION.SDK_INT;
        // get build level
        if(mBuildLevel > 0) {
            mBuildLevelText.setText("Api Level " + mBuildLevel);
        }
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }
}
