package com.example.anu.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SeekBar percent_seekbar;
    private Button calculate_button;
    private TextView result;
    private EditText billAmount;
    private TextView percentView;
    private int seekbar_percentage;
    private float enteredAmt, totalBill;
    private TextView totalbillAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate_button = (Button) findViewById(R.id.calculate_button);
        result = (TextView) findViewById(R.id.resultid);
        percentView = (TextView) findViewById(R.id.percentvalue);
        totalbillAmount = (TextView) findViewById(R.id.totalBillId);
        percent_seekbar = (SeekBar) findViewById(R.id.percentid);
        billAmount = (EditText) findViewById(R.id.billAmountId);
        calculate_button.setOnClickListener(this);

        percent_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentView.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbar_percentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v){

        calculate();
    }

    public void calculate(){
        float tipAmt = 0.0f;
        if(!billAmount.getText().toString().equals("")) {
            enteredAmt = Float.parseFloat(billAmount.getText().toString());
            tipAmt = (enteredAmt * seekbar_percentage)/100;
            result.setText("Tip : "+String.valueOf(tipAmt)+" $");
            totalBill = tipAmt + enteredAmt;
            totalbillAmount.setText("Total Bill: "+String.valueOf(totalBill)+" $");

        }else{
            Toast.makeText(MainActivity.this,"Please enter the bill amount!", Toast.LENGTH_LONG).show();
        }
    }
}

