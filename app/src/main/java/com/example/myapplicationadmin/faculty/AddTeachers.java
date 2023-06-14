package com.example.myapplicationadmin.faculty;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationadmin.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class AddTeachers extends AppCompatActivity {
    private ImageView addTeacherImage;
    private EditText addTeacherName,addTeacherEmail,addTeacherPost;
    Spinner addTeacherCategory;
    private final int REQ = 1;
    private Bitmap bitmap = null;
    String category;
    private String name, email, post, downloadUrl = "";
    ProgressDialog pd ;
    private StorageReference storageReference;
    private DatabaseReference reference;


    @Override
    protected void onCreate(@SuppressLint("UnknownNullness") Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teachers);
        Objects.requireNonNull(getSupportActionBar()).setTitle("SRCOE Pune ADMIN");

        addTeacherImage=findViewById(R.id.addTeacherImage);
        addTeacherName=findViewById(R.id.addTeacherName);
        addTeacherEmail=findViewById(R.id.addTeacherEmail);
        addTeacherPost=findViewById(R.id.addTeacherPost);
        addTeacherCategory=findViewById(R.id.addTeacherCategory);
        Button addTeacherBtm = findViewById(R.id.addTeacherBtm);

        pd= new ProgressDialog(this);

        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");
        storageReference = FirebaseStorage.getInstance().getReference();


        String[] items = new String[]{"Select Category","Information Technology","Computer Science","Mechanical Engineering","Civil Engineering","Electrical Engineering","Electronics And TeleCommunication Engineering","Textile Engineering","Science Department"};
        addTeacherCategory.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items));

        addTeacherCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                category = addTeacherCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        addTeacherImage.setOnClickListener(view -> openGallery());
        addTeacherBtm.setOnClickListener(view -> checkValidation());
    }

    private void checkValidation() {
        name = addTeacherName.getText().toString();
        email = addTeacherEmail.getText().toString();
        post = addTeacherPost.getText().toString();

        if (name.isEmpty()){
            addTeacherName.setError("Empty");
            addTeacherName.requestFocus();
        }else if (post.isEmpty()){
            addTeacherPost.setError("Empty");
            addTeacherPost.requestFocus();
        }else if (category.equals("Select Category")){
            Toast.makeText(this, "Please Provide Teacher Category", Toast.LENGTH_SHORT).show();
        }else if(bitmap == null){
            insertData();
        }else {
            uploadImage();
        }
    }

    private void uploadImage() {
        pd.setMessage("Uploading...");
        pd.show();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] finalimg = baos.toByteArray();
        final StorageReference filePath;
        filePath = storageReference.child("teacher").child(Arrays.toString(finalimg) +"jpg");
        final UploadTask UploadTask = filePath.putBytes(finalimg);
        UploadTask.addOnCompleteListener(AddTeachers.this, task -> {
            if (task.isSuccessful()){
                UploadTask.addOnSuccessListener(taskSnapshot -> filePath.getDownloadUrl().addOnSuccessListener(uri -> {
                    downloadUrl = String.valueOf(uri);
                    insertData();


                }));
            }else {
                pd.dismiss();
                Toast.makeText(AddTeachers.this, "Somthing went wrong", Toast.LENGTH_SHORT).show();
            }

        });
    }


    void insertData() {
        DatabaseReference dbRef = reference.child(category);
        final String uniquekey = dbRef.push().getKey();


        TeacherData teacherData = new TeacherData(name, email, post, downloadUrl, uniquekey);
        assert uniquekey != null;
        dbRef.child(uniquekey).setValue(teacherData).addOnSuccessListener(unused -> {
            pd.dismiss();
            Toast.makeText(AddTeachers.this, "Teacher Added", Toast.LENGTH_SHORT).show();

        }).addOnFailureListener(e -> {
            pd.dismiss();
            Toast.makeText(AddTeachers.this, "Something went wrong", Toast.LENGTH_SHORT).show();

        });
    }

    void openGallery() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ && resultCode == RESULT_OK){

            assert data != null;
            Uri uri = data.getData();
            try {
                bitmap =MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            addTeacherImage.setImageBitmap(bitmap);
        }
    }
}