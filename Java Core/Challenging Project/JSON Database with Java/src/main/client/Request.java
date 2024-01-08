package org.example.client;

public class Request {

   String type;
   String key;
   String value;
    public Request(String type, String key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }
    public String getType() {
        return type;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

}
