/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package quakereport;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.model.Post;
import com.example.android.quakereport.model.remote.APIService;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderCallbacks<Object> {

    private EarthquakeAdapter mAdapter;
    private TextView emptyStateText;
    private ProgressBar loadData;
    private APIService mAPIService;
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    //URL for Earthquake data
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private static final int EARTHQUAKE_LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        loadData = (ProgressBar) findViewById(R.id.spinner_progress);
        emptyStateText = (TextView) findViewById(R.id.textView);
        ListView earthquakeListview = (ListView) findViewById(R.id.list);

        loadData.setVisibility(ProgressBar.VISIBLE);
        post posts = new post();
        posts.execute();


        earthquakeListview.setEmptyView(emptyStateText);
        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());
        earthquakeListview.setAdapter(mAdapter);

        earthquakeListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Earthquake currentEarthquake = mAdapter.getItem(i);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(webIntent);

            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        } else {
            loadData.setVisibility(ProgressBar.INVISIBLE);
            emptyStateText.setText(R.string.no_connection);
        }
    }

    //@Override
   // public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        // EarthquakeLoader earthquakeLoader =  new EarthquakeLoader(this,USGS_REQUEST_URL);
        // return earthquakeLoader;


   // @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        Log.e(LOG_TAG, "onLoadFinished");
        loadData.setVisibility(ProgressBar.INVISIBLE);
        emptyStateText.setText(R.string.empty_text);
        mAdapter.clear();

        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }


    }

    //@Override
    ////public void onLoaderReset(Loader<List<Earthquake>> loader) {
       // Log.e(LOG_TAG, "onLoaderReser");
       // mAdapter.clear();
    //}

    @Override
    public Loader<Object> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Object> loader, Object o) {

    }

    @Override
    public void onLoaderReset(Loader<Object> loader) {

    }

    public class post extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            //Realm.init(TypeActivity);
            //Realm realm = Realm.getDefaultInstance(); //creating  database oject
            //RealmResults<Informations> results = realm.where(Informations.class).findAllAsync();
            //fetching the data
            //results.load();
            //Log.i("hi","" +String.valueOf(results));
            //String name2 = Informations.@Override
            ////    public void onProviderEnabled(String provider) {
            ////        Log.d("Latitude","enable");
            ////    }
            ////
            ////    @Override
            ////    public void onStatusChanged(String provider, int status, Bundle extras) {
            ////        Log.d("Latitude","status");
            ////    }toString();
            // Log.i("hi",""+name);
            String phone_numberw = "1234" +
                    "";
            //String wearer_fire_id= FirebaseInstanceId.getInstance().getToken();
            sendPost(phone_numberw);

            return phone_numberw;
        }

        public void sendPost(String name) {
            //Log.i("hi",user_id);
            mAPIService.savePost(name).enqueue(new Callback<Post>() {
            });


        }
    }}

