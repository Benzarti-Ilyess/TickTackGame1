package com.example.ilyess.ticktackgame1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle b= getIntent().getExtras();
        String Name=b.getString("name");
        show= (TextView) findViewById(R.id.tv);
        if (Name.equals("Red"))
        {
            show.setTextColor(Color.RED);
            show.setText(R.string.red);
        }
        else if (Name.equals("Blue"))
        {
            show.setTextColor(Color.BLUE);
            show.setText(R.string.blue);
        }
        else if (Name.equals("tie"))
        {
            show.setTextColor(Color.BLACK);
            show.setText(R.string.tie);
        }

    }

    public void restartgame(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
