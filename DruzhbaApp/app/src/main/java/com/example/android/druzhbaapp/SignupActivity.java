package com.example.android.druzhbaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import androidx.appcompat.app.AppCompatActivity;


public class SignupActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText phone;
    private Button signup;
    private Button signin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.etUsername);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        phone = findViewById(R.id.etPhone);
        signup = findViewById(R.id.btnSignup);
        signin = findViewById(R.id.btnSignin);


        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nm = username.getText().toString();
                final String pn = phone.getText().toString();
                final String em = email.getText().toString();
                final String ps = password.getText().toString();

                String emPatt = getString(R.string.emailPattern);
                String psPatt = getString(R.string.passwordPattern);
                String pnPatt = getString(R.string.phonePattern);

                if(nm.isEmpty()){
                    username.setError("Please enter a name!");
                    username.requestFocus();
                }else if(pn.isEmpty()){
                    phone.setError("Please enter a phone number!");
                    phone.requestFocus();
                }else if (em.isEmpty()){
                    email.setError("Please enter an email!");
                    email.requestFocus();
                }else if(ps.isEmpty()){
                    password.setError("Please enter a password!");
                    password.requestFocus();
                }else if(!pn.matches(pnPatt)) {
                    Toast.makeText(SignupActivity.this, "Phone must contain 13 symbols and start with +380",
                            Toast.LENGTH_LONG).show();
                }else if(!em.matches(emPatt)) {
                    Toast.makeText(SignupActivity.this, "Invalid email!",
                            Toast.LENGTH_SHORT).show();
                }else if(!ps.matches(psPatt)){
                    Toast.makeText(SignupActivity.this, "Password must contain at least 8 symbols!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    registerUser();
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email.getText().toString(),
                password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
//                    Toast.makeText(SignupActivity.this,
//                            "Registered successfully", Toast.LENGTH_LONG).show();
//
//                    startActivity(new Intent(SignupActivity.this, ProfileActivity.class));

                    FirebaseUser user = mAuth.getCurrentUser();
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(username.getText().toString()).build();
                    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                Toast.makeText(SignupActivity.this,
                            "Registered successfully", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(SignupActivity.this,
                            task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
