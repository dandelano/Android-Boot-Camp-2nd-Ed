package net.androidbootcamp.caseproject3_4;

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


public class MainActivity extends ActionBarActivity {
    final double sqftPerGallon = 250.0;
    double numberOfGallons;

    int heightValue, distanceValue;
    double totalSqFt;
    String colorChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText height = (EditText)findViewById(R.id.txtHeight);
        final EditText distance = (EditText)findViewById(R.id.txtDistance);
        final Spinner color = (Spinner)findViewById(R.id.spnrColor);
        Button btnCalc = (Button)findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            TextView results = (TextView)findViewById(R.id.txtResult);

            @Override
            public void onClick(View v) {
                heightValue = Integer.parseInt(height.getText().toString());
                distanceValue = Integer.parseInt(distance.getText().toString());
                totalSqFt = heightValue * distanceValue;
                numberOfGallons = totalSqFt / sqftPerGallon;
                DecimalFormat twodigit = new DecimalFormat("###,###.##");
                colorChoice = color.getSelectedItem().toString();
                results.setText("You need " + twodigit.format(numberOfGallons) + " gallons of " + colorChoice + " paint");
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
