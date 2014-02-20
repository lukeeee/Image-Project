package se.app.picabattle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lukas on 2014-02-20.
 */
public class ScoreBoard extends Activity implements View.OnClickListener {
    Button playBtn,friendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_layout);
        playBtn = (Button)findViewById(R.id.play);
        friendBtn = (Button)findViewById(R.id.friend);


        playBtn.setOnClickListener(this);
        friendBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if(view == friendBtn){
            Intent i = new Intent(getApplicationContext(), Game.class);
            startActivity(i);
        } else if (view == playBtn){
            Intent in = new Intent(getApplicationContext(), GameTwo.class);
            startActivity(in);
        }
    }
}