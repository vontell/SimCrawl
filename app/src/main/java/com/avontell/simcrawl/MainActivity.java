package com.avontell.simcrawl;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventListView = (ListView) findViewById(R.id.event_list);

    }

    public void refreshEvents() {
        new GetEvents().execute();
    }

    public void getRoute(String origin, String destination) {

        // ... = new GetPath().execute(origin, destination)

    }


    class GetEvents extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            return null;

        }
    }

    class GetPath extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... locations) {

            return null;

        }
    }

}
