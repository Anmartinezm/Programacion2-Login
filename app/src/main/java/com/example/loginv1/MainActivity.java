package com.example.loginv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText User;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Borrar;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (EditText) findViewById(R.id.user);
        Password = (EditText) findViewById(R.id.password);
        Info = (TextView) findViewById(R.id.Failed);
        Login = (Button) findViewById(R.id.login);
        Borrar = (Button) findViewById(R.id.clear);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(User.getText().toString(), Password.getText().toString());
            }
        });
        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setText("");
                Password.setText("");
            }
        });
    }
    private void validate(String userName, String userPassword){
        if ((userName.equals("Unibe")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("Number of Attempts Remaining: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }

    }
}
