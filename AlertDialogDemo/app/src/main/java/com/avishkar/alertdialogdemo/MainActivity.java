package com.avishkar.alertdialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenDialog;
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

        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openDialog();
                openDialogWithBuilder();
            }
        });

    }

    public void openDialog() {
            AlertDialog dialog = new AlertDialog.Builder(this).create();
            dialog.setTitle("Delete");
            dialog.setMessage("Are you sure you wants to delete this message?");
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                }
            });


            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();


    }

    private void openDialogWithBuilder() {
         AlertDialog.Builder dialog =  new AlertDialog.Builder(MainActivity.this);
         dialog.setTitle("Delete");
        // dialog.setMessage("Are you sure you wants to delete this message?");


         String arr[] = {"Red","Orange","Blue","Dark","white"};
         dialog.setItems(arr, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int i) {
                 String selected = arr[i];
                 Toast.makeText(MainActivity.this, "selected:"+selected, Toast.LENGTH_SHORT).show();
             }
         });

//         dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//             @Override
//             public void onClick(DialogInterface dialog, int which) {
//                 Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
//             }
//         });
//
//         dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//             @Override
//             public void onClick(DialogInterface dialog, int which) {
//                 Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
//                 dialog.dismiss();
//             }
//         });

         dialog.show();
    }
}

