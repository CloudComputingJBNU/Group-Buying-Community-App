package com.example.cloudcomputingproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Chat> mDataset;
    String stMyEmail = "";

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        public MyViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View
            textView = v.findViewById(R.id.tvChat);
        }
    }

    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        if(mDataset.get(position).email.equals(stMyEmail)){
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param myDataset String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public MyAdapter(ArrayList<Chat> myDataset, String stEmail) {
        mDataset = myDataset;
        this.stMyEmail = stEmail;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        if(viewType == 1){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.right_text_view, parent, false);
        }
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.textView.setText(mDataset.get(position).getText());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
