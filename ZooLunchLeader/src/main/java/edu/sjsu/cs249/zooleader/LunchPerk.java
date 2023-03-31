package edu.sjsu.cs249.zooleader;

import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ashish
 */
@ToString
public class LunchPerk implements Serializable {

    HashMap<Long,Lunch> lunches;

    int currentSleep;

    LunchPerk(){
       lunches = new HashMap<>();
       currentSleep = 0;
    }

    Lunch getLastLunch(){
        Long latestLunchId = Long.MIN_VALUE;
        for(Long l : lunches.keySet()){
            if(latestLunchId < l)
                latestLunchId = l;
        }
        return lunches.getOrDefault(latestLunchId,null);
    }


}

@ToString
class Lunch implements Serializable{

    Long lunchId;

    List<String> lunchMates;

    String lunchLeader;

    boolean isLeader;

    Lunch(){
        lunchMates = new ArrayList<>();
    }
}