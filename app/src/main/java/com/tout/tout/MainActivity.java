package com.tout.tout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tout.tout.entities.subjects.DataUtil;
import com.tout.tout.entities.subjects.Subject;

public class MainActivity extends AppCompatActivity {

    private SubjectsRecyclerAdapter subjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //initToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

/*
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.settings:
                    Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.settings1:
                    Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_LONG).show();
                    return true;
            }
            return false;
        });
        toolbar.inflateMenu(R.menu.menu);
    }
*/

    private void setRecyclerView() {
        RecyclerView list = findViewById(R.id.subject_recycler);
        subjectAdapter = new SubjectsRecyclerAdapter(this, DataUtil.generateSubjects(), clickListener);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(subjectAdapter);
    }

    private final SubjectsRecyclerAdapter.OnItemClickListener clickListener = position -> {
        //Subject subject = subjectAdapter.getItem(position);
        Intent actorInfoIntent = new Intent(this, UrbanRecyclerActivity.class);
        startActivity(actorInfoIntent);
    };
}