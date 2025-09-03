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
            public void onClick(View view) {
                calculate(view.getId()); //R.id.btnAdd
            }
        });

        //click on subtract button
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(view.getId());
            }
        });

        //click on division button
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v.getId());

            }
        });

        //click on multiply button
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v.getId());
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

    private int validateData(int id){
        String firstValue = edtFirst.getText().toString();
        String secondValue = edtSecond.getText().toString();

        if(firstValue.isEmpty() || secondValue.isEmpty() ) {
            Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show();
            return Integer.MIN_VALUE;
        }
        else {
            int num1 = Integer.parseInt(firstValue);
            int num2 = Integer.parseInt(secondValue);

            if (id == R.id.btnAdd) {
                return num1 + num2;
            }
            else if (id ==R.id.btnSubtract) {
                return num1 - num2;
            }
            else if (id == R.id.btnDiv) {
                return num1 / num2;
            }
            else if (id == R.id.btnMultiply) {
                return num1 * num2;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }
    }

    private void calculate(int id) {
        //id = R.id.btnAdd
        double result = validateData(id);  //R.id.btnAdd;
        if (result != Integer.MIN_VALUE) {
            tvResult.setText("Result : "+result);
        }
    }



}