package com.example.scoreboardscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChangeBowler extends AppCompatActivity {

    EditText newBowler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bowler);
        newBowler = findViewById(R.id.newBowler);
    }

    public void changeBowler(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("newBowler",newBowler.getText().toString());
        setResult(002,intent);
        finish();
    }
}
