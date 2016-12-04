package com.avontell.simcrawl;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.avontell.simcrawl.domain.Event;
import com.avontell.simcrawl.domain.EventType;
import com.avontell.simcrawl.domain.Room;
import com.avontell.simcrawl.domain.Section;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private LinearLayout eventListView;
    private List<Event> events = new ArrayList<>();
    private final String url = "http://simcrawl.herokuapp.com/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventListView = (LinearLayout) findViewById(R.id.event_list_view);

        refreshEvents();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.new_item) {
            createEventDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void refreshEvents() {
        new GetEvents().execute();
    }

    public void getRoute(String origin, String destination) {

        // ... = new GetPath().execute(origin, destination)

    }

    /**
     * Populates the eventListView with events from the backend
     */
    public void populateEventList() {

        eventListView.removeAllViews();

        LayoutInflater inflater = (LayoutInflater) getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        Log.e("EVENT SIZE", "" + events.size());

        for(int i = 0; i < events.size(); i++) {

            Log.e("EVENTS", "Logged event");

            Event event = events.get(i);

            View eventView = inflater.inflate(R.layout.new_event_layout, null);

            TextView titleView = (TextView) eventView.findViewById(R.id.event_title_view);
            TextView locationView = (TextView) eventView.findViewById(R.id.location_text_view);
            TextView hostView = (TextView) eventView.findViewById(R.id.host_text_view);
            TextView timeView = (TextView) eventView.findViewById(R.id.time_text_view);

            titleView.setText(event.getTitle());
            locationView.setText(event.getRoom().toString());
            hostView.setText(event.getHost());
            timeView.setText(event.getTimeStart() + " - " + event.getTimeEnd());

            //TODO: Image
            //TODO: Count
            //TODO: Official event

            final Integer index = new Integer(i);

            eventView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    openEventDetail(index);

                }
            });

            eventListView.addView(eventView);

        }

    }

    public void showPath(JSONArray array) {

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Found Best Path")
                .content(array.toString())
                .negativeText(R.string.title_cancel)
                .build();

        dialog.show();

    }

    public void openEventDetail(int index) {

        String origin = "574";
        String destination = "" + events.get(index).getRoom().getNumber();
        new GetPath().execute(origin, destination);

    }

    public void createEventDialog() {

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title(R.string.create_event_title)
                .customView(R.layout.create_event_dialog, true)
                .positiveText(R.string.title_submit)
                .negativeText(R.string.title_cancel)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .build();

        dialog.show();

        View dialogView = dialog.getCustomView();



    }


    class GetEvents extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            events = new ArrayList<>();

            Event event1 = new Event("Aaron's Pset Party", "Aaron Vontell", EventType.PSET, new Room(574, new Section("5C")), false, "8:00pm", "10:00pm", 3);
            events.add(event1);
            Event event2 = new Event("Smash Tournament", "Jesus Corona", EventType.SMASH, new Room(321, new Section("Party Room")), false, "6:00pm", "10:30pm", 8);
            events.add(event2);
            Event event3 = new Event("Breakfast Club", "Heads of House", EventType.CUSTOM, new Room(100, new Section("Dining")), true, "10:00am", "12:00pm", 15);
            events.add(event3);
            Event event4 = new Event("Bar Event (21+)", "Some Student", EventType.BAR, new Room(1077, new Section("10A")), true, "10:00pm", "1:00am", 4);
            events.add(event4);

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            populateEventList();
        }
    }

    class GetPath extends AsyncTask<String, Void, Void> {

        JSONArray array = new JSONArray();

        @Override
        protected Void doInBackground(String... locations) {

            String URL = url + "search?start=" + locations[0] + "&end=" + locations[1];

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(URL)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String result = response.body().string();
                Log.e("RESULT", result);
                array = new JSONArray(result);
            } catch (Exception exception) {
                Log.e("EXCEPTION", exception.toString());
                return null;
            }

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            showPath(array);
        }

    }

    class PostEvent extends AsyncTask<Event, Void, Void> {

        @Override
        protected Void doInBackground(Event... events) {

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    class IncremementEvent extends AsyncTask<Integer, Void, Void> {

        @Override
        protected Void doInBackground(Integer... events) {

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }

    }



}
