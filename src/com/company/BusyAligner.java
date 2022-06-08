package com.company;

class BusyAligner implements Aligner {
    private int depth;
    private boolean isBlock;

    public BusyAligner(int depth, boolean isBlock){
        this.depth = depth;
        this.isBlock = isBlock;
    }
    public Aligner clone(){
        try {
            return (Aligner)super.clone();
        } catch(CloneNotSupportedException cnse){
            return null;
        }
    }
    public BusyAligner inc(){
        depth = depth + 1;
        return this;
    }
    public int getDepth(){
        return depth;
    }
    public boolean getIsBlock(){
        return isBlock;
    }
    private String getPrefix(){
        String prefix = "";
        for(int j = depth; j > 0; --j){
            prefix += "    ";
        }
        return prefix;
    }
    public String alignTagSingle(String mid){
        isBlock = false;
        return alignTagBlock(mid);
    }
    public String alignTagBlock(String mid){
        String str = "\n";
        String prefix = getPrefix();
        str += prefix;
        int index = mid.lastIndexOf("</");
        if ((index > -1) && (isBlock))
            str += mid.substring(0, index) + prefix + mid.substring(index);
        else
            str += mid;
        str += "\n";
        return str.replace("\n\n", "\n");
    }
}
