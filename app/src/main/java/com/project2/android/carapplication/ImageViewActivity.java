package com.project2.android.carapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));
        setContentView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getResources().getStringArray(R.array.urls)[intent.getIntExtra("pos", 0)];
                Intent i = new Intent(Intent.ACTION_VIEW); //open url of car manufacturer
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

}
