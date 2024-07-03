package com.example.exercise4;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exercise4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageButton.setOnClickListener(this);
        binding.seekBar.setOnSeekBarChangeListener(this);
        binding.checkNegrito.setOnCheckedChangeListener(this);

        };
    @Override
    public void onClick(View view) {
            String texto = String.valueOf(binding.editText.getText());
            binding.textBox.setText(texto);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.textBox.setTextSize(progress);
//        binding.textoLetra.setText(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int estilo = Typeface.NORMAL;

        if (binding.checkNegrito.isChecked()) {
            estilo |= Typeface.BOLD;
        }
        if (binding.checkItalico.isChecked()) {
            estilo |= Typeface.ITALIC;
        }

        binding.textBox.setTypeface(null, estilo);

        String texto = String.valueOf(binding.editText.getText());
        if (binding.checkMaiusculo.isChecked()) {
            texto = texto.toUpperCase();
        }

        binding.textBox.setText(texto);
    }

}