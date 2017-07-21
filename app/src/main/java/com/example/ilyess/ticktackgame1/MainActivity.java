package com.example.ilyess.ticktackgame1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //change tv gradiant
        TextView tv =(TextView) findViewById(R.id.tv1);
        int[] color = {Color.BLUE,Color.RED};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.REPEAT;
        LinearGradient lin_grad = new LinearGradient(0, 0, 0, 35,color,position, tile_mode);
        Shader shader_gradient = lin_grad;
        tv.getPaint().setShader(shader_gradient);
    }

    public void andoridmode(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("mode", 0);
        startActivity(intent);
    }

    public void playermode(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("mode",1);
        startActivity(intent);


    }
}
