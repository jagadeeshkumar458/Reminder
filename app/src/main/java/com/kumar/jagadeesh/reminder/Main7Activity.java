package com.kumar.jagadeesh.reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {
    ListView lv1;
    public static final String reminderKEY="reminder key";
    SharedPreferences sharedPreferences;
    ArrayList<String> arrayList;
    String str="no data in key";
    String desc;
    String[] ss={"Reminders","no value in the key"};
    String rem;
    int j;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        lv1=(ListView)findViewById(R.id.lv);
        Intent i=getIntent();
        Bundle b=i.getExtras();


        //str=b.getString("k1");
        sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
       /* for ( j=1;j<=10;j++)
        {

            String reminder="Default";
            rem=sharedPreferences.getString("name"+j,reminder);
            if (rem.equals("Default")){
                break;
            }else{
                str=rem;
                ss[j]=str;
            }



        }*/
        String reminder="Default";
        rem=sharedPreferences.getString("name",reminder);
        str=rem;
        ss[1]=str;

        arrayList=new ArrayList<String >();
        //str=sharedPreferences.getString(reminderKEY,"");
       /* if (sharedPreferences.contains(reminderKEY)){
            str=sharedPreferences.getString(reminderKEY,"");
            String bb=str;
        }
        else {
            Toast.makeText(getApplicationContext(),"no value",Toast.LENGTH_SHORT).show();
        }*/
        //ss[1]=str;
        //arrayList.add(str);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ss);

        lv1.setAdapter(arrayAdapter);
    }
}
