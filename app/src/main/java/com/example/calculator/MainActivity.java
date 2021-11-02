package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // private static final String TAG = "Main_Activity";

    //private TextView text_expression, text_result;
    //private Button btn[] = new Button[20];
    //private int i = 0;

    private TextView text_expression, text_result;

    private Button add,sub,mul,div,del;
    private Button record;
    private Button result;

    //연산 결과 저장
    private String history = "";
    //피연산자1
    private String number1 = "";
    //피연산자2
    private String number2 = "";

    //연산자 확인 int형 type변수 설정
    private int type;

    private int ADD = 0;
    private int SUB = 1;
    private int MUL = 2;
    private int DIV = 3;

    //private Integer i1;
    //private Integer i2;
    private double d1;
    private double d2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_expression = findViewById(R.id.text_expression);
        text_result = findViewById(R.id.text_result);
        text_result.setText("");
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        mul = findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        del = findViewById(R.id.btn_del);

        result = findViewById(R.id.btn_result);
        record = findViewById(R.id.btn_record);

        add.setOnClickListener(btnListener);
        sub.setOnClickListener(btnListener);
        mul.setOnClickListener(btnListener);
        div.setOnClickListener(btnListener);
        result.setOnClickListener(btnListener);
        del.setOnClickListener(btnListener);


        //초기화 버튼 설정 (C,CE)
        Button clear_entry = findViewById(R.id.btn_clear_entry);
        clear_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_result.setText("");
                //i1 = i2 = 0;
                d1 = d2 = 0;
                history = number1 = number2 = "";
            }
        });
        Button clear = findViewById(R.id.btn_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_expression.setText("");
                text_result.setText("");
                //i1 = i2 = 0;
                d1 = d2 = 0;
                history = number1 = number2 = "";
            }
        });
        //음수 양수 부호 설정
        Button plus_minus = findViewById(R.id.btn_plus_minus);
        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( ((Double.parseDouble(text_result.getText().toString())) - ((int)Double.parseDouble(text_result.getText().toString())) ) == 0.0) {
                    text_result.setText("" + (Integer.parseInt(text_result.getText().toString()) * -1));
                } else {
                    text_result.setText("" + (Double.parseDouble(text_result.getText().toString()) * -1));

                }
            }
        });
    }
    Button.OnClickListener btnListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(text_result.getText().toString() == null) {
                Toast.makeText(MainActivity.this, "수를 입력하세요.", Toast.LENGTH_SHORT).show();
            } switch (v.getId()) {
                case R.id.btn_add :
                    number1 = text_result.getText().toString();
                    history = text_result.getText().toString() + " + ";
                    text_expression.setText(history);
                    text_result.setText("");

                    type = ADD;
                    break;

                case R.id.btn_sub :
                    number1 = text_result.getText().toString();
                    history = text_result.getText().toString() + " - ";
                    text_expression.setText(history);
                    text_result.setText("");

                    type = SUB;
                    break;

                case R.id.btn_mul :
                    number1 = text_result.getText().toString();
                    history = text_result.getText().toString() + " * ";
                    text_expression.setText(history);
                    text_result.setText("");

                    type = MUL;
                    break;

                case R.id.btn_div :
                    number1 = text_result.getText().toString();
                    history = text_result.getText().toString() + " / ";
                    text_expression.setText(history);
                    text_result.setText("");

                    type = DIV;
                    break;

                case R.id.btn_del :

                    String del_number = text_result.getText().toString();
                    Toast.makeText(MainActivity.this,del_number,Toast.LENGTH_SHORT).show();
                    text_result.setText(del_number.substring(0,del_number.length() -1));
                    break;

                case R.id.btn_result :
                    double result = 0;
                    Toast.makeText(MainActivity.this, "결과", Toast.LENGTH_SHORT).show();
                    number2 = text_result.getText().toString();
                    history = history + text_result.getText().toString();
                    text_expression.setText(history);

                    //i1 = Integer.parseInt(number1);
                    //i2 = Integer.parseInt(number2);
                    d1 = Double.parseDouble(number1);
                    d2 = Double.parseDouble(number2);

                    if(type == ADD) {
                        result = d1 + d2;
                        text_result.setText("" + result);
                    }else if (type == SUB) {
                        result = d1 - d2;
                        text_result.setText("" + result);
                    }else if (type == MUL) {
                        result = d1 * d2;
                        text_result.setText("" + result);
                    }else if (type == DIV) {
                        result = d1 / d2;
                        text_result.setText("" + result);
                    }
                    number1 = text_result.getText().toString();
                    break;
            }
        }
    };
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0 : text_result.setText(text_result.getText().toString() + 0); break;
            case R.id.btn1 : text_result.setText(text_result.getText().toString() + 1); break;
            case R.id.btn2 : text_result.setText(text_result.getText().toString() + 2); break;
            case R.id.btn3 : text_result.setText(text_result.getText().toString() + 3); break;
            case R.id.btn4 : text_result.setText(text_result.getText().toString() + 4); break;
            case R.id.btn5 : text_result.setText(text_result.getText().toString() + 5); break;
            case R.id.btn6 : text_result.setText(text_result.getText().toString() + 6); break;
            case R.id.btn7 : text_result.setText(text_result.getText().toString() + 7); break;
            case R.id.btn8 : text_result.setText(text_result.getText().toString() + 8); break;
            case R.id.btn9 : text_result.setText(text_result.getText().toString() + 9); break;
            case R.id.btndot : text_result.setText(text_result.getText().toString() + "."); break;
            //or case R.id.btn#: text_result.append("#"); break;

        }
    }
}