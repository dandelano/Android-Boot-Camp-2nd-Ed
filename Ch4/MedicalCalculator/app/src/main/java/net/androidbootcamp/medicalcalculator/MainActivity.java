package net.androidbootcamp.medicalcalculator;

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
    final double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight = (EditText)findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = (RadioButton)findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = (RadioButton)findViewById(R.id.radKiloToLb);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button)findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                if(lbToKilo.isChecked())
                {
                    if(weightEntered <= 500)
                    {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Kilograms");
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500",Toast.LENGTH_LONG).show();
                    }
                }else if(kiloToLb.isChecked())
                {
                    if(weightEntered <= 225)
                    {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Pounds");
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Kilos must be less than 225",Toast.LENGTH_LONG).show();
                    }
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
