package com.example.volumetric;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateVolCube extends AppCompatActivity implements View.OnClickListener {

    Button buttonCalculate;
    EditText editTextEdge;
    TextView textView;

    private double edge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_vol_cube);
        buttonCalculate = findViewById(R.id.btnCalculate);
        editTextEdge = findViewById(R.id.edgeCube);
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

    public abstract static class VolumeCalculator {
        public abstract double calculateVolume(double edge);
    }

    private class CubeVolumeCalculator extends VolumeCalculator {
        @Override
        public double calculateVolume(double edge) {
            return edge * edge * edge;
        }
    }

    @Override
    public void onClick(View v) {
        edge = getDoubleFromEditText(editTextEdge);
        CubeVolumeCalculator calculator = new CubeVolumeCalculator();
        double volume = calculator.calculateVolume(edge);
        textView.setText("The volume of a cube = " + volume);
    }
}