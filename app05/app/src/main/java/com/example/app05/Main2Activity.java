package com.example.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;

import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    ImageButton getBtn;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // inflation: 인플레이션(java + layout)
        // java: 내부적인 처리, 이벤트 처리, 외부와의 통신
        // layout: view를 담당
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        getBtn = findViewById(R.id.getBtn);

        final String[] list = {"airplane", "apple", "melon", "strawberry", "watermelon", "orange", "banana"};

        // 배열(data)에 들어있는 값들을 autotextview에 넣을 예정
        // adapter:어댑터!
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, list);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(token);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autoText = autoCompleteTextView.getText().toString();
                String multiText = multiAutoCompleteTextView.getText().toString();
                String total = autoText + ", " + multiText;

                Log.d("single 자동완성: ", autoCompleteTextView.getText().toString());
                Log.d("multi 자동완성: ", multiAutoCompleteTextView.getText().toString());
                Log.d("total 자동완성: ", total);

                StringTokenizer tokenizer = new StringTokenizer(total);
                int count = tokenizer.countTokens();
                Log.d("token개수: ", count+"개");

                linearLayout = findViewById(R.id.linear1);

//                    Log.d(i+"번째 token: ", tokenizer.nextToken(", ").trim());

                for (int i = 0; i < count; i++) {
                    String str = tokenizer.nextToken(", ").trim();
                    Log.d(i+"번째 token", str);
                    Button button = new Button(getApplicationContext());
                    button.setText(str);
                    button.setWidth(100);
                    button.setTextSize(15);
                    button.setId(100);
                    linearLayout.addView(button);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("새로생긴 버튼을 눌렀습니다...", v.getId()+"입니다...");
                            if (v.getId() == (100)) {
                                Log.d(v.getId() + "값을 선택함!!!!", "오오...");
                            } else {
                                Log.d(v.getId() + "값을 선택함!!!", "없어..ㅠ");
                            }
                        }
                    });
                }


            }
        });
    }
}
