package com.example.myapplicationadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_p1 extends AppCompatActivity {
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_p1);
        getSupportActionBar().setTitle("SRCOE Pune ADMIN");
        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     Intent intent = new Intent(admin_p1.this,Admin_p2.class);
     startActivity(intent);
            }
        });

    }
}