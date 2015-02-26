package net.androidbootcamp.caseproject4_1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {
    final int maxNumberOfDays = 7;
    final double powerWasherCostPerDay = 55.99;
    final double tilerCostPerDay = 68.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText numDaysTxt = (EditText)findViewById(R.id.txtNumDays);
        final RadioButton radPowerWash = (RadioButton)findViewById(R.id.radPowerWasher);
        final RadioButton radTiler = (RadioButton)findViewById(R.id.radTiler);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        final Button btnCompute = (Button)findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check for empty value
                if(numDaysTxt.getText().toString().trim().isEmpty())
                    return;

                // Get number of days
                int numDays = Integer.parseInt(numDaysTxt.getText().toString());

                // Check if within max
                if(numDays > maxNumberOfDays)
                {
                    Toast.makeText(MainActivity.this,"The Maximum number of days allowed is 7",Toast.LENGTH_LONG).show();
                    return;
                }
                               
                DecimalFormat currency = new DecimalFormat("$#,###.00");

                if(radPowerWash.isChecked())
                {
                    double cost = powerWasherCostPerDay * numDays;
                    result.setText("Total Cost: " + currency.format(cost));

                }else if(radTiler.isChecked())
                {
                    double cost = tilerCostPerDay * numDays;
                    result.setText("Total Cost: " + currency.format(cost));
                }
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
