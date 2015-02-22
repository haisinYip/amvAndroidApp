package com.amv;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private boolean polarFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void crossButtonClick(View v) {

        // Result text fields
        TextView res = (TextView) findViewById(R.id.result_box);

        // Input edit text fields
        // vector1
        EditText v1_1 = (EditText) findViewById(R.id.in1);
        EditText v1_2 = (EditText) findViewById(R.id.in2);

        // vector2
        EditText v2_1 = (EditText) findViewById(R.id.in3);
        EditText v2_2 = (EditText) findViewById(R.id.in4);

        double[] result = new double[3];
        String out = "";

        if (!polarFlag) {
            try {
                result = VectorCalculatorService.crossProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                out = "< " + Double.toString(result[0]) + ", " + Double.toString(result[1]) + ", " + Double.toString(result[2]) + " >" ;

            } catch (NumberFormatException nfe) {
                out = "<>";

            } catch (IllegalArgumentException iae) {
                out = "<>";
            }
        }
        else {
            try {
                result = VectorCalculatorService.crossProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                out = Double.toString(result[2]) + ", theta = " + Double.toString(result[0]) + ", phi = " + Double.toString(result[1]);

            } catch (NumberFormatException nfe) {
                out = "<>";

            } catch (IllegalArgumentException iae) {
                out = "<>";
            }
        }

        res.setText(out);
    }

    public void dotButtonClick(View v) {
        // Result text fields
        TextView res = (TextView) findViewById(R.id.result_box);

        // Input edit text fields
        // vector1
        EditText v1_1 = (EditText) findViewById(R.id.in1);
        EditText v1_2 = (EditText) findViewById(R.id.in2);

        // vector2
        EditText v2_1 = (EditText) findViewById(R.id.in3);
        EditText v2_2 = (EditText) findViewById(R.id.in4);

        double result = 0.0;
        String out = "";

        if (!polarFlag) {
            try {
                result = VectorCalculatorService.scalarProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                out = Double.toString(result);

            } catch (NumberFormatException nfe) {
                out = "";

            } catch (IllegalArgumentException iae) {
                out = "";
            }
        }
        else {
            try {
                result = VectorCalculatorService.scalarProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                out = Double.toString(result);

            } catch (NumberFormatException nfe) {
                out = "";

            } catch (IllegalArgumentException iae) {
                out = "";
            }
        }

        res.setText(out);
    }

    public void plusButtonClick(View v) {

        // Result text fields
        TextView res = (TextView) findViewById(R.id.result_box);

        // Input edit text fields
        // vector1
        EditText v1_1 = (EditText) findViewById(R.id.in1);
        EditText v1_2 = (EditText) findViewById(R.id.in2);

        // vector2
        EditText v2_1 = (EditText) findViewById(R.id.in3);
        EditText v2_2 = (EditText) findViewById(R.id.in4);

        // vector3
        EditText v3_1 = (EditText) findViewById(R.id.in5);
        EditText v3_2 = (EditText) findViewById(R.id.in6);

        double[] result = new double[2];
        String out = "";

        if (!polarFlag) {
            try {
                result = VectorCalculatorService.vectorAddition(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString(), v3_1.getText().toString(), v3_2.getText().toString());
                out = "< " + Double.toString(result[0]) + ", " + Double.toString(result[1]) + " >" ;

            } catch (NumberFormatException nfe) {
                out = "<>";

            } catch (IllegalArgumentException iae) {
                out = "<>";
            }
        }
        else {
            try {
                result = VectorCalculatorService.vectorAddition(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString(), v3_1.getText().toString(), v3_2.getText().toString());
                out = Double.toString(result[0]) + " ∠ " + Double.toString(result[1]);

            } catch (NumberFormatException nfe) {
                out = "";

            } catch (IllegalArgumentException iae) {
                out = "";
            }
        }

        res.setText(out);
    }

    public void coordinateSwitch(View v) {
        Switch coordSwitch = (Switch) findViewById(R.id.switch1);
        if (coordSwitch.isChecked()) {
            coordSwitch.setText("Polar");
            polarFlag = true;
            VectorCalculatorService.polar = true;
        }
        else  {
            coordSwitch.setText("Cartesian");
            polarFlag = false;
            VectorCalculatorService.polar = false;
        }
    }
}
