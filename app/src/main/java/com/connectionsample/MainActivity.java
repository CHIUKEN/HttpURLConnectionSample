package com.connectionsample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.connectionsample.models.ApiResponse;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private StationAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());

        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new StationAdapter();
        mRecyclerView.setAdapter(mAdapter);

        new LoadingDataAsyncTask().execute();


    }

    class LoadingDataAsyncTask extends AsyncTask<Void, Integer, ApiResponse> {


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ApiResponse doInBackground(Void... voids) {
            String s = HttpHelper.getStationList("resourceAquire", "55ec6d6e-dc5c-4268-a725-d04cc262172b");

            ApiResponse response = new Gson().fromJson(s, ApiResponse.class);
            return response;
        }

        @Override
        protected void onPostExecute(ApiResponse apiResponse) {
            super.onPostExecute(apiResponse);
            //show data
            mAdapter.setStations(apiResponse.getResult().getResults());
        }
    }

}
