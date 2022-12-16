package pairmatching.views;

import pairmatching.Course;
import pairmatching.Level;

import java.util.List;

public class ProgramOutput {

    public void printInitialFeature(){
        System.out.println("기능을 선택하세요");
        System.out.print("1. 페어 매칭\n2. 페어 조회\n3.페어 초기화\nQ. 종료\n");
    }

    public void showCourseAndMission(){
        System.out.println("#############################################");
        System.out.printf("과정 : %s | %s", Course.getName(Course.BACKEND),Course.getName(Course.FRONTEND));
        System.out.println("미션:");
        showMissions();
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
    }

    public void showMissions(){
        System.out.printf("  - 레벨1: %s\n",makeLevelMissionsList(Level.LEVEL1));
        System.out.printf("  - 레벨2: %s\n",makeLevelMissionsList(Level.LEVEL2));
        System.out.printf("  - 레벨3: %s\n",makeLevelMissionsList(Level.LEVEL3));
        System.out.printf("  - 레벨4: %s\n",makeLevelMissionsList(Level.LEVEL4));
        System.out.printf("  - 레벨5: %s\n",makeLevelMissionsList(Level.LEVEL5));
    }

    private String makeLevelMissionsList(Level level){
        List<String> missions = Level.getMissions(level);
        StringBuilder missionListOutput = new StringBuilder();
        int missionSize = missions.size();
        for(int i = 0; i < missionSize; i++){
            missionListOutput.append(missions.get(i));
            if(i < missionSize - 1){
                missionListOutput.append(" | ");
            }
        }
        return missionListOutput.toString();
    }
    
    public static void printStatement(String message){
        System.out.println(message);
    }
}
