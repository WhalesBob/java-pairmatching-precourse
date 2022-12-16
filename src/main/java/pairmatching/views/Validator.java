package pairmatching.views;

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
    private void validateInputIncludesInList(String userInput, List<String> validateList){
        if(!validateList.contains(userInput)){
            String errorMessage = "[ERROR] 1,2,3,Q 이외의 다른 입력은 진행할 수 없습니다.";
            errorProcess(errorMessage);
        }
    }

    private void errorProcess(String errorMessage){
        ProgramOutput.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
