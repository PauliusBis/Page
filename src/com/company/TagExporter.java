package com.company;

class TagExporter {
    private String export(Page.Head head, int depth) throws UnusedContentException {
        String str = "    <head>";
        for(Tag tag : head.getElements()){
            str += export(tag, 2);
        }
        if (head.getStyles().size() > 0){
            str += "        <style>\n";
            str += new StyleFormatter().prepareStyleBlock(head.getStyles());
            str += "        </style>\n";
        }
        return str + "    </head>";
    }
    public String export(Page page) throws UnusedContentException {
        String str = "<!DOCTYPE html>\n";
        str += "<html>\n";
        str += export(page.getHead(), 1);
        str += export(page.getBody(), 1);
        str += "</html>\n";
        return str;
    }
    public String export(Tag tag) throws UnusedContentException {
        return export(tag, new LazyAligner());
    }
    public String export(Tag tag, int depth) throws UnusedContentException {
        return export(tag, new BusyAligner(depth, true));
    }
    private String export(Tag tag, Aligner a) throws UnusedContentException {
        if (tag.getElements().size() == 0){
            return a.alignTagSingle(new TagFormatter().prepareTagSingle(tag));
        } else if (tag.getContent() == ""){
            String mid = "";
            for(int i = 0; i < tag.getElements().size(); ++i){
                mid += export(tag.getElement(i), a.clone().inc());
            }
            return a.alignTagBlock(new TagFormatter().prepareTagBlock(tag, mid));
        } else {
            throw new UnusedContentException("Unused content!");
        }
    }
}

