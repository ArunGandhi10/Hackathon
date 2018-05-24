package com.example.welcome.hackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email;
    EditText pass;
    Button but;
    TextView signup;

    FirebaseAuth auth;
    ProgressDialog prg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            auth = FirebaseAuth.getInstance();
            prg = new ProgressDialog(this);

            if (auth.getCurrentUser() != null) {
                finish();
                startActivity(new Intent(this, Welcome.class));
            }
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPassword);
        but  = (Button) findViewById(R.id.buttonSignin);
        signup = (TextView) findViewById(R.id.signup);

        but.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==but){
            startActivity(new Intent(this,Welcome.class));
        }
    }
}
