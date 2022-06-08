package com.company;

import java.util.ArrayList;
import java.util.HashMap;

class Page {
    private Head head = new Head();
    private Tag body = new Tag("body");
    private Tag nav =new Tag("nav");
    private HashMap<String, String> attributes = new HashMap<>();

    public String getAttribute(String key){
        return attributes.get(key);
    }
    public HashMap<String, String> getAttributes(){
        return attributes;
    }
    public void put(String key, String value){
        attributes.put(key, value);
    }
    public Tag getBody(){
        return body;
    }
    public Head getHead(){
        return head;
    }
    public Tag getNav() {return nav; }

    class Head {
        private ArrayList<Tag> elements = new ArrayList<>();
        private ArrayList<Style> styles = new ArrayList<>();

        public ArrayList<Style> getStyles(){
            return styles;
        }
        public Tag getElement(int i){
            return elements.get(i);
        }
        public ArrayList<Tag> getElements(){
            return elements;
        }
        public Tag add(String name){
            Tag temp = new Tag(name);
            elements.add(temp);
            return temp;
        }
        public Tag add(Tag inner){
            Tag temp = new Tag(inner);
            elements.add(temp);
            return temp;
        }
        public Style add(Style inner){
            Style temp = new Style(inner);
            styles.add(temp);
            return temp;
        }
    }
}

