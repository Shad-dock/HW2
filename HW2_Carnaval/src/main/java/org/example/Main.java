package org.example;
public class Main {
    public static void main(String[] args) {
        Carnaval carnaval = new Carnaval();
        PartisipantFactory factory = new PartisipantFactory();

        System.out.println("\nЗагружено участников из YAML: " + factory.getPartCount());

        for (int i = 0; i < factory.getPartCount(); i ++){
            carnaval.addParticipant(factory.createPartisipant());
        }
        carnaval.dance();
    }
}