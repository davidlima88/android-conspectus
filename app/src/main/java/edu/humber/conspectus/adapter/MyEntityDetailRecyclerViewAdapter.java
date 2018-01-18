package edu.humber.conspectus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.humber.conspectus.R;
import edu.humber.conspectus.fragment.EntityFragment;
import edu.humber.conspectus.fragment.EntityFragment.OnClickEntityListener;
import edu.humber.conspectus.model.Entity;

public class MyEntityDetailRecyclerViewAdapter extends RecyclerView.Adapter<MyEntityDetailRecyclerViewAdapter.ViewHolder> {

    private final List<Entity> mValues;
    private final OnClickEntityListener mListener;

    public MyEntityDetailRecyclerViewAdapter(List<Entity> items, EntityFragment.OnClickEntityListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_entity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText("Type: "+mValues.get(position).getType()+"\n");
        holder.mContentView.setText("Text: "+mValues.get(position).getText()+"\n\n\n\n"+"Relevance: "+mValues.get(position).getRelevance());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private final TextView mContentView;
        private Entity mItem;

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
