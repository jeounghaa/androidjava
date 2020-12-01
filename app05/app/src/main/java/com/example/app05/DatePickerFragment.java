package com.example.app05;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        Log.d("다이얼로그가 만들어지자마자 캘린더의 변수값", year+"년"+(month+1)+"월"+day+"일");
        return new DatePickerDialog(getActivity(), this, year, month, day);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Date date = new Date(year, month, dayOfMonth);
        int day = date.getDay();
        String dd = null;
        switch (day){
            case 2: dd = "월요일"; break;
            case 3: dd = "화요일"; break;
            case 4: dd = "수요일"; break;
            case 5: dd = "목요일"; break;
            case 6: dd = "금요일"; break;
            case 0: dd = "토요일"; break;
            case 1: dd = "일요일"; break;
        }

        Main4Activity activity = (Main4Activity)getActivity();
//        logPritn(year, month, dayOfMonth);

        activity.result(year, month+1, dayOfMonth, dd);
    }

    public void logPritn(int year, int month, int day){
        Log.d("선택한 날짜는", year+"년"+month+"월"+day+"일");
    }
}
