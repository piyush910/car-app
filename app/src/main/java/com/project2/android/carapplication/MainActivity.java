package com.project2.android.carapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    protected static final String EXTRA_RES_ID = "POS";
    private ArrayList<Integer> mThumbIdsCars = new ArrayList<Integer>(
            Arrays.asList(R.drawable.im1, R.drawable.im2, R.drawable.im3, R.drawable.im4, R.drawable.im5,
                    R.drawable.im6, R.drawable.im7, R.drawable.im8, R.drawable.im9));
    private String[] texts = {"Audi Coupe", "Ferrari F12 TRS 2014", "Ford Mustang GT", "Ferrari F1 TDF Coupe", "Lamborghini Gallardo", "Lamborghini Hurrican", "Mercedes Benz SLC", "Rolls Royce Phantom", "Volkswagen Beetle"};

    /**
     * When main activity is created, this method will be executed.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this, mThumbIdsCars, texts)); // assign image adapter to grid view
        registerForContextMenu(gridView); // register context menu
        // onclick of a grid, open the image as big image in new activity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                intent.putExtra(EXTRA_RES_ID, (int) id);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });
    }

    /**
     * Inflate the context menu.
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.context_menu, menu);
    }

    /**
     * When context menu is selected, depending on item id, perform actions..
     *
     * @param item
     * @return boolean
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.pic:
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                intent.putExtra(EXTRA_RES_ID, (int) info.id);
                startActivity(intent);
                return true;

            case R.id.webpage:
                String url = getResources().getStringArray(R.array.urls)[info.position];
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;

            case R.id.dealers:
                Intent in = new Intent(MainActivity.this, CarDealersListView.class);
                in.putExtra("pos", (int) info.position);
                startActivity(in);
                return true;
            default:
                return false;
        }
    }
}
