package org.example;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartisipantFactory {
    private ArrayList<Participant> participantList;
    private int currentIdx = 0;

    public PartisipantFactory(){
        load();
    }

    private void load(){
        try{
            System.out.println("Загрузка началась..");
            Yaml yaml = new Yaml();

            InputStream is = getClass().getClassLoader().getResourceAsStream("part.yml");
            if (is == null){
                System.out.println("файл пустой");
                return;
            }

            Map<String, List<Map<String, String>>> data = yaml.load(is);
            List<Map<String, String>> participants = data.get("participants");
            participantList = new ArrayList<>();
            for(Map<String, String> p : participants){
                String name = p.get("name");
                String style = p.get("style");
                participantList.add(new Participant(name, style));
            }
            System.out.println("загружено: " + participantList.size());
        } catch (Exception e) {
            System.out.println("Ошибка загрузки файла");
            e.printStackTrace();
        }
    }

    public Participant createPartisipant(){
        if(currentIdx < participantList.size()){
            Participant participant = participantList.get(currentIdx);
            currentIdx++;
            return participant;
        }else {
            return new Participant("Конец", "списка");
        }

    }

    public int getPartCount(){
        return participantList.size();
    }
}
