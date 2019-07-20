package com.example.scoreboardscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ChangeBatsman extends AppCompatActivity {

    Button done;
    EditText newB , whoHelped;
    Spinner wicket,batsmans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_batsman);

        done = findViewById(R.id.doneAddNewBatsman);
        newB = findViewById(R.id.newBatsman);
        whoHelped = findViewById(R.id.whoHelped);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnewBatsman();
            }
        });
    }

    private void addnewBatsman() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("newBatsman",newB.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
