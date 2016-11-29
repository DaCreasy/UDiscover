package com.example.udiscover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.AdapterView;

/**
 * Prompts the user to choose a destination location.
 */

public class GetDirectionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, URSINUS_PLACES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.places_list);
        textView.setThreshold(1);   //when 1 letter is typed, options show up in the View

        textView.setAdapter(adapter);
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //When an item is clicked in the View, the listener runs this method
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                String destination = (String)parent.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), ToDestinationActivity.class);
                intent.putExtra("DESTINATION_CHOICE", destination);
                startActivity(intent);
            }
        });
    }

    //List of strings to display in the View list.
    private static final String[] URSINUS_PLACES = new String[] {
            "Berman Museum", "Bomberger Hall", "Bookstore",  "Campus Safety", "Corson Hall", "Floy Lewis Bakes Center",
            "Myrin Library", "Olin Hall", "Kaleidoscope", "Pfahler Hall", "Ritter Hall", "Thomas Hall", "Wismer Center"
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

