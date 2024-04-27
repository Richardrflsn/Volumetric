package com.example.volumetric;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateVolBall extends AppCompatActivity implements View.OnClickListener {

    Button buttonCalculate;
    EditText editTextRadius;
    TextView textView;

    private double radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_vol_ball);
        buttonCalculate = findViewById(R.id.btnCalculate);
        editTextRadius = findViewById(R.id.radius);
        textView = findViewById(R.id.answer);

        buttonCalculate.setOnClickListener(this);
    }

    public double getDoubleFromEditText(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter radius", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Double.parseDouble(editText.getText().toString());
    }

    @Override
    public void onClick(View v) {
        radius = getDoubleFromEditText(editTextRadius);
        textView.setText("The volume of a ball = " + (4.0/3.0 * Math.PI * (radius * radius * radius)));
    }
}