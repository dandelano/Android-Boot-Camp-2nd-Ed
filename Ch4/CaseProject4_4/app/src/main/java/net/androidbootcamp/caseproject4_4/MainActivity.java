package net.androidbootcamp.caseproject4_4;

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


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtNumOne = (EditText)findViewById(R.id.txtNumberOne);
        final EditText txtNumTwo = (EditText)findViewById(R.id.txtNumberTwo);
        final RadioButton radAdd = (RadioButton)findViewById(R.id.radAdd);
        final RadioButton radSubtract = (RadioButton)findViewById(R.id.radSubtract);
        final RadioButton radMultiply = (RadioButton)findViewById(R.id.radMultiply);
        final Button btnShowSolution = (Button)findViewById(R.id.btnShowSolution);
        final TextView solution = (TextView)findViewById(R.id.txtSolution);


        btnShowSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check for valid numbers
                if(txtNumOne.getText().toString().trim().isEmpty() || txtNumTwo.getText().toString().trim().isEmpty())
                    return;

                int firstNum = Integer.parseInt(txtNumOne.getText().toString());
                int secondNum = Integer.parseInt(txtNumTwo.getText().toString());

                if((firstNum < 1 || firstNum > 20)||(secondNum < 1 || secondNum > 20))
                {
                    Toast.makeText(MainActivity.this,"Both numbers must be between 1 and 20",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(radAdd.isChecked())
                {
                    solution.setText(firstNum +" + "+secondNum +" = "+(firstNum+secondNum));

                }else if(radSubtract.isChecked())
                {
                    solution.setText(firstNum +" - "+secondNum +" = "+(firstNum-secondNum));
                }else if(radMultiply.isChecked())
                {
                    solution.setText(firstNum +" x "+secondNum +" = "+(firstNum*secondNum));
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
