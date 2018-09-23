package com.a9.aarti.aarti.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.a9.aarti.aarti.Callbacks.ListItemListener;
import com.a9.aarti.aarti.Model.Aarti;
import com.a9.aarti.aarti.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class AartiListAdapter extends RecyclerView.Adapter<AartiListAdapter.AartiItemViewHolder> {


    public List<Aarti> aartiList;
    private Context context;
    private ListItemListener listItemListener;

    public AartiListAdapter(Context context, List<Aarti> aartiList)
    {
        this.context = context;
        this.aartiList = aartiList;
        listItemListener = (ListItemListener)context;
    }


    @NonNull
    @Override
    public AartiItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.aarti_item_layout,viewGroup,false);
        AartiItemViewHolder holder = new AartiItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AartiItemViewHolder aartiItemViewHolder, int i) {

        final int position = i;

        Aarti aarti = aartiList.get(i);
        aartiItemViewHolder.title.setText(aarti.getTitle());
        aartiItemViewHolder.description.setText(aarti.description);
        aartiItemViewHolder.image.setImageResource(aarti.getImage());
        aartiItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemListener.itemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aartiList.size();
    }

    public class AartiItemViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView description;
        public ImageView image;

        public AartiItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView)itemView.findViewById(R.id.image);

        }
    }

}
