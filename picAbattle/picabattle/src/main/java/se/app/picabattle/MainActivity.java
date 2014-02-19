package se.app.picabattle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageView zoomIn,zoomOut,fadeIn,zoomSpin,blink,bounce;
    Animation zoom_In,zoom_out, fade_In,zoom_spin,Blink,Bounce;
    Button zoomIn_Btn, zoomOut_Btn, fadeIn_Btn, zoomSpin_btn, blink_btn,bounce_btn;
    TextView picTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zoomIn = (ImageView)findViewById(R.id.zoomIn);
        zoomOut = (ImageView)findViewById(R.id.zoomOut);
        fadeIn = (ImageView)findViewById(R.id.fadeIn);
        zoomSpin = (ImageView)findViewById(R.id.zoomSpin);
        bounce = (ImageView)findViewById(R.id.bounce);
        zoomIn_Btn = (Button)findViewById(R.id.zoomIn_btn);
        zoomOut_Btn = (Button)findViewById(R.id.zoomOut_btn);
        fadeIn_Btn = (Button)findViewById(R.id.fadeIn_btn);
        zoomSpin_btn = (Button)findViewById(R.id.zoomSpin_btn);
        bounce_btn = (Button)findViewById(R.id.bounce_btn);
        picTag = (TextView)findViewById(R.id.picTag);
        zoom_In = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.zoom_in));
        zoom_out = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.zoom_out));
        fade_In = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.fade_in));
        zoom_spin = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.zoom_spin));
        Bounce = AnimationUtils.loadAnimation(getApplicationContext(),(R.anim.bouncing));
        zoomIn.setVisibility(View.INVISIBLE);
        zoomOut.setVisibility(View.INVISIBLE);
        fadeIn.setVisibility(View.INVISIBLE);
        zoomSpin.setVisibility(View.INVISIBLE);
        bounce.setVisibility(View.INVISIBLE);
        picTag.setVisibility(View.INVISIBLE);


        zoomIn_Btn.setOnClickListener(this);
        zoomOut_Btn.setOnClickListener(this);
        fadeIn_Btn.setOnClickListener(this);
        zoomSpin_btn.setOnClickListener(this);
        bounce_btn.setOnClickListener(this);


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
        if (id == R.id.action_refresh) {
            Intent i = new Intent(this, MainActivity.class);
            finish();
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == zoomIn_Btn){
            Intent i = new Intent(getApplicationContext(), Game.class);
            startActivity(i);

        } else if(view == zoomOut_Btn){
            zoomOut.setVisibility(View.VISIBLE);
            zoomOut.startAnimation(zoom_out);
            picTag.setVisibility(View.VISIBLE);

        } else if(view == fadeIn_Btn){
            fadeIn.setVisibility(View.VISIBLE);
            fadeIn.startAnimation(fade_In);
            picTag.setVisibility(View.VISIBLE);

        } else if(view == zoomSpin_btn){
            zoomSpin.setVisibility(View.VISIBLE);
            zoomSpin.startAnimation(zoom_spin);
            picTag.setVisibility(View.VISIBLE);

        } else if(view == bounce_btn){
            bounce.setVisibility(View.VISIBLE);
            bounce.startAnimation(Bounce);
            picTag.setVisibility(View.VISIBLE);

        }
    }
}


