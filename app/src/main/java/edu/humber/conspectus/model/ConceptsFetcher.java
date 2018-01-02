package edu.humber.conspectus.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConceptsFetcher {
    private static List<Concept> items;
    private static final String json = "[\n" +
            "{\"name\":\"Indian Mackerel\",\"id\":\"1\"},\n" +
            "{\"name\":\"Manthal Repti\",\"id\":\"2\"},\n" +
            "{\"name\":\"Baby Sole Fish\",\"id\":\"3\"},\n" +
            "{\"name\":\"Silver Pomfret\",\"id\":\"4\"},\n" +
            "{\"name\":\"Squid\",\"id\":\"5\"},\n" +
            "{\"name\":\"Clam Meat\",\"id\":\"6\"},\n" +
            "{\"name\":\"Indian Prawns\",\"id\":\"7\"},\n" +
            "{\"name\":\"Mud Crab\",\"id\":\"8\"},\n" +
            "{\"name\":\"Grey Mullet\",\"id\":\"9\"},\n" +
            "{\"name\":\"Baasa\",\"id\":\"10\"},\n" +
            "{\"name\":\"Pearl Spot\",\"id\":\"11\"},\n" +
            "{\"name\":\"Anchovy\",\"id\":\"12\"},\n" +
            "{\"name\":\"Sole Fish\",\"id\":\"13\"},\n" +
            "{\"name\":\"Silver Croaker\",\"id\":\"14\"}\n" +
            "]";

    public static List<Concept> getConcepts() {
        items = new ArrayList<Concept>();
        try {
            JSONArray jArray = new JSONArray(json);

            // Extract data from json and store into ArrayList as class objects
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Concept concept = new Concept();
                concept.setName(json_data.getString("name"));
                concept.setId(json_data.getInt("id"));
                items.add(concept);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }
}
