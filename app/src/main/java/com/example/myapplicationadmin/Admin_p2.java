package com.example.myapplicationadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Admin_p2 extends AppCompatActivity {
    private EditText username,password;
    Button login;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_p2);
        getSupportActionBar().setTitle("SRCOE Pune ADMIN");
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("srcoe".equals(username.getText().toString()) && "123".equals(password.getText().toString())){
                    Toast.makeText(Admin_p2.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Admin_p2.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Admin_p2.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(Admin_p2.this,Admin_p2.class);
                    startActivity(intent);
                }

            }
        });
    }
}