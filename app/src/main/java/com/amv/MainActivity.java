package com.amv;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        TextView resX = (TextView) findViewById(R.id.result_x);
        TextView resY = (TextView) findViewById(R.id.result_y);
        TextView resZ = (TextView) findViewById(R.id.result_z);

        // Input edit text fields
        // vector1
        EditText v1_1 = (EditText) findViewById(R.id.in1);
        EditText v1_2 = (EditText) findViewById(R.id.in2);

        // vector2
        EditText v2_1 = (EditText) findViewById(R.id.in3);
        EditText v2_2 = (EditText) findViewById(R.id.in4);

        double[] result = new double[3];
        String outX = null;
        String outY = null;
        String outZ = null;

        if (!polarFlag) {
            try {
                result = VectorCalculatorService.crossProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                outX = Double.toString(result[0]);
                outY = Double.toString(result[1]);
                outZ = Double.toString(result[2]);

            } catch (NumberFormatException nfe) {
                outX = "";
                outY = "";
                outZ = "";

            } catch (IllegalArgumentException iae) {
                outX = "";
                outY = "";
                outZ = "";
            }
        }
        else {
            try {
                result = VectorCalculatorService.crossProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                outX = Double.toString(result[0]);
                outY = Double.toString(result[1]);
                outZ = Double.toString(result[2]);

            } catch (NumberFormatException nfe) {
                outX = "";
                outY = "";
                outZ = "";

            } catch (IllegalArgumentException iae) {
                outX = "";
                outY = "";
                outZ = "";
            }
        }

        resX.setText(outX);
        resY.setText(outY);
        resZ.setText(outZ);
    }

    public void dotButtonClick(View v) {
        // Result text fields
        TextView resX = (TextView) findViewById(R.id.result_x);
        TextView resY = (TextView) findViewById(R.id.result_y);
        TextView resZ = (TextView) findViewById(R.id.result_z);

        // Input edit text fields
        // vector1
        EditText v1_1 = (EditText) findViewById(R.id.in1);
        EditText v1_2 = (EditText) findViewById(R.id.in2);

        // vector2
        EditText v2_1 = (EditText) findViewById(R.id.in3);
        EditText v2_2 = (EditText) findViewById(R.id.in4);

        double[] result = new double[3];
        String outX = null;
        String outY = null;
        String outZ = null;

        if (!polarFlag) {
            try {
                result = VectorCalculatorService.crossProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                outX = Double.toString(result[0]);
                outY = Double.toString(result[1]);
                outZ = Double.toString(result[2]);

            } catch (NumberFormatException nfe) {
                outX = "";
                outY = "";
                outZ = "";

            } catch (IllegalArgumentException iae) {
                outX = "";
                outY = "";
                outZ = "";
            }
        }
        else {
            try {
                result = VectorCalculatorService.crossProduct(v1_1.getText().toString(), v1_2.getText().toString(), v2_1.getText().toString(), v2_2.getText().toString());
                outX = Double.toString(result[0]);
                outY = Double.toString(result[1]);
                outZ = Double.toString(result[2]);

            } catch (NumberFormatException nfe) {
                outX = "";
                outY = "";
                outZ = "";

            } catch (IllegalArgumentException iae) {
                outX = "";
                outY = "";
                outZ = "";
            }
        }

        resX.setText(outX);
        resY.setText(outY);
        resZ.setText(outZ);
    }

    public void plusButtonClick(View v) {

    }

    public void coordinateSwitch(View v) {
        Switch coordSwitch = (Switch) findViewById(R.id.switch1);
        if (coordSwitch.isChecked()) {
            coordSwitch.setText("Polar");
            polarFlag = true;
        }
        else  {
            coordSwitch.setText("Cartesian");
            polarFlag = false;
        }
    }
}
