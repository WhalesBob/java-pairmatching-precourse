package pairmatching.views;

import pairmatching.domain.ShuffleResult;
import pairmatching.domain.StudentPair;
import pairmatching.repository.Course;
import pairmatching.repository.Level;

import java.util.List;

public class ProgramOutput {

    public void printInitialFeature(){
        System.out.println("기능을 선택하세요");
        System.out.print("1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료\n");
    }

    public void showCourseAndMission(){
        System.out.println("\n#############################################");
        System.out.printf("과정 : %s | %s\n", Course.getName(Course.BACKEND),Course.getName(Course.FRONTEND));
        System.out.println("미션:");
        showMissions();
        System.out.println("#############################################");
    }
    public void requestCourseAndMissionPrint(){
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
    }

    public void showMissions(){
        System.out.printf("  - 레벨1: %s\n",makeLevelMissionsList(Level.LEVEL1));
        System.out.printf("  - 레벨2: %s\n",makeLevelMissionsList(Level.LEVEL2));
        System.out.printf("  - 레벨3: %s\n",makeLevelMissionsList(Level.LEVEL3));
        System.out.printf("  - 레벨4: %s\n",makeLevelMissionsList(Level.LEVEL4));
        System.out.printf("  - 레벨5: %s\n",makeLevelMissionsList(Level.LEVEL5));
    }

    public void printDuplicateMatchingExists(){
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
    }

    public void printPairMatchingResult(List<StudentPair> result){
        System.out.println("\n페어 매칭 결과입니다.");
        for (StudentPair studentPair : result) {
            if (studentPair.studentC != null) {
                System.out.printf("%s : %s : %s\n", studentPair.studentA, studentPair.studentB, studentPair.studentC);
                break;
            }
            System.out.printf("%s : %s\n", studentPair.studentA, studentPair.studentB);
        }
        System.out.println();
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
