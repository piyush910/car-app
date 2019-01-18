package com.project2.android.carapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CarDealersListView extends Activity {
    String[][] values = new String[][]{{"Fletcher Jones Audi, 1523 W North Ave (312) 628-4300", "Great Chicago Motors 1523 W North Ave (312) 628-4300", "Audi N Elston Ave"},
            {"645 W Randolph St (312) 635-6482", "677 N Clark St · (312) 624-8586", "834 N Rush St · (312) 280-4848"},
            {"Fox Ford Lincoln, Chicago, IL · (773) 687-7800", "Metro Ford Sales Chicago, IL · (773) 776-7600", "West End Auto Chicago, IL · (773) 776-7600"},
            {"645 W Randolph St (312) 635-6482", "677 N Clark St · (312) 624-8586", "834 N Rush St · (312) 280-4848"},
            {"Lamborghini Gold Coast Showroom  834 N Rush St, Chicago, IL 60611", "Fox Valley Motorcars West Chicago, IL", "Lamborghini Chicago Westmont IL"},
            {"Lamborghini Gold Coast Showroom  834 N Rush St, Chicago, IL 60611", "Fox Valley Motorcars West Chicago, IL", "Lamborghini Chicago Westmont IL"},
            {"645 W Randolph St (312) 635-6482", "677 N Clark St · (312) 624-8586", "834 N Rush St · (312) 280-4848"},
            {"834 N Rush St, Chicago, IL 60611", "100 Skokie Blvd Northbrook","9 Arnage Drive, Chesterfield, St. Louis, 63005"},
            {"Volkswagen of Downtown Chicago IL (312) 614-0196", "5330 W Irving Park Rd Chicago", "148 N Cicero Ave, Chicago"}
    };
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_dealers_list_view);
        Intent in = getIntent();
        int pos = in.getIntExtra("pos", 0);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values[pos]);
        listView = (ListView) findViewById(R.id.list);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert of Dealer as Toast Message
                Toast.makeText(getApplicationContext(),
                        "Dealer Address: " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });
    }
}

