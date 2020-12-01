package com.example.app05;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer ch;
    TimePicker timeP;
    Button start, end, cal, time, next;
    CalendarView calview;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch = findViewById(R.id.ch);
        timeP = findViewById(R.id.timeP);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        cal = findViewById(R.id.calBtn);
        time = findViewById(R.id.timeBtn);
        next = findViewById(R.id.nextBtn);
        calview = findViewById(R.id.cal);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                Log.d("크로메터 상황: ", "시작됨!");
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.stop();
                ch.setTextColor(Color.BLUE);
                Toast.makeText(getApplicationContext(), ch.getText(), Toast.LENGTH_LONG).show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h = timeP.getHour();
                int m = timeP.getMinute();
                Toast.makeText(getApplicationContext(), h+"시"+m+"분", Toast.LENGTH_LONG).show();
            }
        });

        calview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year2, int month2, int day2) {
                Log.d("선택한 날짜는...", year2+"년"+(month2+1)+"월"+day2+"일");
                year = year2;
                month = month2+1;
                day = day2;
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (year != 0) {
                    Toast.makeText(getApplicationContext(), year+"년"+month+"월"+day+"일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "날짜를 먼저 선택해주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });


    }
}
