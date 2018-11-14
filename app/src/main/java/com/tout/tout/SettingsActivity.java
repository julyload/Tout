package com.tout.tout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(v -> {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
        });

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
