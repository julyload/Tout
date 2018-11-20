package com.tout.tout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class FullInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_info);

        final String WORD = "word";
        final String DEF = "def";

        TextView word = findViewById(R.id.word);
        TextView def = findViewById(R.id.definition);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String wordStr = Objects.requireNonNull(bundle).getString(WORD);
        String defStr = bundle.getString(DEF);

        word.setText(wordStr);
        def.setText(defStr);
    }
}
