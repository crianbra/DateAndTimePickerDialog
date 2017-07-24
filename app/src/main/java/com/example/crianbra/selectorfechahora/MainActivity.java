package com.example.crianbra.selectorfechahora;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_fecha, btn_hora;
    TextView txt_fecha, txt_hora;
    private int dia, mes, anio, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fecha = (Button)findViewById(R.id.btn_fecha);
        btn_hora = (Button)findViewById(R.id.btn_hora);
        txt_fecha = (TextView)findViewById(R.id.txt_fecha);
        txt_hora = (TextView)findViewById(R.id.txt_hora);

        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btn_fecha){
            final java.util.Calendar c = java.util.Calendar.getInstance();
            //final Calendar ca = Calendar.getInstance();
            dia = c.get(java.util.Calendar.DAY_OF_MONTH);
            mes = c.get(java.util.Calendar.MONTH);
            anio = c.get(java.util.Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txt_fecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            , dia, mes, anio);
            datePickerDialog.show();

        }

        if(v==btn_hora){
            final java.util.Calendar c = java.util.Calendar.getInstance();

            hora = c.get(java.util.Calendar.HOUR_OF_DAY);
            minutos = c.get(java.util.Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txt_hora.setText(hourOfDay+":"+minute);

                }
            }
            , hora, minutos, false);
            timePickerDialog.show();


        }
    }
}
