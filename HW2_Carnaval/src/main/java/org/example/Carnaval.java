package org.example;

import java.util.ArrayList;

public class Carnaval {
    private ArrayList<Participant> participants;

    public Carnaval() {
        participants = new ArrayList();
    }

    public void dance(){
        System.out.println("Танцуют Все!");

        participants.stream().forEach(a -> a.dance());
    }

    public void addParticipant(Participant p){
        participants.add(p);
    }
}
