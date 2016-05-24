package org.dalol.restapidemo.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import org.dalol.restapidemo.R;
import org.dalol.restapidemo.model.pojo.About;
import org.dalol.restapidemo.model.utilities.Constants;

import java.util.List;

/**
 * Created by Sanjeev on 23-05-2016.
 */
public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.Holder> {
    public static String TAG = AboutAdapter.class.getSimpleName();
    private List<About> mAboutList;

    public AboutAdapter(List<About> aboutList) {
        mAboutList = aboutList;
    }

    public void addAbout(About about) {
        mAboutList.add(about);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        About about = mAboutList.get(position);
        holder.mTitle.setText(about.mTitle);
        holder.mDescription.setText(about.mDescription);
        Picasso.with(holder.itemView.getContext()).load(about.mImagePath).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mAboutList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mDescription;
        public ImageView mImage;

        public Holder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.aboutTitle);
            mDescription = (TextView) itemView.findViewById(R.id.aboutDescription);
            mImage = (ImageView) itemView.findViewById(R.id.aboutImage);
        }
    }
}
