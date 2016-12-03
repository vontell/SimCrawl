package com.avontell.simcrawl;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avontell.simcrawl.domain.Event;
import com.avontell.simcrawl.domain.EventType;
import com.avontell.simcrawl.domain.Room;
import com.avontell.simcrawl.domain.Section;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout eventListView;
    private List<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventListView = (LinearLayout) findViewById(R.id.event_list_view);

        refreshEvents();

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

    public void openEventDetail(int index) {



    }


    class GetEvents extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            events = new ArrayList<>();

            for(int i = 0; i < 20; i++) {
                Event event1 = new Event("Event 1", "Bob Smithy Smith", EventType.BAR, new Room(329, new Section("3C")), false, "8:00pm", "10:00pm", 10);
                events.add(event1);
            }

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            populateEventList();
        }
    }

    class GetPath extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... locations) {

            return null;

        }
    }

}
