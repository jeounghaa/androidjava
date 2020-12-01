package com.example.app04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button se, bu, je, pre;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("여행...");

        se = findViewById(R.id.se);
        bu = findViewById(R.id.bu);
        je = findViewById(R.id.je);
        pre = findViewById(R.id.previous);
        img2 = findViewById(R.id.img2);

        se.setText("서울");
        bu.setText("부산");
        je.setText("제주도");
        pre.setText("이전");

        se.setOnClickListener(this);
        bu.setOnClickListener(this);
        je.setOnClickListener(this);
        pre.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.se){
            img2.setImageResource(R.drawable.seoul);
        } else if (v.getId() == R.id.bu){
            img2.setImageResource(R.drawable.busan);
        } else if (v.getId() == R.id.je){
            img2.setImageResource(R.drawable.jeju);
        } else if (v.getId() == R.id.previous){
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }
    }
}
