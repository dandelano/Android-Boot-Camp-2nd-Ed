package net.androidbootcamp.caseproject6_6;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button btnAnimals, btnMaps, btnSugar;
    MediaPlayer mpAnimals,mpMaps,mpSugar;
    public enum MP_State
    {
        Playing,Paused,Stopped
    }

    MP_State mplayer_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get buttons and set onclick listeners
        btnAnimals = (Button)findViewById(R.id.btnAnimals);
        btnMaps = (Button)findViewById(R.id.btnMaps);
        btnSugar = (Button)findViewById(R.id.btnSugar);

        btnAnimals.setOnClickListener(bAnimals);
        btnMaps.setOnClickListener(bMaps);
        btnSugar.setOnClickListener(bSugar);

        // Create new media players and set audio files.
        mpAnimals = new MediaPlayer();
        mpAnimals = MediaPlayer.create(this,R.raw.animals);
        mpMaps = new MediaPlayer();
        mpMaps = MediaPlayer.create(this, R.raw.maps);
        mpSugar = new MediaPlayer();
        mpSugar = MediaPlayer.create(this, R.raw.sugar);

        // set initial state
        mplayer_state = MP_State.Paused;
    }

    Button.OnClickListener bAnimals = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (mplayer_state)

            {
                case Paused:
                    mpAnimals.start();
                    mplayer_state = MP_State.Playing;
                    btnAnimals.setText("Pause Animals");
                    btnMaps.setVisibility(View.INVISIBLE);
                    btnSugar.setVisibility(View.INVISIBLE);
                    break;
                case Playing:
                    mpAnimals.pause();
                    mplayer_state = MP_State.Paused;
                    btnAnimals.setText("Play Animals");
                    btnMaps.setVisibility(View.VISIBLE);
                    btnSugar.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener bMaps = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (mplayer_state)
            {
                case Paused:
                    mpMaps.start();
                    mplayer_state = MP_State.Playing;
                    btnMaps.setText("Pause Maps");
                    btnAnimals.setVisibility(View.INVISIBLE);
                    btnSugar.setVisibility(View.INVISIBLE);
                    break;
                case Playing:
                    mpMaps.pause();
                    mplayer_state = MP_State.Paused;
                    btnMaps.setText("Play Maps");
                    btnAnimals.setVisibility(View.VISIBLE);
                    btnSugar.setVisibility(View.VISIBLE);
                    break;

            }
        }
    };

    Button.OnClickListener bSugar = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (mplayer_state)

            {
                case Paused:
                    mpSugar.start();
                    mplayer_state = MP_State.Playing;
                    btnSugar.setText("Pause Sugar");
                    btnAnimals.setVisibility(View.INVISIBLE);
                    btnMaps.setVisibility(View.INVISIBLE);
                    break;
                case Playing:
                    mpSugar.pause();
                    mplayer_state = MP_State.Paused;
                    btnSugar.setText("Play Sugar");
                    btnAnimals.setVisibility(View.VISIBLE);
                    btnMaps.setVisibility(View.VISIBLE);
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
