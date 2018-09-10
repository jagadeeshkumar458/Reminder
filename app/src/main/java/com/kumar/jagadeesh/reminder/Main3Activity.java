package com.kumar.jagadeesh.reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button bt3;
    EditText et1,et2,et3,et4,et5,et6;
    public static final String userKEY="user key";
    public static final String passKEY="pass key";
    public static final String phoneKEY="phone key";
    public static final String secKEY="sec key";
    public static final String ansKEY="ans key";
    SharedPreferences sharedPreferences;
    int p;
    String user,pass,rep,phone,security,answer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bt3=(Button)findViewById(R.id.button3);
        et1=(EditText)findViewById(R.id.editText3);
        et2=(EditText)findViewById(R.id.editText4);
        et3=(EditText)findViewById(R.id.editText44);
        et4=(EditText)findViewById(R.id.editText444);
        et5=(EditText)findViewById(R.id.editText4444);
        et6=(EditText)findViewById(R.id.editText44444);
        sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = et1.getText().toString();
                pass = et2.getText().toString();
                rep = et3.getText().toString();
                phone = et4.getText().toString();
                p=phone.length();
                security = et5.getText().toString();
                answer = et6.getText().toString();
                if (user.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                } else if (rep.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Re-Enter Password", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter PhoneNumber", Toast.LENGTH_SHORT).show();
                } else if (security.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Enter Security Question", Toast.LENGTH_SHORT).show();
                } else if (answer.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Answer", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(rep)) {
                    Toast.makeText(getApplicationContext(), "Passwords not Matched", Toast.LENGTH_SHORT).show();
                }else if (p<10||p>10){
                    Toast.makeText(getApplicationContext(),"Phone number must be 10 digits",Toast.LENGTH_SHORT).show();
                }else {
                    editor.putString(userKEY, user);
                    editor.putString(passKEY, pass);
                    editor.putString(phoneKEY, phone);
                    editor.putString(secKEY, security);
                    editor.putString(ansKEY, answer);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                    finish();
                }
            }
        });
    }
}
