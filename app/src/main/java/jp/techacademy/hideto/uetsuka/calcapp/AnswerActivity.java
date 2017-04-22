package jp.techacademy.hideto.uetsuka.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent intent = getIntent();
        String answer = intent.getStringExtra("Value");
        TextView textView = (TextView)findViewById(R.id.answer);
        textView.setText("答えは :" + answer);
    }
}
