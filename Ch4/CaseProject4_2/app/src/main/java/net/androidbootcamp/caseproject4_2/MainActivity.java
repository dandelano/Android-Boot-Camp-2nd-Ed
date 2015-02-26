package net.androidbootcamp.caseproject4_2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
    final int maxNumberOfDays = 10;
    final double compactCostPerDay = 59.99;
    final double midSizeCostPerDay = 65.99;
    final double luxuryCostPerDay = 89.99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtNumDays = (EditText)findViewById(R.id.txtNumDays);
        final RadioButton radCompact = (RadioButton)findViewById(R.id.radCompact);
        final RadioButton radMidSize = (RadioButton)findViewById(R.id.radMidSize);
        final RadioButton radLuxury = (RadioButton)findViewById(R.id.radLuxury);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        final Button btnCompute = (Button)findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumDays.getText().toString().trim().isEmpty())
                    return;

                int numDays = Integer.parseInt(txtNumDays.getText().toString());

                if(numDays > maxNumberOfDays)
                {
                    Toast.makeText(MainActivity.this,"10 days is the max allowed", Toast.LENGTH_LONG).show();
                    return;
                }

                DecimalFormat currency = new DecimalFormat("$###,###.00");
                double cost = 0.0;

                if(radCompact.isChecked())
                {
                    cost = compactCostPerDay * numDays;
                }else if(radMidSize.isChecked())
                {
                    cost = midSizeCostPerDay * numDays;
                }else if(radLuxury.isChecked())
                {
                    cost = luxuryCostPerDay * numDays;
                }

                result.setText("Total Cost: " + currency.format(cost));
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
