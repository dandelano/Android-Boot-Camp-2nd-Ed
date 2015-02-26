package net.androidbootcamp.caseproject3_5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class InputActivity extends ActionBarActivity {
    final double tipPercent = 0.18;
    double billAmount;
    int numberOfPeople;
    double amountDuePerPerson;
    String serviceRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // Get user input
        final EditText billAmnt = (EditText)findViewById(R.id.txtBillAmount);
        final EditText groupSize = (EditText)findViewById(R.id.txtGrpSize);
        final Spinner service = (Spinner)findViewById(R.id.spnrService);

        // Get button and set click listener
        Button btnCalc = (Button)findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            TextView txtResult = (TextView)findViewById(R.id.txtResult);
            @Override
            public void onClick(View v) {
                // Parse values
                billAmount = Double.parseDouble(billAmnt.getText().toString());
                numberOfPeople = Integer.parseInt(groupSize.getText().toString());
                serviceRating = service.getSelectedItem().toString();

                // Calculate values
                amountDuePerPerson = (billAmount/numberOfPeople) * tipPercent;

                // Create format
                DecimalFormat currency = new DecimalFormat("$###,###.00");

                // set output string
                txtResult.setText("Service was " + serviceRating
                        + ", each person owes " + currency.format(amountDuePerPerson));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input, menu);
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
