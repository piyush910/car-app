package com.project2.android.carapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private static final int PADDING = 5;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private Context mContext;
    private List<Integer> mThumbIds;
    private String[] cNames;

    @Override
    public Object getItem(int position) {
        return null;
    }

    public ImageAdapter(Context c, List<Integer> ids, String[] carNames) {
        mContext = c;
        this.mThumbIds = ids;
        this.cNames = carNames;
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) { // if no instance of convertView
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null); // inflate grid_single which has textview and image view
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(cNames[position]);
            imageView.setImageResource(mThumbIds.get(position));
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}