package com.company;
import java.util.*;
import java.io.*;

class UnusedContentException extends Exception {
    public UnusedContentException(String message){
        super(message);
    }
}

class TagFormatter {
    public String prepareTagSingle(Tag tag){
        if (tag.getContent() != ""){
            return prepareTagBlock(tag, tag.getContent());
        } else {
            return "<" + tag.getName() + prepareAttributes(tag) + " />";
        }
    }
    public String prepareTagBlock(Tag tag, String mid){
        if (tag.getName().length() > 0){
            String str = "";
            str += ("<" + tag.getName() + prepareAttributes(tag) + ">");
            str += mid;
            str += ("</" + tag.getName() + ">");
            return str;
        } else {
            return mid;
        }
    }

    private String prepareAttributes(Tag tag){
        String str = "";
        HashMap<String, String> hm = tag.getAttributes();
        for(String key : hm.keySet()){
            str += " " + key + "=\"" + hm.get(key) + "\"";
        }
        str += new StyleFormatter().prepareStyleSingle(tag.getStyle());
        return str;
    }
}

class StyleFormatter {
    public String prepareStyleSingle(Style style){
        HashMap<String, String> hm = style.getProperties();
        if(hm.size() > 0){
            String str = " style=\"";
            for(String key : hm.keySet()){
                str += key + ": " + hm.get(key) + "; ";
            }
            return str.substring(0, str.length()-2) + "\"";
        } else {
            return "";
        }
    }

    public String prepareStyleBlock(ArrayList<Style> styles){
        String str = "";
        for(int i = 0; i < styles.size(); ++i){
            HashMap<String, String> hm = styles.get(i).getProperties();
            if(hm.size() > 0){
                str += "            " + styles.get(i).getTarget() + " {\n";
                for(String key : hm.keySet()){
                    str += "                " + key + ": " + hm.get(key) + ";\n";
                }
                str += "            " + "}\n";
            }
        }
        return str;
    }
}

interface Aligner extends Cloneable {
    abstract public String alignTagSingle(String mid);
    abstract public String alignTagBlock(String mid);
    abstract public Aligner inc();
    public Aligner clone();
}

public class Main {
    public static void main(String[] args) {

        try {
            TagExporter te = new TagExporter();


            Page page = new Page();
            page.put("lang", "en");

            Page.Head myHead = page.getHead();
            myHead.add(new Tag(""));

            Style s1 = new Style(".logo");
            s1.put("display", "inline-block");
            s1.put("flex", "1");
            myHead.add(s1);

            Style s2 = new Style("footer");
            s2.put("text-align", "center");
            s2.put("color", "#00DDEB");
            myHead.add(s2);

            Style s3 = new Style("body");
            s3.put("width", "100%");
            s3.put("height", "100%");
            s3.put(" background-image", " url(\"Images/earth.webp\")");
            s3.put("background-position", "center");
            s3.put(" background-size", "cover");
            s3.put("height", "50em");
            myHead.add(s3);

            Style s4 = new Style(".button-64");
            s4.put("align-intems", "center");
            s4.put("background-image",  "linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB)");
            s4.put("border", "0");
            s4.put("border-radius", "8px");
            s4.put("box-shadow", " #9741fc33 0 15px 30px -5px");
            s4.put(" box-sizing", "border-box");
            s4.put("color", "#FFFFFF");
            s4.put("display", "inline-block");
            s4.put("font-family", "Phantomsans, sans-serif");
            s4.put("font-size", "20px");
            s4.put("justify-content", "initial");
            s4.put("line-height", "2.5em");
            s4.put("max-width", "100%");
            s4.put("min-width", " 14px");
            s4.put("padding", "3px");
            s4.put("text-decoration", "none");
            s4.put("user-select", "none");
            s4.put("-webkit-user-select", "none");
            s4.put("touch-action", "manipulation");
            s4.put(" white-space", "nowrap");
            s4.put("cursor", "pointer");
            myHead.add(s4);

            Style s5 = new Style(".button-64:active,.button-64:hover");
            s5.put(" outline", "0");
            myHead.add(s5);

            Style s6 = new Style(".button-64 span");
            s6.put("background-color", " rgb(5, 6, 45)");
            s6.put("padding", "16px 24px");
            s6.put("border-radius", "6px");
            s6.put("width", "100%");
            s6.put("height", "100%");
            s6.put("transition", "300ms");
            myHead.add(s6);

            Style s7 = new Style(".button-64:hover span");
            s7.put("background", "none");
            myHead.add(s7);

            Style s8 = new Style("@media (min-width: 768px)");
            Style s9 = new Style(".button-64");
            s9.put("font-size", "24px");
            s9.put("min-width", "50px");
            s8.put("", "");
            myHead.add(s8);
            myHead.add(s9);

            Style s10 = new Style(".heading");
            s10.put("color", " #00DDEB");
            s10.put("padding-left", " 3em");
            myHead.add(s10);

            Style s11 = new Style(".text");
            s11.put("color", "white");
            s11.put("padding-left", " 2em");
            myHead.add(s11);


            Tag myBody = page.getBody();
            Tag myDiv = myBody.add(new Tag("div", "<a href=\"index.html\"><img src=\"Images/Lt.png\" alt=\"Panorama\" width=\"140\" height=\"120\"></a>"));
            myDiv.put("class", "logo");

            Tag myDiv1 = myBody.add(new Tag("div","<h2 class='heading'>My first page</h2"));
            myDiv1.put("class","logo");

            Tag myDiv2 = myBody.add(new Tag("div","<h2 class='heading'>Meniu</h2"));
            myDiv2.put("class","logo");

            Tag myDiv3 = myBody.add(new Tag("a href=\"..\" class=\"button-64\" role=\"button\"","<span class=\"text\" >Group page"));
            Tag myDiv4 = myBody.add(new Tag("a href='index.html' class=\"button-64\" role=\"button\"","<span class=\"text\" >Home"));
            Tag myDiv5 = myBody.add(new Tag("a href='links.html' class=\"button-64\" role=\"button\"","<span class=\"text\" >Links"));
            Tag myDiv6 = myBody.add(new Tag("a href='project.html' class=\"button-64\" role=\"button\"","<span class=\"text\" >Project"));
            Tag myDiv7 = myBody.add(new Tag("a href='about.html' class=\"button-64\" role=\"button\"","<span class=\"text\" >About"));
            Tag myDiv8 = myBody.add(new Tag("a href='Kontakt.html' class=\"button-64\" role=\"button\"","<span class=\"text\" >Kontakt"));

            Tag myDiv9 = myBody.add(new Tag("h2","Programavimo apibrėžimas"));
            myDiv9.put("class","heading");

            Tag myDiv10 = myBody.add(new Tag("p","Programavimas yra programavimo veiksmas ir poveikis . Šis veiksmažodis turi keletą naudojimo būdų: jis nurodo suprojektuoti ir nurodyti veiksmus, kurie turi būti vykdomi įgyvendinant projektą; iki pranešimo apie dalis, kurios sudaro veiksmą ar pasirodymą; mašinų paruošimui, kad jie tam tikru momentu atliktų tam tikrą užduotį; programų, skirtų problemoms spręsti naudojant kompiuterius, kūrimui; ir reikalingų duomenų paruošimas, kad būtų galima išspręsti problemą."));
            myDiv10.put("class","text");

            Tag myDiv11 = myBody.add(new Tag("h2","Programavimo kalbos"));
            myDiv11.put("class","heading");

            Tag myDiv12 = myBody.add(new Tag("p","Kiekviena programa rašoma viena ar kita programavimo kalba, kuri vėliau verčiama mašininiu kodu, suprantamu kompiuteriui. Nors įmanoma tiesiogiai programuoti mašininiu kodu, aukšto lygio programavimo kalbos žymiai supaprastina kūrimo procesą. Programavimo kalbų yra daug skirtingų tipų bei skirtingų sudėtingumo lygių, todėl kiekviena kalba labiau tinka tam tikros paskirties uždaviniams spręsti."));
            myDiv12.put("class","text");

            Tag myDiv13 = myBody.add(new Tag("h2","Programų kūrimas"));
            myDiv13.put("class","heading");

            Tag myDiv14 = myBody.add(new Tag("p","Programų kūrimas – sudėtingas procesas ir programavimas tėra nedidelė šio proceso dalis. Pagrindinės ir dažniausiai pasitaikančios kūrimo dalys: Reikalavimų surinkimas bei analizė Projektavimas ir įrankių (programavimo kalbos, platformos, duomenų lapu ir pan.), tinkamiausių problemai spręsti, parinkimas. Programos rašymas pasirinkta programavimo kalba.\n" +
                    "        Testavimas. Jei testavimo metu paaiškėja, kad nepasiektas norimas kokybės lygis, taisomos problemos (grįžti į 1 žingsnį)\n" +
                    "        Dokumentavimas, jei reikia – vertimas į kitas kalbas\n" +
                    "        Palaikymas\n" +
                    "        Diegimas"));
            myDiv14.put("class","text");


/*
            Tag myP = myBody.add(new Tag("p", "Lorem ipsum"));
            myP.put("id", "my-p");
            myP.getStyle().put("border", "1px solid black");
            myP.getStyle().put("background-color", "green");

            Tag myPar = myBody.add(new Tag("p", ""));
            myPar.add(new Tag("", "My paragraph"));

           Tag myLink = new Tag("a");
          //  myLink.put("id", "my-link");
           // myLink.put("style", "font-weight: bold; text-decoration: none");
           // Tag myImg = myLink.add(new Tag("img", ""));
            //myImg.put("id", "my-img");
           // myImg.put("class", "my-images");
           // Tag myLink1 = myLink.add(new Tag("", "My link"));
/*
            Tag myDiv1 = new Tag("div");
            myDiv1.add(new Tag("", "labas"));
            myBody.add(myDiv1);

            Tag myDiv2 = myDiv1.add(new Tag("div"));
            myDiv2.add(new Tag("", "Programuotojo pagalbininkas "));
            myBody.add(myDiv2);


            Tag myDiv3 = myDiv2.add(new Tag("div"));
            myDiv3.add(new Tag("", "MENIU "));
            myBody.add(myDiv3);

            Tag myDiv4 = myDiv3.add(new Tag("div"));
            myDiv4.add(new Tag("", "Namai "));
            myDiv4.put("class","navButon");
            myBody.add(myDiv4);

            Tag myDiv5 = myDiv4.add(new Tag("div"));
            myDiv5.add(new Tag("", "Vizualizacijos"));
            myDiv5.put("class","navButon");
            myBody.add(myDiv5);

            Tag myDiv6 = myDiv5.add(new Tag("div"));
            myDiv6.add(new Tag("", "Naudingos nuorodos"));
            myDiv6.put("class","navButon");
            myBody.add(myDiv6);
*/
            System.out.println(te.export(page));



            FileWriter fw = new FileWriter("index.htm");
            fw.write(te.export(page));
            fw.close();


        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Unexpected error, sorry!");
        }
    }
}
