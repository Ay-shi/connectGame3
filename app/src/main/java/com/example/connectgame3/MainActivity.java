package com.example.connectgame3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int [][] winningState={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){
        gameState[Integer.parseInt(view.getTag().toString())]=player;

        ImageView component=(ImageView) view;
        component.setTranslationY(-1000);
        if (player == 0) {
            player=1;
            component.setImageResource(R.drawable.cross);
        } else {
            player=0;
            component.setImageResource(R.drawable.zero);
        }
        component.animate().translationYBy(1000);

        if(didWin()) {
            Toast.makeText(this,"You Won!!",Toast.LENGTH_LONG).show();
            return;
        }
    }

    public boolean didWin(){
        for(int [] pos:winningState){
            if(gameState[pos[0]]!=2 && gameState[pos[0]]==gameState[pos[1]] && gameState[pos[1]]==gameState[pos[2]]) return true;
        }
        return false;
    }
}