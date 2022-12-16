package pairmatching;

import pairmatching.domain.ShuffleResult;
import pairmatching.repository.Course;
import pairmatching.repository.Level;
import pairmatching.views.ProgramOutput;
import pairmatching.views.UserInput;

import java.util.List;

public class MatchingProgram {

    private static final ProgramOutput programOutput = new ProgramOutput();
    private static final UserInput userInput = new UserInput();

    public void startMatching(){
        while(true){
            programOutput.printInitialFeature();
            String getInitialPick = userInput.requestPickFeatures();
            if(getInitialPick.equals("Q")){
                return;
            }
            List<Runnable> methodList = List.of(this::makeStudentPair, this::showStudentPair, this::deleteAllStudentPair);
            methodList.get(Integer.parseInt(getInitialPick)- 1).run();
        }
    }
    public void makeStudentPair(){
        boolean doAgain = false;
        programOutput.showCourseAndMission();
        Course course; Level level; ShuffleResult shuffleResult;
        do{
            programOutput.requestCourseAndMissionPrint();
            List<String> courseLevelMission = userInput.requestCourseLevelMission();
            course = Course.findCourseByName(courseLevelMission.get(0));
            level = Level.findLevelByName(courseLevelMission.get(1));
            shuffleResult = Level.addStudentPairResult(level,course,courseLevelMission.get(2));
            if(shuffleResult == null){
                programOutput.printDuplicateMatchingExists();
                doAgain = userInput.requestMatchAgain();
            }
        }while(doAgain);

        if(shuffleResult != null){
            programOutput.printPairMatchingResult(shuffleResult.getShuffleList());
        }
    }
    public void showStudentPair(){

    }
    public void deleteAllStudentPair(){
        Level.deleteAllShuffleResult();
    }

}
