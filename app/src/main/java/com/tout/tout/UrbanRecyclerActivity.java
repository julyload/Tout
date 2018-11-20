package com.tout.tout;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tout.tout.entities.urban.MyResponse;
import com.tout.tout.entities.urban.Note;
import com.tout.tout.network.NetworkModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("SameParameterValue")

public class UrbanRecyclerActivity extends AppCompatActivity {

    private UrbanRecyclerAdapter urbanAdapter;
    //private List<Note> notes;
    private final String WORD = "word";
    private final String DEF = "def";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urban_recycler);

        setRecyclerView();

        callUrbanData();

        scheduleNotification(getNotification());
    }

    //public Note getItem(int position) {return notes.get(position);}

    private void callUrbanData() {
        NetworkModule apiHelper = new NetworkModule();
        apiHelper.service().getUrbanRandom().enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(@NonNull Call<MyResponse> call, @NonNull Response<MyResponse> response) {
                MyResponse myResponse = response.body();
                if (myResponse != null) {
                    final List<Note> note = myResponse.getList();
                    urbanAdapter.replaceWith(note);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MyResponse> call, @NonNull Throwable t) {
            }
        });
    }

    private void setRecyclerView() {
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.urban_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        urbanAdapter = new UrbanRecyclerAdapter(clickListener);
        recyclerView.setAdapter(urbanAdapter);
    }

    private void scheduleNotification(Notification notification) {
        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60000, pendingIntent);
        }
    }

    private Notification getNotification() {
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("ROFL")
                .setContentText("ROFL is an internet accronmym for Rolling On Floor Laughing, an")
                .setSmallIcon(R.drawable.tout_logo3)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(Notification.PRIORITY_HIGH);
        return builder.build();
    }

    private final UrbanRecyclerAdapter.OnItemClickListener clickListener = position -> {
        Note subject = urbanAdapter.getItem(position);
        Intent actorInfoIntent = new Intent(this, FullInfoActivity.class);
        actorInfoIntent.putExtra(WORD, subject.getWord());
        actorInfoIntent.putExtra(DEF, subject.getDefinition());
        startActivity(actorInfoIntent);
    };
}