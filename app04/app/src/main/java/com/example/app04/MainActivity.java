package com.example.app04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sw, cz, po, search, next;
    EditText e1;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("여행가고싶다");

        sw = findViewById(R.id.sw);
        cz = findViewById(R.id.cz);
        po = findViewById(R.id.po);
        search = findViewById(R.id.search);
        next = findViewById(R.id.next);
        e1 = findViewById(R.id.e1);
        img = findViewById(R.id.img);

        sw.setOnClickListener(this);
        cz.setOnClickListener(this);
        po.setOnClickListener(this);
        next.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sw){
            img.setImageResource(R.drawable.sweden);
        } else if (v.getId() == R.id.cz){
            img.setImageResource(R.drawable.czech);
        } else if (v.getId() == R.id.po){
            img.setImageResource(R.drawable.portugal);
        } else if (v.getId() == R.id.search){
            if (e1.getText().toString().equals("스웨덴")) {
                img.setImageResource(R.drawable.sweden);
            } else if (e1.getText().toString().equals("체코")){
                img.setImageResource(R.drawable.czech);
            } else if (e1.getText().toString().equals("포르투갈")){
                img.setImageResource(R.drawable.portugal);
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + e1.getText().toString()));
                startActivity(intent);
            }
        } else if (v.getId() == R.id.next){
            Intent intent = new Intent(getApplication(), Main2Activity.class);
            startActivity(intent);
        }
    }
}
