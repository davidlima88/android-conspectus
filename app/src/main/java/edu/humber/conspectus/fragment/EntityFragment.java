package edu.humber.conspectus.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import edu.humber.conspectus.R;
import edu.humber.conspectus.adapter.MyEntityRecyclerViewAdapter;
import edu.humber.conspectus.json.JSONAsyncTask;
import edu.humber.conspectus.json.JSONCallBack;
import edu.humber.conspectus.model.Bookmark;

public class EntityFragment extends Fragment {
    private OnClickEntityListener mListener;

    public EntityFragment() {
    }

    public static EntityFragment newInstance() {
        return new EntityFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_entity_list, container, false);

        final ProgressDialog pdLoading = new ProgressDialog(getContext());
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();

        new JSONAsyncTask(new JSONCallBack() {
            @Override
            public void success(JSONArray jsonArray) {
                pdLoading.dismiss();
                try {
                    RecyclerView recyclerView = (RecyclerView) view;
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(new MyEntityRecyclerViewAdapter(Bookmark.parseJSONArray(jsonArray), mListener));
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                } catch (JSONException e) {
                    Toast.makeText(view.getContext(), "Failed to Parse Data into View", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void failed() {
                Toast.makeText(view.getContext(), "Failed to Retrieve Data from Server", Toast.LENGTH_LONG).show();
            }
        }, "https://conspectus.azurewebsites.net/entity").execute();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnClickEntityListener) {
            mListener = (OnClickEntityListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnClickCategoryListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnClickEntityListener {
        void onClickEntityListener(Bookmark item);
    }
}
