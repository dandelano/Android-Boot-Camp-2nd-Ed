package net.androidbootcamp.waveanimation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {
    AnimationDrawable surfAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFrame = (ImageView)findViewById(R.id.imgSurf);
        imgFrame.setBackgroundResource(R.drawable.animation);
        surfAnimation = (AnimationDrawable)imgFrame.getBackground();
        Button btnFrame = (Button)findViewById(R.id.btnStart);
        Button btnTween = (Button)findViewById(R.id.btnStop);
        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surfAnimation.start();
            }
        });
        btnTween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surfAnimation.stop();
                startActivity(new Intent(MainActivity.this,Tween.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}