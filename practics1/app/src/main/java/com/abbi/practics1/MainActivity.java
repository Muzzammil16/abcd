package com.abbi.practics1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.abbi.practics1.Database.DBOperations;
import com.abbi.practics1.Database.Properties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class  MainActivity extends AppCompatActivity {

   EditText email;
    EditText password;

    Button login;

        @Override
        protected void onCreate (@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            email =findViewById(R.id.editText_email);
            password = findViewById(R.id.editText_password);
            findViewById(R.id.button_login).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String emailtxt = email.getText().toString();
                    final String pass = password.getText().toString();
                    boolean isError = false;
                    if (!isValidate(emailtxt)) {
                        email.setError("Please enter Valid name");
                        isError = true;
                    }
                    if (!isvalidePassword(pass)) {
                        password.setError("Please enter Valid name");
                        isError = true;
                    }
                }


            });
        }



    private Properties getProperties(String email) {
        DBOperations db = new DBOperations();
        return db.getPropertiesInformation(email);
    }
    private boolean isValidate(String email){
        String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Pattern pattern =Pattern.compile(email_pattern);
        Matcher mat=pattern.matcher(email);
        return mat.matches();
    }

    private boolean isvalidePassword(String pass)
    {
        if(pass!= null && pass.length()>6)
        {
            return true;
        }
        return false;
    }
}



