package com.example.luai.savetextonly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    SharedPreferences sp;
    SharedPreferences.Editor edit;

    Button btnsave;
    EditText user,email,birth;
    Button btnrestore;

    public final String usernamekey = "username";
    public final String emailkey = "Email";
    public final String birthdatekey = "birthdate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave =findViewById(R.id.btnadd);
        user =findViewById(R.id.user);
        email =findViewById(R.id.email);
        birth=findViewById(R.id.Birthdate);
        btnrestore=findViewById(R.id.restore);



        sp= PreferenceManager.getDefaultSharedPreferences(this);
        edit=sp.edit();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               savedata();
            }
        });
        btnrestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = sp.getString(usernamekey,"null");
                String emails = sp.getString(emailkey,"null");
                String birthday = sp.getString(birthdatekey,"null");
                Toast.makeText(MainActivity.this, username+ "|" +emails+ "|"+birthday, Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        savedata();
    }

    public void savedata(){

            String username = user.getText().toString();
            String emails = email.getText().toString();
            String birthday = birth.getText().toString();


            edit.putString(usernamekey,username);
            edit.putString(emailkey,emails);
            edit.putString(birthdatekey,birthday);
            edit.apply();

        }
    }
