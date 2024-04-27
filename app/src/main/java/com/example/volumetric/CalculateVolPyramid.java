package com.example.volumetric;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateVolPyramid extends AppCompatActivity implements View.OnClickListener {

    Button buttonCalculate;
    EditText editTextLength, editTextWidth, editTextHeight;
    TextView textView;

    private double length;
    private double width;
    private double height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_vol_pyramid);
        buttonCalculate = findViewById(R.id.btnCalculate);
        editTextLength = findViewById(R.id.lengthPyramid);
        editTextWidth = findViewById(R.id.widthPyramid);
        editTextHeight = findViewById(R.id.heightPyramid);
        textView = findViewById(R.id.answer);

        buttonCalculate.setOnClickListener(this);
    }

    public double getDoubleFromEditText(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter edge", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Double.parseDouble(editText.getText().toString());
    }

    @Override
    public void onClick(View v) {
        length = getDoubleFromEditText(editTextLength);
        width = getDoubleFromEditText(editTextWidth);
        height = getDoubleFromEditText(editTextHeight);
        textView.setText("The volume of a pyramid = " + ((length * width * height)/3));
    }
}