package com.example.connectgame3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){
        if(didWin()) {
            Toast.makeText(this,"you Won!!",Toast.LENGTH_LONG).show();
            return;
        }
//        if(player==8) {
//            Toast.makeText(this,"tie :(",Toast.LENGTH_LONG).show();
//            player=0;
//            return;
//        }
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
    }

    public boolean didWin(){
        return false;
    }
}