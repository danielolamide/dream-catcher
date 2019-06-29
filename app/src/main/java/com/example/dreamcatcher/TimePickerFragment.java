package com.example.dreamcatcher;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute,
                DateFormat.is24HourFormat(getActivity()));

    }
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        Log.d("TIME","Time set is "+hourOfDay);
    }
}
