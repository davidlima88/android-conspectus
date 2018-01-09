package edu.humber.conspectus.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import edu.humber.conspectus.R;
import edu.humber.conspectus.json.JSONCallBack;
import edu.humber.conspectus.json.JSONPost;

public class WebBrowserFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public WebBrowserFragment() {
        // Required empty public constructor
    }

    public static WebBrowserFragment newInstance() {
        WebBrowserFragment fragment = new WebBrowserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_browser, container, false);

        final WebView webView = view.findViewById(R.id.webview);
        final TextView typeUrl = view.findViewById(R.id.urlField);
        final Button search = view.findViewById(R.id.searchBtn);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.loadUrl("http://www.google.com/");
        webView.setWebViewClient(new MyBrowser());
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = typeUrl.getText().toString();
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl(url);
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });

        FloatingActionButton save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = LayoutInflater.from(view.getContext());
                final View mView = layoutInflater.inflate(R.layout.dialog_new_bookmark, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
                alertDialogBuilder.setView(mView);



                final String webURL=webView.getUrl();

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Analyze", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                final EditText userInputDialogEditText = mView.findViewById(R.id.userInputDialog);
                                final String title=userInputDialogEditText.getText().toString();
                                final String jsonString="{'title':"+title+"'url':"+webURL+"}";
                                new JSONPost(new JSONCallBack() {
                                    @Override
                                    public void success(JSONArray jsonArray) {

                                        try {
                                            Toast.makeText(mView.getContext(), "Save Successful", Toast.LENGTH_LONG).show();
                                        } catch (Exception e) {
                                            Toast.makeText(mView.getContext(), "Failed to Parse Data into View", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void failed() {
                                        Toast.makeText(mView.getContext(), "Failed to Retrieve Data from Server", Toast.LENGTH_LONG).show();
                                    }
                                }, "https://conspectus.azurewebsites.net/bookmark","{\"url\":\""+webURL+"\",\"title\":\""+title+"\"}").execute();
                            }
                        })


                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilder.create();
                alertDialogAndroid.show();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
