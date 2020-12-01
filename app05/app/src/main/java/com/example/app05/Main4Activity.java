package com.example.app05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    LinearLayout linear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void onClickShowAlert(View view) {
        print(view);
    }

    public void onClickShowDate(View view) {
        showDatePicker(view);
    }

    public void onClickShowDay(View view) {
        Log.d("view정보>>", view.getId()+"!!!!");
        Button b4 = findViewById(R.id.button4);
        b4.setText("오늘은 월요일입니다.");
    }

    public void onClickLogPrint(View view){
        Log.d("나를 부른 view에 대한 정보>> ", view.getId()+"!");
        Button b3 = findViewById(R.id.button3);
        b3.setTextColor(Color.BLUE);
    }

    public void print(View view){
        Log.d("이 메서드가 호출됨", "나를 호출한 view>> " + view);
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("경고용 메시지 창");
        ad.setMessage("오늘은 금요일입니다....오!!");
        ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "OK를 누르셨군요!", Toast.LENGTH_SHORT).show();
            }
        });
        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "NO를 누르셨군요!", Toast.LENGTH_SHORT).show();
            }
        });
        ad.create();
        ad.show();
    }

    public void showDatePicker(View view){
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void result(final int year, final int month, final int day, final String dd){
        linear = findViewById(R.id.linear2);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("날짜를 클릭");
        builder.setMessage(year+"년"+month+"월"+day+"일");
        builder.setPositiveButton("전달받은 값 확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), year+"년"+month+"월"+day+"일", Toast.LENGTH_SHORT).show();
                final Button b = new Button(getApplicationContext());
                b.setText(year+"년"+month+"월"+day+"일");
                b.setWidth(100);
                b.setTextSize(25);
                linear.addView(b);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder ad = new AlertDialog.Builder(Main4Activity.this);
                        ad.setTitle("선택한 날짜입니다!!!!!!!!!!!!!!!!!!");
                        ad.setMessage(b.getText()+dd);
                        ad.setPositiveButton("네네..", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(), "네넵!!~~", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        ad.show();
                    }
                });
            }
        });
        builder.show();
    }
}
