package net.androidbootcamp.caseproject11_4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    final int maxHours = 9;
    final int maxMinutes = 59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the text fields
        final EditText txtHours = (EditText) findViewById(R.id.txtHours);
        final EditText txtMinutes = (EditText) findViewById(R.id.txtMinutes);

        // Get the shared preferences
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        // Get the Button and set click event
        Button btnEnter = (Button) findViewById(R.id.btnEnterTime);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean shouldSave = false;
                int hours;
                int minutes;

                // try to get the number values from the input fields
                try {
                    hours = Integer.parseInt(txtHours.getText().toString());
                    minutes = Integer.parseInt(txtMinutes.getText().toString());
                }catch (NumberFormatException e)
                {
                    showError("Please enter both fields");
                    return;
                }

                int totalMinutes = (hours * (maxMinutes + 1)) + minutes;
                int maxMinutesAllowed = (maxHours + 1) * (maxMinutes + 1);

                // total greater than 10 hours
                if(totalMinutes > maxMinutesAllowed)
                {
                    showError("10 hours is the max allowed");
                }
                // minutes not between 0 and 59
                else if(minutes < 0 || maxMinutes < minutes)
                {
                    showError("59 minutes is the max allowed");
                } else
                {
                    // If both hours and minutes are within limits save time
                    shouldSave = true;
                }

                if(shouldSave)
                {
                    // Get shared pref editor and save time to preferences
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("hours",hours);
                    editor.putInt("minutes",minutes);
                    editor.commit();

                    // Start the new activity to display average time and medal earned.
                    startActivity(new Intent(MainActivity.this, AverageTimeActivity.class));
                }
            }
        });
    }

    private void showError(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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
