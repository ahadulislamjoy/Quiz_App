package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button button1,button2,next_Button;
    private TextView questionTextView;
    private int currentQuestionIndex = 0;

    private Question[] question = new Question[]{
            new Question(R.string.text_name1,true),
            new Question(R.string.text_name2,false),
            new Question(R.string.text_name3,false),
            new Question(R.string.text_name4,true),
            new Question(R.string.text_name5,false),
            new Question(R.string.text_name6,true),
            new Question(R.string.text_name7,false),
            new Question(R.string.text_name8,false),
            new Question(R.string.text_name9,true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.true_button_Id);
        button2 = findViewById(R.id.false_button_Id);
        next_Button = findViewById(R.id.next_button_Id);
        questionTextView = findViewById(R.id.question_text_view_id);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        next_Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.true_button_Id:
                checkAnswer(true);
               // Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_SHORT).show();
                break;
            case R.id.false_button_Id:
                checkAnswer(false);
                //Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();
                break;
            case R.id.next_button_Id:
                currentQuestionIndex = (currentQuestionIndex+1)%question.length ;
                updateQuestion();
        }

    }
    private void updateQuestion(){
        Log.d("current", "onClick: "+currentQuestionIndex);
        questionTextView.setText(question[currentQuestionIndex].getAnsResId());
    }
    private void checkAnswer(boolean userChooseCorrect){
        boolean answerIsTrue = question[currentQuestionIndex].isAnsTrue();
        int toastMessageId = 0;
        if (userChooseCorrect == answerIsTrue){
            toastMessageId = R.string.correct_answer;
        }else{
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(getApplicationContext(), toastMessageId, Toast.LENGTH_SHORT).show();

    }
}