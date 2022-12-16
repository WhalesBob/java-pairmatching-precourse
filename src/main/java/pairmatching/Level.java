package pairmatching;

import java.util.ArrayList;
import java.util.List;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private List<String> missions;

    Level(String name){
        this.name = name;
        this.missions = new ArrayList<>();
    }

    public static void updateNewMissions(Level level, List<String> missions){
        level.missions.addAll(missions);
    }
}
