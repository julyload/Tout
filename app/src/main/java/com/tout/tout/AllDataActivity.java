package com.tout.tout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class AllDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String WORD = "word";
        final String DEF = "def";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_info);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String actorBio = Objects.requireNonNull(bundle).getString(WORD);
        String actorName = bundle.getString(DEF);
        TextView all = findViewById(R.id.allDataName);
        TextView def = findViewById(R.id.definition);
        all.setText(actorBio);
        def.setText(actorName);
    }
}
