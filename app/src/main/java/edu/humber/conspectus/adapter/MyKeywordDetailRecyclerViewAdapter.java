package edu.humber.conspectus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.humber.conspectus.R;
import edu.humber.conspectus.fragment.KeywordFragment;
import edu.humber.conspectus.model.Bookmark;
import edu.humber.conspectus.model.Keyword;

public class MyKeywordDetailRecyclerViewAdapter extends RecyclerView.Adapter<MyKeywordDetailRecyclerViewAdapter.ViewHolder> {

    private final List<Keyword> mValues;
    private final KeywordFragment.OnClickKeywordListener mListener;

    public MyKeywordDetailRecyclerViewAdapter(List<Keyword> items, KeywordFragment.OnClickKeywordListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_keyword, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText("Text: "+mValues.get(position).getText().toString());
        holder.mContentView.setText("Relevance "+mValues.get(position).getRelevance().toString());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private final TextView mContentView;
        private Keyword mItem;

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
