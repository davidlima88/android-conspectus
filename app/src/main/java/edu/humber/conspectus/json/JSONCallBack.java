package edu.humber.conspectus.json;

import org.json.JSONArray;

public interface JSONCallBack {
    void success(JSONArray jsonArray);

    void failed();
}
