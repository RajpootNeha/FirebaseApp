package com.example.android.firebaseapp;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;



    Firebase myFireBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myEditText =(EditText) findViewById(R.id.editText);
        myKeyValue =(EditText) findViewById(R.id.editText2);
        myApplyBt =(Button) findViewById(R.id.button);
        Firebase.setAndroidContext(this);
        String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        myFireBase = new Firebase("https://fir-app-760a1.firebaseio.com/Users"+DeviceID);

        myApplyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                myKeyValueData = myKeyValue.getText().toString();
                myStringData = myEditText.getText().toString();
              Firebase myNewChild=myFireBase.child(myKeyValueData);
              myNewChild.setValue(myStringData);
                Toast.makeText(MainActivity.this,myStringData+" is updated with"+myKeyValueData,Toast.LENGTH_SHORT).show();

            }
        });
        }
}
