package pairmatching.views;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private final Validator validator = new Validator();
    private boolean isRightInput;

    public char requestPickFeatures(){
        String userInput;
        do{
            userInput = Console.readLine();
            isRightInput = validator.validateUserInitialPick(userInput);
        }while(!isRightInput);
        return userInput.toCharArray()[0];
    }
}
