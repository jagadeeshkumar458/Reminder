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

public class Main2Activity extends AppCompatActivity {
    EditText et1,et2;
    Button bt1,bt2;
    String u="",p="",u1="",p1="";
    TextView tv1;
    public static final String userKEY="user key";
    public static final String passKEY="pass key";
    SharedPreferences sharedPreferences;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        bt1=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        tv1=(TextView)findViewById(R.id.textView);
        sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u1=et1.getText().toString();
                p1=et2.getText().toString();
                if(!u1.isEmpty()) {
                    if (!p1.isEmpty()) {
                        if (sharedPreferences.contains(userKEY)) {
                            u = sharedPreferences.getString(userKEY, "");
                        }
                        else {
                            startActivity(new Intent(getApplicationContext(),Main3Activity.class));
                        }
                        if (sharedPreferences.contains(passKEY)) {
                            p = sharedPreferences.getString(passKEY, "");
                        }else {
                            Toast.makeText(getApplicationContext(),"Please sign up",Toast.LENGTH_SHORT).show();
                        }
                        if (u.equals(u1)) {
                            if (p.equals(p1)) {
                                startActivity(new Intent(getApplicationContext(), Main6Activity.class));
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(),"Invalid user name or Not yet Registered",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Enter User name",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Main3Activity.class));
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Main5Activity.class));
            }
        });

    }
}
