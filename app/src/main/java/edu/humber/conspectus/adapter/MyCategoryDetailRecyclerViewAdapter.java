package edu.humber.conspectus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.humber.conspectus.R;
import edu.humber.conspectus.fragment.CategoryFragment;
import edu.humber.conspectus.fragment.CategoryFragment.OnClickCategoryListener;
import edu.humber.conspectus.model.Category;
import edu.humber.conspectus.model.Bookmark;
public class MyCategoryDetailRecyclerViewAdapter extends RecyclerView.Adapter<MyCategoryDetailRecyclerViewAdapter.ViewHolder> {

    private final List<Category> mValues;
    private final CategoryFragment.OnClickCategoryListener mListener;

    public MyCategoryDetailRecyclerViewAdapter(List<Category> items, CategoryFragment.OnClickCategoryListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText("Score: "+mValues.get(position).getScore().toString());
        holder.mContentView.setText("Label: "+mValues.get(position).getLabel().toString());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private final TextView mContentView;
        private Category mItem;

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
