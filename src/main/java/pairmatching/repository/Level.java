package pairmatching.repository;

import pairmatching.domain.ShuffleResult;

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
    private List<ShuffleResult> shuffleResults;

    Level(String name){
        this.name = name;
        this.missions = new ArrayList<>();
        this.shuffleResults = new ArrayList<>();
    }

    public static void updateNewMissions(Level level, List<String> missions){
        level.missions.addAll(missions);
    }

    public static List<String> getMissions(Level level){
        return level.missions;
    }

    public static boolean isThisLevelValid(String inputLevel){
        for(Level level : Level.values()){
            if(level.name.equals(inputLevel)){
                return true;
            }
        }
        return false;
    }

    public static boolean isMissionValid(Level level,String inputMission){
        return level.missions.contains(inputMission);
    }

    public static Level findLevelByName(String levelName){
        for(Level level : Level.values()){
            if(level.name.equals(levelName)){
                return level;
            }
        }
        return null;
    }

    public static ShuffleResult addStudentPairResult(Level level,Course course, String missionName){
        ShuffleResult shuffleResult = new ShuffleResult(course,missionName);
        if(level.shuffleResults.size() == 0 || canAddShuffleResult(level, shuffleResult)){
            level.shuffleResults.add(shuffleResult);
            return shuffleResult;
        }
        return null;
    }
    private static boolean canAddShuffleResult(Level level, ShuffleResult result){
        for(int i = 0; i < level.shuffleResults.size(); i++){
            if(ShuffleResult.haveDuplicatePairs(level.shuffleResults.get(i),result)){
                return false;
            }
        }
        return true;
    }

    public static void deleteAllShuffleResult(){
        for(Level level : Level.values()){
            level.shuffleResults.clear();
        }
    }
}
