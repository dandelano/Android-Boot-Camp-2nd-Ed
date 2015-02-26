package net.androidbootcamp.caseproject11_4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class AverageTimeActivity extends ActionBarActivity {
    final double marathonDistance = 26.0;
    final int oneHourInMinutes = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_time);

        // Get widgets to display results
        TextView results = (TextView)findViewById(R.id.txtResults);
        TextView medalname = (TextView)findViewById(R.id.txtMedalName);
        ImageView imgMedal = (ImageView)findViewById(R.id.imgMedal);

        // Get the shared preferences
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int hours = sharedPref.getInt("hours",0);
        int minutes = sharedPref.getInt("minutes",0);

        // Get the total minutes and calculate per mile average
        int totalMinutes = (hours * oneHourInMinutes) + minutes;
        double averageTimePerMile = (double)totalMinutes/marathonDistance;

        // create format for pace
        DecimalFormat minformat = new DecimalFormat("##.#");

        // display average pace
        results.setText("Your Average pace was " + minformat.format(averageTimePerMile) + " minutes per mile.");

        // determine which medal was earned
        if(averageTimePerMile < 11)// Gold
        {
            medalname.setText("Gold Medal");
            imgMedal.setImageResource(R.drawable.gold);
        }
        else if(averageTimePerMile < 15)// Silver
        {
            medalname.setText("Silver Medal");
            imgMedal.setImageResource(R.drawable.silver);
        }
        else if(averageTimePerMile >= 15)// Bronze
        {
            medalname.setText("Bronze Medal");
            imgMedal.setImageResource(R.drawable.bronze);
        }
        else // Error
        {
            results.setText("Error");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_average_time, menu);
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
