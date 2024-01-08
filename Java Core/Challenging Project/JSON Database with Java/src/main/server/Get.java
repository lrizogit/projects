package org.example.server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Get implements Command {

    public String task(JsonElement index, JsonElement data, JsonObject map) {
        JsonElement jsonMapWrap = wrapGet(map, index);
        if (jsonMapWrap == null ) {
            String response = "ERROR";
            String reason = "No such key";
            String value = null;
            Response responseIns = new Response(response, reason, value);
            Gson gson = new Gson();
            return gson.toJson(responseIns);
        } else {
            Gson gson = new Gson();
            JsonObject responseJson = new JsonObject();
            String response = "OK";
            responseJson.addProperty("response", response);

            responseJson.add("value", jsonMapWrap);
            String ans = gson.toJson(responseJson);
            if (jsonMapWrap.isJsonPrimitive()) {
                return gson.toJson(responseJson);
            }else {
                return ans;
            }
        }
    }
    public JsonElement wrapGet (JsonObject map, JsonElement index){
        if (index.isJsonPrimitive()){
            return map.get(index.getAsString());
        }
        JsonArray indexes = index.getAsJsonArray();
        JsonObject wrapIndex = map;
        JsonElement wrapper = null;
        if (index.isJsonArray() && indexes.size()== 1){
            wrapper = map.get(indexes.get(0).getAsString());
            return wrapper;
        } else  {
            for (int i = 0 ;i < indexes.size(); i++){
                wrapper = wrapIndex.get(indexes.get(i).getAsString());
                if (wrapper == null){
                    return null;
                }
                if (i < indexes.size()-1) {
                    wrapIndex = (JsonObject) wrapper;
                }
            }
            return wrapper;
        }
    }
}