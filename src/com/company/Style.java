package com.company;

import java.util.HashMap;

final class Style {
    private String target;
    private HashMap<String, String> properties = new HashMap<>();

    public Style(String target){
        this.target = target;
    }
    public Style(Style other){
        this(other.target);
        this.properties = new HashMap<>(other.properties);
    }
    public String getTarget(){
        return target;
    }
    public String getProperty(String key){
        return properties.get(key);
    }
    public HashMap<String, String> getProperties(){
        return properties;
    }

    public void put(String key, String value){
        properties.put(key, value);
    }
}

