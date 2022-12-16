package pairmatching.views;

import pairmatching.repository.Course;
import pairmatching.repository.Level;

import java.util.List;

public class Validator {
    public boolean validateUserInitialPick(String userInput){
        List<String> validInput = List.of("1","2","3","Q");
        boolean isAllRight = true;
        try{
            validateInputIncludesInList(userInput,validInput);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }

        return isAllRight;
    }

    public boolean validateCourseLevelMission(String[] userInput){
        boolean isAllRight = true;
        try{
            validateCourseIsRight(userInput[0]);
            validateLevelIsRight(userInput[1]);
            validateMissionNameIsRight(userInput[1],userInput[2]);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }

        return isAllRight;
    }

    public boolean validateMatchAgain(String userInput){
        boolean isAllRight = true;
        try{
            if(!(userInput.equals("네") || userInput.equals("아니오"))){
                String errorMessage = "[ERROR] 네, 아니오 이외의 입력은 할 수 없습니다.";
                errorProcess(errorMessage);
            }
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }
        return isAllRight;
    }

    private void validateInputIncludesInList(String userInput, List<String> validateList){
        if(!validateList.contains(userInput)){
            String errorMessage = "[ERROR] 1,2,3,Q 이외의 다른 입력은 진행할 수 없습니다.";
            errorProcess(errorMessage);
        }
    }

    private void validateCourseIsRight(String userInput){
        boolean isBackEnd = Course.getName(Course.BACKEND).equals(userInput);
        boolean isFrontEnd = Course.getName(Course.FRONTEND).equals(userInput);
        if(!(isBackEnd || isFrontEnd)){
            String errorMessage = "[ERROR] 과정 이름을 정확하게 입력해 주십시오.";
            errorProcess(errorMessage);
        }
    }

    private void validateLevelIsRight(String userInput){
        if(!Level.isThisLevelValid(userInput)){
            String errorMessage = "[ERROR] 레벨 이름을 정확하게 입력해 주십시오.";
            errorProcess(errorMessage);
        }
    }

    private void validateMissionNameIsRight(String levelName,String userInput){
        Level level = Level.findLevelByName(levelName);
        if(!Level.isMissionValid(level,userInput)){
            String errorMessage = "[ERROR] 해당 레벨에 존재하지 않는 미션입니다.";
            errorProcess(errorMessage);
        }
    }

    private void errorProcess(String errorMessage){
        ProgramOutput.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }


}
