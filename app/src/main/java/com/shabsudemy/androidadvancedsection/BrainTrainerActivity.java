package com.shabsudemy.androidadvancedsection;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Random;

public class BrainTrainerActivity extends AppCompatActivity {

    Button goButton, answerButton0, answerButton1, answerButton2, answerButton3,playAgainButton;
    CardView cardView;
    TextView questionText, correctOrWrongText, scoreCounterText,timerCounterText;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    Random random = new Random();
    int correctAnswerLocationIndex, score = 0, numberOfQuestion = 0, actualAnswer = 0;
    CountDownTimer ct;
    RelativeLayout rL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_trainer);

        goButton = (Button) findViewById(R.id.goButton);
        cardView = (CardView) findViewById(R.id.goButtonCard);
        questionText = (TextView) findViewById(R.id.questionText);
        correctOrWrongText = (TextView) findViewById(R.id.correctOrWrongText);
        scoreCounterText = (TextView) findViewById(R.id.scoreCounterText);
        answerButton0 = (Button) findViewById(R.id.answerButton0);
        answerButton1 = (Button) findViewById(R.id.answerButton1);
        answerButton2 = (Button) findViewById(R.id.answerButton2);
        answerButton3 = (Button) findViewById(R.id.answerButton3);
        timerCounterText = (TextView) findViewById(R.id.timerCounterText);
        playAgainButton = (Button) findViewById(R.id.playAgain);
        rL = (RelativeLayout) findViewById(R.id.mainAppRLayout);

        ct = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerCounterText.setText(String.valueOf(millisUntilFinished/1000) +"s");
            }

            @Override
            public void onFinish() {
//                timerCounterText.setText(String.valueOf(0)+"s");
                playAgainButton.setVisibility(View.VISIBLE);
                correctOrWrongText.setText("Your Score: "+String.valueOf(score)+"/"+String.valueOf(numberOfQuestion));

            }
        };


        generateNextQuestion();

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goButton.setVisibility(View.INVISIBLE);
                cardView.setVisibility(View.INVISIBLE);
                rL.setVisibility(View.VISIBLE);
                ct.start();
            }
        });

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNextQuestion();
                ct.cancel();
                ct.start();
                correctOrWrongText.setVisibility(View.INVISIBLE);
            }
        });




    }

    public void generateNextQuestion() {
        answers.clear();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        actualAnswer = a + b;
        correctAnswerLocationIndex = random.nextInt(4);

        questionText.setText(String.valueOf(a) + "+" + String.valueOf(b));

        for (int i = 0; i < 4; i++) {
            if (i == correctAnswerLocationIndex) {
                answers.add(actualAnswer);
            } else {
                int randoAnswer = random.nextInt(41);
                while (randoAnswer == actualAnswer) {
                    randoAnswer = random.nextInt(41);
                }
                answers.add(randoAnswer);
            }
        }
        numberOfQuestion++;
        scoreCounterText.setText(String.valueOf(score) + "/" + String.valueOf(numberOfQuestion));
        answerButton0.setText(String.valueOf(answers.get(0)));
        answerButton1.setText(String.valueOf(answers.get(1)));
        answerButton2.setText(String.valueOf(answers.get(2)));
        answerButton3.setText(String.valueOf(answers.get(3)));
        playAgainButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view) {
        Log.i("brainApp", view.getTag().toString());
        if (Integer.parseInt(view.getTag().toString()) == correctAnswerLocationIndex) {
            correctOrWrongText.setText("Correct");
            correctOrWrongText.setVisibility(View.VISIBLE);
            score++;
        } else {
            correctOrWrongText.setText("Wrong");
            correctOrWrongText.setVisibility(View.VISIBLE);
        }
        generateNextQuestion();
    }
}