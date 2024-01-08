package org.example.client;

public class Request {

   private String type;
   private String key;
   private String value;
    public Request(final String type,
                   final String key, final String value) {
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
