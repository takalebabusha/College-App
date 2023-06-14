package com.example.myapplicationadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplicationadmin.faculty.UpdateFaculty;

public class MainActivity extends AppCompatActivity {
    private CardView addNotice,addGalleryImage,addEbook,faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("SRCOE Pune ADMIN");

        addNotice=(CardView)findViewById(R.id.addNotice);
        addEbook=(CardView)findViewById(R.id.addEbook);
        addGalleryImage=(CardView)findViewById(R.id.addGalleryImage);
        faculty=(CardView)findViewById(R.id.faculty);



        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(in);
            }
        });



        addGalleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,uploadImage.class);
                startActivity(intent);

            }
        });
        addNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainActivity.this,UploadNotice.class);
                startActivity(intent);


            }
        });
        addEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent);
            }
        });

    }
}