package com.tout.tout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class FullInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String WORD = "word";
        final String DEF = "def";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_info);
        TextView all = findViewById(R.id.word);
        TextView def = findViewById(R.id.definition);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String actorBio = Objects.requireNonNull(bundle).getString(WORD);
        String word = bundle.getString(DEF);

        all.setText(actorBio);
        def.setText(word);
    }
}
