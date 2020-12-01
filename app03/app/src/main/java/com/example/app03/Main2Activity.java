package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button bb1, bb2;
    ImageView iv;
    EditText ee1, ee2;
    TextView tt1;

    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        iv = findViewById(R.id.iv);
        bb1 = findViewById(R.id.bb1);

        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 0){
                    iv.setImageResource(R.mipmap.ic_launcher_round);
                    a = 1;
                    Log.d("a의 값@@@@@@@@@@@@@@@@" , String.valueOf(a));
                } else if(a == 1){
                    iv.setImageResource(R.drawable.find);
                    a = 0;
                    Log.d("a의 값@@@@@@@@@@@@@@@@" , String.valueOf(a));
                }
            }
        });

    }
}
