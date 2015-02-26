package net.androidbootcamp.latinmusic;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button btnMarimba, btnMerengue;
    MediaPlayer mpMarimba,mpMerengue;
    public enum MP_State
    {
        Playing,Paused,Stopped
    }

    MP_State mplayer_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMarimba = (Button)findViewById(R.id.btnMarimba);
        btnMerengue = (Button)findViewById(R.id.btnMerengue);
        btnMarimba.setOnClickListener(bMarimba);
        btnMerengue.setOnClickListener(bMerengue);

        mpMarimba = new MediaPlayer();
        mpMarimba = MediaPlayer.create(this,R.raw.marimba);
        mpMerengue = new MediaPlayer();
        mpMerengue = MediaPlayer.create(this,R.raw.merengue);
        mplayer_state = MP_State.Paused;
    }

    Button.OnClickListener bMarimba = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (mplayer_state)
            {
                case Paused:
                    mpMarimba.start();
                    mplayer_state = MP_State.Playing;
                    btnMarimba.setText("Pause Marimba Song");
                    btnMerengue.setVisibility(View.INVISIBLE);
                    break;
                case Playing:
                    mpMarimba.pause();
                    mplayer_state = MP_State.Paused;
                    btnMarimba.setText("Play Marimba Song");
                    btnMerengue.setVisibility(View.VISIBLE);
                    break;

            }
        }
    };


    Button.OnClickListener bMerengue = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (mplayer_state)
            {
                case Paused:
                    mpMerengue.start();
                    mplayer_state = MP_State.Playing;
                    btnMerengue.setText("Pause Merengue Song");
                    btnMarimba.setVisibility(View.INVISIBLE);
                    break;
                case Playing:
                    mpMerengue.pause();
                    mplayer_state = MP_State.Paused;
                    btnMerengue.setText("Play Merengue Song");
                    btnMarimba.setVisibility(View.VISIBLE);
                    break;

            }
        }
    };

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
