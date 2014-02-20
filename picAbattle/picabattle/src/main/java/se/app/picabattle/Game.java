package se.app.picabattle;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lukas on 2014-02-14.
 */
public class Game extends Activity implements View.OnClickListener {
    private ImageView imageView,clicked;
    private Button first_btn,sec_btn,third_btn,fourth_btn;
    TextView picTag, question,start,cDown;
    int[] right = new int[] {R.drawable.btn_right};
    int[] wrong = new int[] {R.drawable.btn_wrong};
    Animation m_left,m_right,Image,bounce,blink;
    SeekBar time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        imageView = (ImageView)findViewById(R.id.imageView);
        first_btn = (Button)findViewById(R.id.first_btn);
        sec_btn = (Button)findViewById(R.id.sec_btn);
        third_btn = (Button)findViewById(R.id.third_btn);
        fourth_btn = (Button)findViewById(R.id.fourth_btn);
        picTag = (TextView)findViewById(R.id.picTag);
        question = (TextView)findViewById(R.id.question);
        start = (TextView)findViewById(R.id.start);
        clicked = (ImageView)findViewById(R.id.clicked);
        time = (SeekBar)findViewById(R.id.time);
        cDown = (TextView)findViewById(R.id.cDown);

        Image = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.zoom_in));
        m_left = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.move_left));
        m_right = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.move_right));
        bounce = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.bounce));
        blink = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.blink));

        first_btn.setOnClickListener(this);
        sec_btn.setOnClickListener(this);
        third_btn.setOnClickListener(this);
        fourth_btn.setOnClickListener(this);
        start.setOnClickListener(this);

        imageView.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        picTag.setVisibility(View.INVISIBLE);
        clicked.setVisibility(View.INVISIBLE);
        first_btn.setVisibility(View.INVISIBLE);
        sec_btn.setVisibility(View.INVISIBLE);
        third_btn.setVisibility(View.INVISIBLE);
        fourth_btn.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        cDown.setVisibility(View.INVISIBLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == first_btn){
            first_btn.setBackgroundResource(right[0]);
            first_btn.startAnimation(blink);
            sec_btn.setBackgroundResource(wrong[0]);
            third_btn.setBackgroundResource(wrong[0]);
            fourth_btn.setBackgroundResource(wrong[0]);
            imageView.setVisibility(View.INVISIBLE);
            clicked.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Rätt grattis", 1000).show();
            time.setVisibility(View.INVISIBLE);
            cDown.setVisibility(View.INVISIBLE);


        } else if (view == sec_btn){
            wrong();

        } else if (view == third_btn){
            wrong();

        } else if (view == fourth_btn){
            wrong();

        } else if(view == start){
            countDown();
            time.setVisibility(View.VISIBLE);
            cDown.setVisibility(View.VISIBLE);
            first_btn.setVisibility(View.VISIBLE);
            first_btn.startAnimation(m_right);
            sec_btn.setVisibility(View.VISIBLE);
            sec_btn.startAnimation(m_left);
            third_btn.setVisibility(View.VISIBLE);
            third_btn.startAnimation(m_right);
            fourth_btn.setVisibility(View.VISIBLE);
            fourth_btn.startAnimation(m_left);
            start.setVisibility(View.INVISIBLE);
            picTag.setVisibility(View.VISIBLE);
            picTag.startAnimation(bounce);
            question.setVisibility(View.VISIBLE);
            question.startAnimation(bounce);
            imageView.setVisibility(View.VISIBLE);
            imageView.startAnimation(Image);
        }
    }
    public void wrong(){
        first_btn.setBackgroundResource(right[0]);
        first_btn.startAnimation(blink);
        sec_btn.setBackgroundResource(wrong[0]);
        third_btn.setBackgroundResource(wrong[0]);
        fourth_btn.setBackgroundResource(wrong[0]);
        imageView.setVisibility(View.INVISIBLE);
        clicked.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Fel tyvärr", 1000).show();
        time.setVisibility(View.INVISIBLE);
        cDown.setVisibility(View.INVISIBLE);
    }
    public void countDown(){
        new MyCountDown(30000, 1000).start();
    }

    public class MyCountDown extends CountDownTimer {

        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            time.setMax((int) millisInFuture);
        }

        @Override
        public void onFinish() {
            question.setText("Tiden är Slut");
            first_btn.setBackgroundResource(right[0]);
            first_btn.startAnimation(blink);
            sec_btn.setBackgroundResource(wrong[0]);
            third_btn.setBackgroundResource(wrong[0]);
            fourth_btn.setBackgroundResource(wrong[0]);
            imageView.setVisibility(View.INVISIBLE);
            clicked.setVisibility(View.VISIBLE);
            cDown.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long timeRemaining = millisUntilFinished;
            cDown.setText("" + millisUntilFinished / 1000);
            time.setProgress((int) (timeRemaining));
        }

    }
}


