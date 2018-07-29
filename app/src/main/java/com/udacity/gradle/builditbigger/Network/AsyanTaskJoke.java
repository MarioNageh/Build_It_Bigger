package com.udacity.gradle.builditbigger.Network;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.marionageh.jokeandroid.ShowJokeActivity;
import com.udacity.gradle.builditbigger.Constants.Constants;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;


public class AsyanTaskJoke extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi api = null;
    private Context Context;
    ProgressBar progressBar;


    public AsyanTaskJoke(android.content.Context context, ProgressBar progressBar) {
        Context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (api == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(Constants.EMULATOR_IP_ADDRESS) // 10.0.2.2 is localhost's IP address in Android emulator

                    //    .setRootUrl(AddressGetter.getIPAddress())
                    //TODO I want to make the app engine in cloud put whem i press
                    //TODO Build.Deloy Moudle to App engine
                    // tell me the project don;t contain any app engine

                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            api = builder.build();

        }
        try {
            Log.e("Mario", api.toString());
            return api.putJoke(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            Log.e("Mario", e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
   if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
        sendJoketoActivity(result);


    }

    private void sendJoketoActivity(String s) {
        Intent intent = new Intent(Context, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.JOKE_FROM_INTENT, s);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Context.startActivity(intent);
    }

}