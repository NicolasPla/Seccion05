package com.example.seccion05;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fabAddBoard);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertForCreatingBoard("Add New Board.", "Type a name for your new board");
            }
        });
    }

    private void showAlertForCreatingBoard(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (title != null)builder.setTitle(title);
        if (message != null)builder.setMessage(message);

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.dialog_create_board, null);
        builder.setView(viewInflated);

        final EditText input = viewInflated.findViewById(R.id.editTextNewBoard);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String boardName = input.getText().toString().trim();
                if (boardName.length() > 0)
                    createNewBoard(boardName);
                    else
                    Toast.makeText(getApplicationContext(), "The name is ewquider to create a new Board", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void createNewBoard(String boardName){


    }
}
