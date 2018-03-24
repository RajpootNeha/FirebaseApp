package com.example.android.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    EditText myEditText;
    Button myApplyBt;
    String myStringData;



    Firebase myFireBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myEditText =(EditText) findViewById(R.id.editText);
        myApplyBt =(Button) findViewById(R.id.button);



        Firebase.setAndroidContext(this);
        myFireBase = new Firebase("https://fir-app-760a1.firebaseio.com");

        myApplyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                myStringData = myEditText.getText().toString();
              Firebase myNewChild=myFireBase.child("ChildName");
              myNewChild.setValue(myStringData);
                Toast.makeText(MainActivity.this,"child updated with"+myStringData,Toast.LENGTH_SHORT).show();
            }
        });
        }
}
