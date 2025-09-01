package com.avishkar.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    private EditText edtFirst,edtSecond;
    private Button btnAdd, btnSubtract, btnDiv, btnMultiply;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //init components
        initComp();

        //click on add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String firstVal = edtFirst.getText().toString();
                 String secondVal = edtSecond.getText().toString();

                 if (firstVal.equals("") || secondVal.equals("")) {
                     Toast.makeText(MainActivity.this,"Empty fields are not allowed",Toast.LENGTH_LONG).show();
                 }
                 else {
                     int num1 = Integer.parseInt(firstVal);
                     int num2 = Integer.parseInt(secondVal);

                     int result = num1 + num2;
                     tvResult.setText("Result :"+result);
                 }

            }
        });

        //click on subtract button
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstVal = edtFirst.getText().toString();
                String secondVal = edtSecond.getText().toString();

                if (firstVal.equals("") || secondVal.equals("")) {
                    Toast.makeText(MainActivity.this,"Empty fields are not allowed",Toast.LENGTH_LONG).show();
                }
                else {
                    int num1 = Integer.parseInt(firstVal);
                    int num2 = Integer.parseInt(secondVal);

                    int result = num1 - num2;
                    tvResult.setText("Result :"+result);
                }
            }
        });

        //click on division button
//        btnDiv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String firstVal = edtFirst.getText().toString();
//                String secondVal = edtSecond.getText().toString();
//
//                if (firstVal.equals("") || secondVal.equals("")) {
//                    Toast.makeText(MainActivity.this,"Empty fields are not allowed",Toast.LENGTH_LONG).show();
//                }
//                else {
//                    int num1 = Integer.parseInt(firstVal);
//                    int num2 = Integer.parseInt(secondVal);
//
//                    int result = num1 / num2; //logic
//                    tvResult.setText("Result :"+result);
//                }
//            }
//        });

        //click on multiply button
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstVal = edtFirst.getText().toString();
                String secondVal = edtSecond.getText().toString();

                if (firstVal.equals("") || secondVal.equals("")) {
                    Toast.makeText(MainActivity.this,"Empty fields are not allowed",Toast.LENGTH_LONG).show();
                }
                else {
                    int num1 = Integer.parseInt(firstVal);
                    int num2 = Integer.parseInt(secondVal);

                    int result = num1 * num2; //logic
                    tvResult.setText("Result :"+result);
                }
            }
        });

    }

    private void initComp() {
        edtFirst = findViewById(R.id.edtFirst);
        edtSecond = findViewById(R.id.edtSecond);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnDiv = findViewById(R.id.btnDiv);
        btnMultiply = findViewById(R.id.btnMultiply);
        tvResult = findViewById(R.id.tvResult);
    }
}