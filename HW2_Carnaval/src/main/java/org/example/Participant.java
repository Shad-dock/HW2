package org.example;

public class Participant {
    private String name;

    private String style;

    public Participant(String name, String style) {
        this.name = name;
        this.style = style;
    }

    public void dance(){
        System.out.println( name + " танцует " +  style);
    }
}
