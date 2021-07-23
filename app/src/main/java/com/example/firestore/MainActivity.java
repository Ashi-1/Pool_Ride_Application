package com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button logout;
    private Button new_post,filter;
    private int count = 0;
    private int count1;
    private TextView[] From = new TextView[10];
    private TextView[] To = new TextView[10];
    private TextView[] date2 = new TextView[10];
    private TextView[] time2 = new TextView[10];
    private TextView[] user2 = new TextView[10];
    private TextView[] vehicle2 = new TextView[10];
    private TextView[] tslots2 = new TextView[10];
    private TextView[] oslots2 = new TextView[10];
    private TextView[] desc2 = new TextView[10];
    private TextView[] status2 = new TextView[10];
    private TextView[] vehicle_title = new TextView[10];
    private TextView[] tslots_title = new TextView[10];
    private TextView[] oslots_title = new TextView[10];
    private TableLayout[] table_Layout = new TableLayout[10];
    final Calendar myCalendar = Calendar.getInstance();
    private EditText date_filter,source_filter,to_filter,time_filter;


    //CONNECTION
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionRef = db.collection("Post");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_filter = (EditText)findViewById(R.id.Filter_Date);
        source_filter = (EditText)findViewById(R.id.Filter_Source);
        to_filter = (EditText)findViewById(R.id.Filter_Destination);
        time_filter = (EditText)findViewById(R.id.Filter_Time);
        logout = findViewById(R.id.button2);
        new_post = findViewById(R.id.New_Post_Button);
        filter = findViewById(R.id.Apply_filters);

        From[0] = findViewById(R.id.From);
        To[0] = findViewById(R.id.To);
        date2[0] = findViewById(R.id.Date);
        time2[0] = findViewById(R.id.Time);
        user2[0] = findViewById(R.id.Username);
        vehicle2[0] = findViewById(R.id.Vehicle);
        tslots2[0] = findViewById(R.id.tslots);
        oslots2[0] = findViewById(R.id.oslots);
        desc2[0] = findViewById(R.id.Description);
        status2[0] = findViewById(R.id.Status);
        vehicle_title[0] = findViewById(R.id.Vehicle_Title);
        tslots_title[0] = findViewById(R.id.tslots_Title);
        oslots_title[0] = findViewById(R.id.oslots_Title);
        table_Layout[0] = findViewById(R.id.TableLayout);

        From[1] = findViewById(R.id.From2);
        To[1] = findViewById(R.id.To2);
        date2[1] = findViewById(R.id.Date2);
        time2[1] = findViewById(R.id.Time2);
        user2[1] = findViewById(R.id.Username2);
        vehicle2[1] = findViewById(R.id.Vehicle2);
        tslots2[1] = findViewById(R.id.tslots2);
        oslots2[1] = findViewById(R.id.oslots2);
        desc2[1] = findViewById(R.id.Description2);
        status2[1] = findViewById(R.id.Status2);
        vehicle_title[1] = findViewById(R.id.Vehicle_Title2);
        tslots_title[1] = findViewById(R.id.tslots_Title2);
        oslots_title[1] = findViewById(R.id.oslots_Title2);
        table_Layout[1] = findViewById(R.id.TableLayout2);

        From[2] = findViewById(R.id.From3);
        To[2] = findViewById(R.id.To3);
        date2[2] = findViewById(R.id.Date3);
        time2[2] = findViewById(R.id.Time3);
        user2[2] = findViewById(R.id.Username3);
        vehicle2[2] = findViewById(R.id.Vehicle3);
        tslots2[2] = findViewById(R.id.tslots3);
        oslots2[2] = findViewById(R.id.oslots3);
        desc2[2] = findViewById(R.id.Description3);
        status2[2] = findViewById(R.id.Status3);
        vehicle_title[2] = findViewById(R.id.Vehicle_Title3);
        tslots_title[2] = findViewById(R.id.tslots_Title3);
        oslots_title[2] = findViewById(R.id.oslots_Title3);
        table_Layout[2] = findViewById(R.id.TableLayout3);

        From[3] = findViewById(R.id.From4);
        To[3] = findViewById(R.id.To4);
        date2[3] = findViewById(R.id.Date4);
        time2[3] = findViewById(R.id.Time4);
        user2[3] = findViewById(R.id.Username4);
        vehicle2[3] = findViewById(R.id.Vehicle4);
        tslots2[3] = findViewById(R.id.tslots4);
        oslots2[3] = findViewById(R.id.oslots4);
        desc2[3] = findViewById(R.id.Description4);
        status2[3] = findViewById(R.id.Status4);
        vehicle_title[3] = findViewById(R.id.Vehicle_Title4);
        tslots_title[3] = findViewById(R.id.tslots_Title4);
        oslots_title[3] = findViewById(R.id.oslots_Title4);
        table_Layout[3] = findViewById(R.id.TableLayout4);

        From[4] = findViewById(R.id.From5);
        To[4] = findViewById(R.id.To5);
        date2[4] = findViewById(R.id.Date5);
        time2[4] = findViewById(R.id.Time5);
        user2[4] = findViewById(R.id.Username5);
        vehicle2[4] = findViewById(R.id.Vehicle5);
        tslots2[4] = findViewById(R.id.tslots5);
        oslots2[4] = findViewById(R.id.oslots5);
        desc2[4] = findViewById(R.id.Description5);
        status2[4] = findViewById(R.id.Status5);
        vehicle_title[4] = findViewById(R.id.Vehicle_Title5);
        tslots_title[4] = findViewById(R.id.tslots_Title5);
        oslots_title[4] = findViewById(R.id.oslots_Title5);
        table_Layout[4] = findViewById(R.id.TableLayout5);

        From[5] = findViewById(R.id.From6);
        To[5] = findViewById(R.id.To6);
        date2[5] = findViewById(R.id.Date6);
        time2[5] = findViewById(R.id.Time6);
        user2[5] = findViewById(R.id.Username6);
        vehicle2[5] = findViewById(R.id.Vehicle6);
        tslots2[5] = findViewById(R.id.tslots6);
        oslots2[5] = findViewById(R.id.oslots6);
        desc2[5] = findViewById(R.id.Description6);
        status2[5] = findViewById(R.id.Status6);
        vehicle_title[5] = findViewById(R.id.Vehicle_Title6);
        tslots_title[5] = findViewById(R.id.tslots_Title6);
        oslots_title[5] = findViewById(R.id.oslots_Title6);
        table_Layout[5] = findViewById(R.id.TableLayout6);

        From[6] = findViewById(R.id.From7);
        To[6] = findViewById(R.id.To7);
        date2[6] = findViewById(R.id.Date7);
        time2[6] = findViewById(R.id.Time7);
        user2[6] = findViewById(R.id.Username7);
        vehicle2[6] = findViewById(R.id.Vehicle7);
        tslots2[6] = findViewById(R.id.tslots7);
        oslots2[6] = findViewById(R.id.oslots7);
        desc2[6] = findViewById(R.id.Description7);
        status2[6] = findViewById(R.id.Status7);
        vehicle_title[6] = findViewById(R.id.Vehicle_Title7);
        tslots_title[6] = findViewById(R.id.tslots_Title7);
        oslots_title[6] = findViewById(R.id.oslots_Title7);
        table_Layout[6] = findViewById(R.id.TableLayout7);

        From[7] = findViewById(R.id.From8);
        To[7] = findViewById(R.id.To8);
        date2[7] = findViewById(R.id.Date8);
        time2[7] = findViewById(R.id.Time8);
        user2[7] = findViewById(R.id.Username8);
        vehicle2[7] = findViewById(R.id.Vehicle8);
        tslots2[7] = findViewById(R.id.tslots8);
        oslots2[7] = findViewById(R.id.oslots8);
        desc2[7] = findViewById(R.id.Description8);
        status2[7] = findViewById(R.id.Status8);
        vehicle_title[7] = findViewById(R.id.Vehicle_Title8);
        tslots_title[7] = findViewById(R.id.tslots_Title8);
        oslots_title[7] = findViewById(R.id.oslots_Title8);
        table_Layout[7] = findViewById(R.id.TableLayout8);

        From[8] = findViewById(R.id.From9);
        To[8] = findViewById(R.id.To9);
        date2[8] = findViewById(R.id.Date9);
        time2[8] = findViewById(R.id.Time9);
        user2[8] = findViewById(R.id.Username9);
        vehicle2[8] = findViewById(R.id.Vehicle9);
        tslots2[8] = findViewById(R.id.tslots9);
        oslots2[8] = findViewById(R.id.oslots9);
        desc2[8] = findViewById(R.id.Description9);
        status2[8] = findViewById(R.id.Status9);
        vehicle_title[8] = findViewById(R.id.Vehicle_Title9);
        tslots_title[8] = findViewById(R.id.tslots_Title9);
        oslots_title[8] = findViewById(R.id.oslots_Title9);
        table_Layout[8] = findViewById(R.id.TableLayout9);

        From[9] = findViewById(R.id.From10);
        To[9] = findViewById(R.id.To10);
        date2[9] = findViewById(R.id.Date10);
        time2[9] = findViewById(R.id.Time10);
        user2[9] = findViewById(R.id.Username10);
        vehicle2[9] = findViewById(R.id.Vehicle10);
        tslots2[9] = findViewById(R.id.tslots10);
        oslots2[9] = findViewById(R.id.oslots10);
        desc2[9] = findViewById(R.id.Description10);
        status2[9] = findViewById(R.id.Status10);
        vehicle_title[9] = findViewById(R.id.Vehicle_Title10);
        tslots_title[9] = findViewById(R.id.tslots_Title10);
        oslots_title[9] = findViewById(R.id.oslots_Title10);
        table_Layout[9] = findViewById(R.id.TableLayout10);

        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                    Post post = snapshots.toObject(Post.class);
                    status2[count].setVisibility(View.VISIBLE);
                    table_Layout[count].setVisibility(View.VISIBLE);
                    From[count].setText(post.getFrom());
                    To[count].setText(post.getTo());
                    date2[count].setText(post.getDate());
                    time2[count].setText(post.getTime());
                    user2[count].setText(post.getUsername());
                    status2[count].setText(post.getText());
                    desc2[count].setText(post.getDesc());
                    String status1 = post.getText();
                    if (status1.equals("Requesting")) {
                        vehicle2[count].setVisibility(View.GONE);
                        oslots2[count].setVisibility(View.GONE);
                        tslots2[count].setVisibility(View.GONE);
                        vehicle_title[count].setVisibility(View.GONE);
                        tslots_title[count].setVisibility(View.GONE);
                        oslots_title[count].setVisibility(View.GONE);
                    }
                    vehicle2[count].setText(post.getVehicle());
                    oslots2[count].setText(Integer.toString((int) post.getoSlots()));
                    tslots2[count].setText(Integer.toString((int) post.gettSlots()));
                    count++;
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: " + e.toString());
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1=0;
                String f_source = source_filter.getText().toString().trim();
                String f_destination = to_filter.getText().toString().trim();
                String f_date = date_filter.getText().toString().trim();
                String f_time = time_filter.getText().toString().trim();
                if(TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time))
                {
                    Toast.makeText(MainActivity.this, "ERROR! No Filter found", Toast.LENGTH_SHORT).show();
                }else
                {
                    for(int i=0;i<count;i++)
                    {
                        status2[i].setVisibility(View.GONE);
                        table_Layout[i].setVisibility(View.GONE);
                    }
                    collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if(!TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)) {
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if ((a.equals(f_source) && b.equals(f_destination) && c.equals(f_date) && d.equals(f_time))) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0) {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)) {
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if ((a.equals(f_source) && b.equals(f_destination) && c.equals(f_date))) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (a.equals(f_source) && d.equals(f_time) && c.equals(f_date)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (a.equals(f_source) && b.equals(f_destination) && d.equals(f_time)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (d.equals(f_time) && b.equals(f_destination) && c.equals(f_date)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)) {
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (a.equals(f_source) && b.equals(f_destination)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (a.equals(f_source) && c.equals(f_date)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (a.equals(f_source) && d.equals(f_time)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (b.equals(f_destination) && c.equals(f_date)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (b.equals(f_destination) && d.equals(f_time)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (d.equals(f_time) && c.equals(f_date)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && !TextUtils.isEmpty(f_time)) {
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (d.equals(f_time)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && !TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (c.equals(f_date)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                            }
                                else if(TextUtils.isEmpty(f_source) && !TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (b.equals(f_destination)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else if(!TextUtils.isEmpty(f_source) && TextUtils.isEmpty(f_destination) && TextUtils.isEmpty(f_date) && TextUtils.isEmpty(f_time)){
                                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {
                                        Post post = snapshots.toObject(Post.class);
                                        String a = post.getFrom();
                                        String b = post.getTo();
                                        String c = post.getDate();
                                        String d = post.getTime();
                                        if (a.equals(f_source)) {
                                            status2[count1].setVisibility(View.VISIBLE);
                                            table_Layout[count1].setVisibility(View.VISIBLE);
                                            From[count1].setText(post.getFrom());
                                            To[count1].setText(post.getTo());
                                            date2[count1].setText(post.getDate());
                                            time2[count1].setText(post.getTime());
                                            user2[count1].setText(post.getUsername());
                                            status2[count1].setText(post.getText());
                                            desc2[count1].setText(post.getDesc());
                                            String status1 = post.getText();
                                            if (status1.equals("Requesting")) {
                                                vehicle2[count1].setVisibility(View.GONE);
                                                oslots2[count1].setVisibility(View.GONE);
                                                tslots2[count1].setVisibility(View.GONE);
                                                vehicle_title[count1].setVisibility(View.GONE);
                                                tslots_title[count1].setVisibility(View.GONE);
                                                oslots_title[count1].setVisibility(View.GONE);
                                            }
                                            vehicle2[count1].setText(post.getVehicle());
                                            oslots2[count1].setText(Integer.toString((int) post.getoSlots()));
                                            tslots2[count1].setText(Integer.toString((int) post.gettSlots()));
                                            count1++;
                                        }
                                    }
                                    if(count1==0)
                                    {
                                        Toast.makeText(MainActivity.this, "No Posts Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
        new_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NewPost.class));
            }
        });

    }
}