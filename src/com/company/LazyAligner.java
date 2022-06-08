package com.company;

class LazyAligner implements Aligner {
    public LazyAligner(){
    }
    public Aligner clone(){
        try {
            return (Aligner)super.clone();
        } catch(CloneNotSupportedException cnse){
            return null;
        }
    }
    public LazyAligner inc(){
        return this;
    }
    public String alignTagSingle(String mid){
        return mid;
    }
    public String alignTagBlock(String mid){
        return mid;
    }
}
