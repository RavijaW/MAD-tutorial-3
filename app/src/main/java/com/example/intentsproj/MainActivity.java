package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button button;

    EditText editText1;
    EditText editText2;
    public static final String EXTRA_NUMBER1="number1";
    public static final String EXTRA_NUMBER2="number2";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater li = getLayoutInflater();
//Getting the View object as defined in the customtoast.xml file
        View layout = ((LayoutInflater) li).inflate(R.layout.customtoast, (ViewGroup)
                findViewById(R.id.custom_toast_layout));
//Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();


         editText1 = (EditText) findViewById(R.id.number1);
         editText2 = (EditText) findViewById(R.id.number2);

        button = (Button) findViewById(R.id.button);


    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                displayToast();
                openActivity2();
            }
        });
    }

    public void openActivity2(){


        String num = editText1.getText().toString();

        String num2 = editText2.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_NUMBER1,num);
        intent.putExtra(EXTRA_NUMBER2,num2);
        startActivity(intent);



    }


    public void displayToast() {
        Toast.makeText(MainActivity.this, "hari boss eelanga activity scene ekata aawa", Toast.LENGTH_SHORT).show();


    }




}