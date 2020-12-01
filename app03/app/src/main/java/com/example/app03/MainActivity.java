package com.example.app03;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    EditText e1, e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        t1 = findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "토스트입니다.", Toast.LENGTH_LONG).show();
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("떴습니다.");
//                dlg.setMessage("이것도 뜨나요?");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final String[] array = {"오레오", "파이", "큐(Q)"};
                dlg.setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Log.d("배열에서 가지고 온 갑은 ", array[i]);
                        if (array[i].equals("오레오")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + array[i]));
                            startActivity(intent);
                        } else if (array[i].equals("파이")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + array[i]));
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + array[i]));
                            startActivity(intent);
                        }
                    }
                });
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = e1.getText().toString();
                String n2 = e2.getText().toString();
                int result = Integer.parseInt(n1) + Integer.parseInt(n2);
                t1.setText(result + "");
            }
        });
    }

}
