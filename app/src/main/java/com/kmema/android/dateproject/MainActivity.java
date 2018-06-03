package com.kmema.android.dateproject;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TextView to display the current date and selected date.
        final TextView output = (TextView) findViewById(R.id.tvOutput);


        // Button for Date selection pop-up
        Button changeDate = (Button) findViewById(R.id.btnChangeDate);
        changeDate.setOnClickListener(this);

        output.setText(DateFormat.getDateInstance().format(new Date()));

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                output.setText(String.format("%s/%s/%s", Integer.toString(i), Integer.toString(i1 + 1), Integer.toString(i2)));
            }
        };


        // TODO: On launch of Activity, display the current date.
        // On click of Change Date button display the DatePickerDialog and show the current date.
        // On selecting the date display the selection in the TextView.
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnChangeDate:
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, date, year, month, day);
                dialog.show();

                break;
        }
    }
}