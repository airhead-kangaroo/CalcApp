package jp.techacademy.hideto.uetsuka.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private enum BtnFlag{PLUS,MINUS,MULTIPLE,DIVINE}
    private BtnFlag btnFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFlag = null;
    }

    void plusBtn(View v){
        btnFlag = BtnFlag.PLUS;
        calc();
    }
    void minusBtn(View v){
        btnFlag = BtnFlag.MINUS;
        calc();
    }
    void multipleBtn(View v){
        btnFlag = BtnFlag.MULTIPLE;
        calc();
    }
    void divineBtn(View v){
        btnFlag = BtnFlag.DIVINE;
        calc();
    }

    private void calc(){
        EditText editText1 = (EditText)findViewById(R.id.first);
        EditText editText2 = (EditText)findViewById(R.id.second);
        double first, second;
        double answer = 0.0;
        try {
            first = Double.parseDouble(editText1.getText().toString());
            second = Double.parseDouble(editText2.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "数字を入力してください",Toast.LENGTH_SHORT).show();
            return;
        }
        switch (btnFlag){
            case PLUS:
                answer = first + second;
                break;
            case MINUS:
                answer = first - second;
                break;
            case MULTIPLE:
                answer = first * second;
                break;
            case DIVINE:
                if(second == 0){
                    Toast.makeText(this, "０では割れません",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    answer = first / second;
                }
                break;
            default:
                return;
        }
        Intent intent = new Intent(this,AnswerActivity.class);
        intent.putExtra("Value", String.valueOf(answer));
        startActivity(intent);
    }
}
