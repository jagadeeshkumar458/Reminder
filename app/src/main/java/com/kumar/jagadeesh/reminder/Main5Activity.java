package com.kumar.jagadeesh.reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    EditText et1,et2;
    TextView tv1;
    Button btn1;
    Intent intent;
    String phn,que,ans, pkey="",akey="";
    public static final String phoneKEY="phone key";
    public static final String secKEY="sec key";
    public static final String ansKEY="ans key";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        et1=(EditText)findViewById(R.id.forgrtpass);
        et2=(EditText)findViewById(R.id.forgotseans);
        tv1=(TextView)findViewById(R.id.forgottext);
        btn1=(Button)findViewById(R.id.forgotbbt);
        sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        if (sharedPreferences.contains(secKEY)){
            que=sharedPreferences.getString(secKEY,"");
            tv1.setText(que);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (sharedPreferences.contains(phoneKEY)){
                 if (sharedPreferences.contains(ansKEY)){
                     pkey=sharedPreferences.getString(phoneKEY,"");
                     akey=sharedPreferences.getString(ansKEY,"");

                     phn=et1.getText().toString();
                     ans=et2.getText().toString();
                     if (phn.equals(pkey)){
                         if (ans.equals(akey)){
                             startActivity(new Intent(getApplicationContext(),Main4Activity.class));
                             finish();
                         }
                         else {
                             Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                         }
                     }else {
                         Toast.makeText(getApplicationContext(),"Not a Registered Phone number",Toast.LENGTH_SHORT).show();
                     }
                 }
             }
            }
        });
    }
}
