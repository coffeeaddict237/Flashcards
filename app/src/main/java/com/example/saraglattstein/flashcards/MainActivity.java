package com.example.saraglattstein.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvSign;
    private TextView tvGen;
    private TextView tvAnswer;

    private EditText input;

    private Button btn;

    private int no1;
    private int no2;
    private int answer;

    private int correct = 0;
    private int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);
        tvSign = findViewById(R.id.tvSign);
        tvGen = findViewById(R.id.tvGen);
        tvAnswer = findViewById(R.id.tvAnswer);

        input = findViewById(R.id.input);
        btn = findViewById(R.id.btn);

        generate();

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //check if correct, update correct, toast if needed or generate new
                String response = input.getText().toString();
                if(current == 10) {
                    //Toast to your accomplishments
                    Log.e("Testing","Finished");
                    if( response.equals(Integer.toString(answer))) {
                        correct++;
                    }
                    Toast.makeText(MainActivity.this, correct + " out of 10", Toast.LENGTH_SHORT).show();
                }
                else {

                    if( response.equals(Integer.toString(answer))) {
                        Log.e("Testing","Correct!");
                        correct++;
                        generate();
                    }
                    else {
                        Log.e("Testing","Incorrect!");
                        generate();
                    }
                }
            }
        };
        btn.setOnClickListener(onClickListener);
    }

    public void generate() {
        current++;
        no2 = (int) (Math.random()*10)+1;
        answer = (int) (Math.random()*10)+1;
        no1 = no2 * answer;
        tvOne.setText(Integer.toString(no1));
        tvTwo.setText(Integer.toString(no2));
        Log.e("Testing","Question " + current);
        Log.e("Testing","New question: " + no1 + " / " + no2 + " = " + answer);
    }
}
