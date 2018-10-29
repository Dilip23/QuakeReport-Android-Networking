package quakereport;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;


public class Callback<T> implements retrofit2.Callback<retrofit2.http.POST> {
    private TextView mResponseTv;
   // private APIService mAPIService;

    @Override
    public void onResponse(Call<POST> Call, Response<POST> response) {
        if(response.isSuccessful()) {
               showResponse(response.body().toString());
            Log.i("error", "post submitted to API." + response.body().toString());
            }
    }

    @Override
    public void onFailure(Call<POST> call, Throwable t) {

             Log.e("MAINACTIVITY", "Unable to submit post to API.");
            }




    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }}
