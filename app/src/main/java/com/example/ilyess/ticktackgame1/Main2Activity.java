package com.example.ilyess.ticktackgame1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    public int playermode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent mIntent = getIntent();
        playermode = mIntent.getIntExtra("mode", 0);
        //Log.d("mode jeu :", String.valueOf(playermode));
    }
    public void buClick(View view) {
        Button buselected=(Button) view;
        buselected.setEnabled(false);
        /*count++;
        if(count%2==1) {
            buselected.setBackgroundColor(Color.RED);
        }
        else
        {
            buselected.setBackgroundColor(Color.BLUE);
        }*/
        int cellid=0;
        switch (buselected.getId())
        {
            case R.id.bu1:
                cellid=1;
                break;
            case R.id.bu2:
                cellid=2;
                break;
            case R.id.bu3:
                cellid=3;
                break;
            case R.id.bu4:
                cellid=4;
                break;
            case R.id.bu5:
                cellid=5;
                break;
            case R.id.bu6:
                cellid=6;
                break;
            case R.id.bu7:
                cellid=7;
                break;
            case R.id.bu8:
                cellid=8;
                break;
            case R.id.bu9:
                cellid=9;
                break;
        }
        PlayGame(cellid,buselected);
        ChekWinner();
    }
    int activeplayer=1;
    ArrayList<Integer> player1= new ArrayList<Integer>();
    ArrayList<Integer> player2= new ArrayList<Integer>();

    void PlayGame(int cellid,Button buselected)
    { int nombre_des_tapes=0;
        if(activeplayer==1)
        {
            buselected.setText("X");
            buselected.setBackgroundColor(Color.RED);
            player1.add(cellid);
            activeplayer=2;
            if(playermode==0 && nombre_des_tapes <10) {
                autoplay();
            }
        nombre_des_tapes++;
        }
        else if (activeplayer==2)
        {   nombre_des_tapes++;
            buselected.setText("O");
            buselected.setBackgroundColor(Color.BLUE);
            player2.add(cellid);
            activeplayer=1;

        }


        //Log.d("player:",String.valueOf(cellid));
        //Log.d("button text :",buselected.getText().toString());
    }
    void ChekWinner()
    {   int winner=-1;
        if(player1.size()==5 && winner==-1)
        { String name="tie";

            Toast.makeText(this,R.string.tie,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Main3Activity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner=1;
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner=2;
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner=1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner=2;
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner=1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner=2;
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner=1;
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner=2;
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner=1;
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner=2;
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner=1;
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner=2;
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner=1;
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner=2;
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner=1;
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner=2;
        }
        if (winner !=-1)
        {
            if (winner ==1) {
               // Log.d("winner: ",String.valueOf(winner));
                String name="Red";

                Toast.makeText(this,R.string.red,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Main3Activity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
            if (winner ==2) {
                //Log.d("player:",String.valueOf(winner));
                String name="Blue";
                Toast.makeText(this,R.string.blue,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, Main3Activity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        }
    }
    void autoplay()
    {
        ArrayList<Integer> emptycells= new ArrayList<Integer>();

        for(int cellid=1;cellid<10;cellid++)
        {
            if(!(player1.contains(cellid)|| player2.contains(cellid)))
            {
                emptycells.add(cellid);
            }
        }
        Random r= new Random();
        int RandomIndex= r.nextInt(emptycells.size()-0)+0;
        int cellid=emptycells.get(RandomIndex);
        Button buselected;

        switch (cellid)
        {
            case 1:
                buselected= (Button)findViewById(R.id.bu1);
                break;
            case 2:
                buselected= (Button)findViewById(R.id.bu2);
                break;
            case 3:
                buselected= (Button)findViewById(R.id.bu3);
                break;
            case 4:
                buselected= (Button)findViewById(R.id.bu4);
                break;
            case 5:
                buselected= (Button)findViewById(R.id.bu5);
                break;
            case 6:
                buselected= (Button)findViewById(R.id.bu6);
                break;
            case 7:
                buselected= (Button)findViewById(R.id.bu7);
                break;
            case 8:
                buselected= (Button)findViewById(R.id.bu8);
                break;
            case 9:
                buselected= (Button)findViewById(R.id.bu9);
                break;
            default:
                buselected= (Button)findViewById(R.id.bu9);

        }
        PlayGame(cellid,buselected);

    }

    public void buclose(View view) {
        //finish();
        System.exit(0);
        //android.os.Process.killProcess(android.os.Process.myPid());
    }

}

