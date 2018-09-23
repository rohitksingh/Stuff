package com.a9.aarti.aarti.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a9.aarti.aarti.Model.Aarti;
import com.a9.aarti.aarti.R;
import com.a9.aarti.aarti.StaticData.AartiData;

import java.security.PublicKey;

public class AartiDetailActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private int index;

    private ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aarti_detail_activity_layout);
        image = (ImageView) findViewById(R.id.image);

        title = (TextView)findViewById(R.id.title);
        description = (TextView)findViewById(R.id.description);

        index = getIntent().getIntExtra("INDEX",0);

        loadAarti(index);

    }

    private void loadAarti(int index)
    {
        Aarti aarti = AartiData.getList().get(index);
        title.setText(aarti.title);
        description.setText(aarti.description);
        getSupportActionBar().setTitle(aarti.title);
        image.setBackgroundResource(aarti.getImage());

    }


}
