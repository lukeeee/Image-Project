package se.app.picabattle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
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
        zoomIn_Btn = (Button)findViewById(R.id.zoomIn_btn);


        zoomIn_Btn.setOnClickListener(this);


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
            Intent i = new Intent(getApplicationContext(), ScoreBoard.class);
            startActivity(i);
        }
}
}


