package com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.auth.User;

public class Register extends AppCompatActivity {

    private EditText password,confirmPassword,email,phone;
    private Button register;
    private TextView display;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        password = findViewById(R.id.editText_Password);
        email = findViewById(R.id.editText_Email);
        confirmPassword = findViewById(R.id.editText_CPassword);
        register = findViewById(R.id.register);
        display = findViewById(R.id.display_text);
        phone = findViewById(R.id.editText_PhoneNumber);

        try {
            fAuth = FirebaseAuth.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(fAuth.getCurrentUser()!= null)
        {
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String confirm = confirmPassword.getText().toString().trim();
                String phoneN = phone.getText().toString().trim();
                if(TextUtils.isEmpty(email1))
                {
                    email.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(phoneN))
                {
                    phone.setError("Phone Number is Required");
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    password.setError("Password is Required");
                    return;
                }
                if(TextUtils.isEmpty(confirm))
                {
                    confirmPassword.setError("Enter Confirm Password");
                    return;
                }
                if(!confirm.equals(pass))
                {
                    confirmPassword.setError("Passwords do not match");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email1,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
    }
}