package com.example.myapplicationadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplicationadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView CivilEngineering, ComputerScience, ElectricalEngineering, ENTCDepartment, InformationTechnology, MechanicalEngineering, ScienceDepartment, TextileEngineering;
    LinearLayout CENoData, CSNoData, EENoData, ENTCNoData, ITNoData, MENoData, SENoData, TextileNoData;
    List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8;
    TeacherAdapter adapter;


    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(@android.support.annotation.NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
        Objects.requireNonNull(getSupportActionBar()).setTitle("SRCOE Pune ADMIN");




        CivilEngineering = findViewById(R.id.CivilEngineering);
        ComputerScience = findViewById(R.id.ComputerScience);
        ElectricalEngineering = findViewById(R.id.ElectricalEngineering);
        ENTCDepartment = findViewById(R.id.ENTCDepartment);
        InformationTechnology = findViewById(R.id.InformationTechnology);
        MechanicalEngineering = findViewById(R.id.MechanicalEngineering);
        ScienceDepartment = findViewById(R.id.ScienceDepartment);
        TextileEngineering = findViewById(R.id.TextileEngineering);



        CENoData = findViewById(R.id.CENoData);
        CSNoData = findViewById(R.id.CSNoData);
        EENoData = findViewById(R.id.EENoData);
        ENTCNoData = findViewById(R.id.ENTCNoData);
        ITNoData = findViewById(R.id.ITNoData);
        MENoData = findViewById(R.id.MENoData);
        SENoData = findViewById(R.id.SCNoData);
        TextileNoData = findViewById(R.id.TextileNoData);



        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");


        CivilEngineering();
        ComputerScience();
        ElectricalEngineering();
        ENTCDepartment();
        InformationTechnology();
        MechanicalEngineering();
        ScienceDepartment();
        TextileEngineering();



        fab = findViewById(R.id.fab);


        fab.setOnClickListener(view -> startActivity(new Intent(UpdateFaculty.this, AddTeachers.class)));

    }

    private void CivilEngineering() {
        dbRef = reference.child("Civil Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    CENoData.setVisibility(View.VISIBLE);
                    CivilEngineering.setVisibility(View.VISIBLE);

                }else{
                    CENoData.setVisibility(View.VISIBLE);
                    CivilEngineering.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    CivilEngineering.setHasFixedSize(true);
                    CivilEngineering.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list1, UpdateFaculty.this);
                    CivilEngineering.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ComputerScience() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    CSNoData.setVisibility(View.VISIBLE);
                    ComputerScience.setVisibility(View.VISIBLE);

                }else{
                    CSNoData.setVisibility(View.VISIBLE);
                    ComputerScience.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ComputerScience.setHasFixedSize(true);
                    ComputerScience.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list2, UpdateFaculty.this);
                    ComputerScience.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ElectricalEngineering() {
        dbRef = reference.child("Electrical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    EENoData.setVisibility(View.VISIBLE);
                    ElectricalEngineering.setVisibility(View.VISIBLE);

                }else{
                    EENoData.setVisibility(View.VISIBLE);
                    ElectricalEngineering.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    ElectricalEngineering.setHasFixedSize(true);
                    ElectricalEngineering.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list3, UpdateFaculty.this);
                    ElectricalEngineering.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ENTCDepartment() {
        dbRef = reference.child("Electronics And TeleCommunication Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ENTCNoData.setVisibility(View.VISIBLE);
                    ENTCDepartment.setVisibility(View.VISIBLE);

                }else{
                    ENTCNoData.setVisibility(View.VISIBLE);
                    ENTCDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    ENTCDepartment.setHasFixedSize(true);
                    ENTCDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list4, UpdateFaculty.this);
                    ENTCDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void InformationTechnology() {
        dbRef = reference.child("Information Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ITNoData.setVisibility(View.VISIBLE);
                    InformationTechnology.setVisibility(View.VISIBLE);

                }else{
                    ITNoData.setVisibility(View.VISIBLE);
                    InformationTechnology.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    InformationTechnology.setHasFixedSize(true);
                    InformationTechnology.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list5, UpdateFaculty.this);
                    InformationTechnology.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void MechanicalEngineering() {
        dbRef = reference.child("Mechanical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    MENoData.setVisibility(View.VISIBLE);
                    MechanicalEngineering.setVisibility(View.VISIBLE);

                }else{
                    MENoData.setVisibility(View.VISIBLE);
                    MechanicalEngineering.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    MechanicalEngineering.setHasFixedSize(true);
                    MechanicalEngineering.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list6, UpdateFaculty.this);
                    MechanicalEngineering.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ScienceDepartment() {
        dbRef = reference.child("Science Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    SENoData.setVisibility(View.VISIBLE);
                    ScienceDepartment.setVisibility(View.VISIBLE);

                }else{
                    SENoData.setVisibility(View.VISIBLE);
                    ScienceDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    ScienceDepartment.setHasFixedSize(true);
                    ScienceDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list7, UpdateFaculty.this);
                    ScienceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void TextileEngineering() {
        dbRef = reference.child("Textile Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {

                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    TextileNoData.setVisibility(View.VISIBLE);
                    TextileEngineering.setVisibility(View.VISIBLE);

                }else{
                    TextileNoData.setVisibility(View.VISIBLE);
                    TextileEngineering.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    TextileEngineering.setHasFixedSize(true);
                    TextileEngineering.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));

                    adapter = new TeacherAdapter(list8, UpdateFaculty.this);
                    TextileEngineering.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}