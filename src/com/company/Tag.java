package com.company;

import java.util.ArrayList;
import java.util.HashMap;

    final class Tag {
        private String name;
        private String content;
        private ArrayList<com.company.Tag> elements = new ArrayList<>();
        private HashMap<String, String> attributes = new HashMap<>();
        private ArrayList<Style> styles = new ArrayList<>();

        public Tag(String name){
            this(name, "");
        }
        public Tag(String name, String content){
            this.name = name;
            this.content = content;
            styles.add(new Style(""));
        }
        public Tag(com.company.Tag other){
            this(other.name, other.content);
            this.elements = new ArrayList<>(other.elements);
            this.attributes = new HashMap<>(other.attributes);
            this.styles = new ArrayList<Style>(other.styles);
        }
        public String getName(){
            return name;
        }
        public String getContent(){
            return content;
        }
        public Style getStyle(){
            return styles.get(0);
        }

        public com.company.Tag getElement(int i){
            return elements.get(i);
        }
        public ArrayList<com.company.Tag> getElements(){
            return elements;
        }
        public String getAttribute(String key){
            return attributes.get(key);
        }
        public HashMap<String, String> getAttributes(){
            return attributes;
        }
        public com.company.Tag add(String name){
            com.company.Tag temp = new com.company.Tag(name);
            elements.add(temp);
            return temp;
        }
        public com.company.Tag add(com.company.Tag inner){
            com.company.Tag temp = new com.company.Tag(inner);
            elements.add(temp);
            return temp;
        }
        public void put(String key, String value){
            attributes.put(key, value);
        }

    }
