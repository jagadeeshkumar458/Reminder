package com.kumar.jagadeesh.reminder;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Main6Activity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    EditText et1,et2,et3;
    TextView tv1;
    Button  bt3;
    Intent intent;
    int j;
    String h;
    Spinner spinner;
    String[] ampm={"PM","AM"};
    DatePickerDialog dpd;

    NotificationManager mNotificationManager;
    public static final String reminderKEY="reminder kay";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        et1 = (EditText) findViewById(R.id.editText6);
        et2=(EditText)findViewById(R.id.textView2);
        et3=(EditText)findViewById(R.id.textView3);
        spinner=(Spinner)findViewById(R.id.spp);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ampm);
        spinner.setAdapter(arrayAdapter);
        tv1 = (TextView) findViewById(R.id.hm);
        //tv2 = (TextView) findViewById(R.id.textView3);
        //bt1 = (Button) findViewById(R.id.button5);
        //bt2 = (Button) findViewById(R.id.button6);
        bt3 = (Button) findViewById(R.id.button7);
        sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
       /* bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.DialogFragment timepicker = new DatePickerFragment();
                timepicker.show(getSupportFragmentManager(), "time picker");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                dpd = new android.app.DatePickerDialog(Main6Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tv2.setText(i2 + "/" + i1 + "/" + i);
                    }
                }, day, month, year);
                dpd.show();

            }
        });*/
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et2.getText().toString().isEmpty()){
                    if (!et3.getText().toString().isEmpty()) {
                        if (et1.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Ennter Time", Toast.LENGTH_SHORT).show();
                        }else {
                            String ap=spinner.getSelectedItem().toString();
                            Date dt = new Date();
                            Calendar calendar=Calendar.getInstance();
                            int hour = dt.getHours();
                            int min = dt.getMinutes();
                            String tt=et1.getText().toString();
                            //Intent sttr=new Intent(getApplicationContext(),Main7Activity.class);
                            intent=new Intent(getApplicationContext(),Main7Activity.class);
                            intent.putExtra("k1",tt);
                            editor.putString("name",tt);
                            editor.apply();
                            /*for (j=1;j<=1000;j++){
                                h=sharedPreferences.getString("name"+j,tt);
                                if (h.isEmpty()){
                                    editor.putString("name"+j,tt);
                                    editor.apply();
                                    break;
                                }else
                                {

                                }
                            }*/

                            int h=Integer.parseInt(et2.getText().toString().trim());
                            int m=Integer.parseInt(et3.getText().toString().trim());
                            if (h>24||m>60){
                                Toast.makeText(getApplicationContext(),"In-Valid Time",Toast.LENGTH_SHORT).show();
                            }else {
                                if (hour >= 12) {
                                    hour = hour - 12;
                                    if (h <= hour) {
                                        if (m < min) {
                                            int i = h - hour;
                                            int j = min - m;
                                            i = (i * 60) - j;
                                            Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                                            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                                    getApplicationContext(), 234324243, intent, 0);
                                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                                                    + (i * 60000), pendingIntent);
                                            Toast.makeText(getApplicationContext(), "Time left for Reminder " + i + " min", Toast.LENGTH_SHORT).show();
                                        }// else {
                                        // Toast.makeText(getApplicationContext(), "up", Toast.LENGTH_SHORT).show();
                                        // }
                                        if (m > min) {
                                            int i = h - hour;
                                            int j = m - min;
                                            i = (i * 60) + j;
                                            Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                                            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                                    getApplicationContext(), 234324243, intent, 0);
                                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                                                    + (i * 60000), pendingIntent);
                                            Toast.makeText(getApplicationContext(), "Time left for Reminder " + i + " min", Toast.LENGTH_SHORT).show();
                                        }// else {
                                        // Toast.makeText(getApplicationContext(), "upp", Toast.LENGTH_SHORT).show();
                                        //}
                                        if (m == min) {
                                            int i = (h - hour) * 60;
                                            Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                                            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                                    getApplicationContext(), 234324243, intent, 0);
                                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                                                    + (i * 60000), pendingIntent);
                                            Toast.makeText(getApplicationContext(), "alert at" + i + " min", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        if (h <= hour) {
                                            if (m < min) {
                                                int i = h - hour;
                                                int j = min - m;
                                                i = (i * 60) - j;
                                                Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                                                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                                        getApplicationContext(), 234324243, intent, 0);
                                                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                                                        + (i * 60000), pendingIntent);
                                                Toast.makeText(getApplicationContext(), "Time left for Reminder " + i + " min", Toast.LENGTH_SHORT).show();
                                            } //else {
                                            //Toast.makeText(getApplicationContext(), "up", Toast.LENGTH_SHORT).show();
                                            //}
                                            if (m > min) {
                                                int i = h - hour;
                                                int j = m - min;
                                                i = (i * 60) + j;
                                                Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                                                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                                        getApplicationContext(), 234324243, intent, 0);
                                                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                                                        + (i * 60000), pendingIntent);
                                                Toast.makeText(getApplicationContext(), "Time left for Reminder " + i + " min", Toast.LENGTH_SHORT).show();
                                            } //else {
                                            //Toast.makeText(getApplicationContext(), "upp", Toast.LENGTH_SHORT).show();
                                            //}
                                            if (m == min) {
                                                int i = (h - hour) * 60;
                                                Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                                                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                                        getApplicationContext(), 234324243, intent, 0);
                                                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                                                        + (i * 60000), pendingIntent);
                                                Toast.makeText(getApplicationContext(), "Time left for Reminder " + i + " min", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }else {
                        Toast.makeText(getApplicationContext(),"Enter Minutes",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Enter Hour",Toast.LENGTH_SHORT).show();
                }


                startActivity(new Intent(getApplicationContext(),Main7Activity.class));
            }
        });

    }
    private void deliverNotification(Context context) {}
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        tv1=(TextView)findViewById(R.id.textView2);
        tv1.setText(i +":"+ i1+"  ");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                String skb;
                if (et1.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter any reminder",Toast.LENGTH_SHORT).show();
                }else {
                    //String  stt;
                    //stt=et1.getText().toString();
                    //sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
                    //final SharedPreferences.Editor editor=sharedPreferences.edit();
                    //editor.putString(reminderKEY,stt);
                    //editor.apply();
                    startActivity(intent);
                }
        }
        return true;
    }
}


