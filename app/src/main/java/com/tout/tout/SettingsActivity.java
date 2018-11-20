package com.tout.tout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView frequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        frequency = findViewById(R.id.frequency);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
        /*
        Button changeLang = findViewById(R.id.changeLang);
        changeLang.setOnClickListener(v -> {
            final CharSequence[] items = {"Русский", "English"}; //имена методов Ваших в списке
            AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
            builder.setItems(items, (dialog, item) -> {
                if (item == 0) {

                }
                if (item == 1) {

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        });
        */

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        frequency.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}