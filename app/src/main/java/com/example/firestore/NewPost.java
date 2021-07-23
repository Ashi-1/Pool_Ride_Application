package com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NewPost extends AppCompatActivity {
    private static final String TAG = "NewPost";
    private EditText source;
    private EditText destination;
    private EditText date;
    private EditText time;
    private EditText username;
    private EditText vehicle;
    private EditText totalSlots;
    private EditText openSlots;
    private EditText description;
    private Button register;
    private RadioGroup radioGroup;
    private RadioButton status;



    //Connection to Firestore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionRef = db.collection("Post");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        register = (Button) findViewById(R.id.button);
        source = (EditText) findViewById(R.id.editText_source);
        destination = (EditText) findViewById(R.id.editText_destination);
        date = (EditText) findViewById(R.id.editTextDate);
        time = (EditText) findViewById(R.id.editTextTime);
        username = (EditText) findViewById(R.id.editText_username);
        vehicle = (EditText) findViewById(R.id.editText_Vehicle);
        openSlots = (EditText) findViewById(R.id.editText_openSlots);
        totalSlots = (EditText) findViewById(R.id.editText_totalSlots);
        description = (EditText) findViewById(R.id.editTextText_Description);
        radioGroup = findViewById(R.id.radio_buttons);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = source.getText().toString().trim();
                String to = destination.getText().toString().trim();
                String date1 = date.getText().toString().trim();
                String time1 = time.getText().toString().trim();
                String user = username.getText().toString().trim();
                String desc = description.getText().toString().trim();
                int radioID = radioGroup.getCheckedRadioButtonId();
                status = findViewById(radioID);
                String text = status.getText().toString().trim();

                Post post = new Post();
                post.setDate(date1);
                post.setFrom(from);
                post.setTo(to);
                post.setTime(time1);
                post.setUsername(user);
                post.setText(text);
                post.setDesc(desc);
                if(text.equals("Providing"))
                {
                    String vehicle1 = vehicle.getText().toString().trim();
                    int oSlots = Integer.parseInt(openSlots.getText().toString().trim());
                    int tSlots = Integer.parseInt(totalSlots.getText().toString().trim());
                    post.setVehicle(vehicle1);
                    post.setoSlots(oSlots);
                    post.settSlots(tSlots);
                }
                else
                {
                    int oSlots = 1;
                    int tSlots = 1;
                    post.setoSlots(oSlots);
                    post.settSlots(tSlots);
                }

                collectionRef.add(post).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Toast.makeText(NewPost.this, "Success", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton_Providing:
                if (checked)
                    vehicle.setVisibility(view.VISIBLE);
                totalSlots.setVisibility(view.VISIBLE);
                openSlots.setVisibility(view.VISIBLE);
                break;
            case R.id.radioButton_Requesting:
                if(checked)
                    vehicle.setVisibility(view.GONE);
                totalSlots.setVisibility(view.GONE);
                openSlots.setVisibility(view.GONE);
        }
    }
}