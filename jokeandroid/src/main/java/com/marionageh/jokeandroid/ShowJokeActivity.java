package com.marionageh.jokeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.marionageh.jokeandroid.R;


public class ShowJokeActivity extends AppCompatActivity {

    //TODo I tried to use Butter Knife in this lib But it cann;t find the R.id....

    TextView txt_joke;
    public static final String JOKE_FROM_INTENT="JOke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);
        txt_joke=findViewById(R.id.txt_joke);
        String joke = getIntent().getStringExtra(JOKE_FROM_INTENT);
        txt_joke.setText(joke);
        // Will Make Arrow On ToolBar to back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Will Make Arrow On ToolBar to back
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        // Will Make Arrow On ToolBar to back
        finish();

    }
}
