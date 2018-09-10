package com.kumar.jagadeesh.reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText et1,et2;
    Button bt1;
    SharedPreferences sharedPreferences;
    public static final String passKEY="pass key";
    String pass,re;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        et1=(EditText)findViewById(R.id.editText5);
        et2=(EditText)findViewById(R.id.editText55);
        bt1=(Button)findViewById(R.id.button4);
        sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass=et1.getText().toString();
                re=et2.getText().toString();
                if (pass.equals(re)){
                    editor.putString(passKEY,pass);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Passwords Not Matched",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
