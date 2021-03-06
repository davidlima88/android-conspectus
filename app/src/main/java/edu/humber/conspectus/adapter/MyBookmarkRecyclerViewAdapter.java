package edu.humber.conspectus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.humber.conspectus.R;
import edu.humber.conspectus.fragment.BookmarkFragment.OnListFragmentInteractionListener;
import edu.humber.conspectus.model.Bookmark;

public class MyBookmarkRecyclerViewAdapter extends RecyclerView.Adapter<MyBookmarkRecyclerViewAdapter.ViewHolder> {

    private final List<Bookmark> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyBookmarkRecyclerViewAdapter(List<Bookmark> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_bookmark, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getId().toString());
        holder.mContentView.setText("Bookmark Name: "+mValues.get(position).getTitle()+"\n\n Sentiment: "+mValues.get(position).getSentiment()+"\n\n Sadness: "+mValues.get(position).getSadness()+"\n\n Anger: "+mValues.get(position).getAnger()+"\n\n Disgust: "+mValues.get(position).getDisgust()+"\n\n Joy: "+mValues.get(position).getJoy()+"\n\n Fear: "+mValues.get(position).getFear());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private final TextView mContentView;
        private Bookmark mItem;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.id);
            mContentView = view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
