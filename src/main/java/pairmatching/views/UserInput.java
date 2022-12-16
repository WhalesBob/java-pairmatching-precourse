package pairmatching.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    private final Validator validator = new Validator();
    private boolean isRightInput;

    public String requestPickFeatures(){
        String userInput;
        do{
            userInput = Console.readLine();
            isRightInput = validator.validateUserInitialPick(userInput);
        }while(!isRightInput);
        return userInput;
    }

    public List<String> requestCourseLevelMission(){
        String[] userInput;
        do{
             userInput = Console.readLine().split(", ");
             isRightInput = validator.validateCourseLevelMission(userInput);
        }while(!isRightInput);
        return Arrays.asList(userInput);
    }

    public boolean requestMatchAgain(){
        String userInput;
        do{
            userInput = Console.readLine();
            isRightInput = validator.validateMatchAgain(userInput);
        }while(!isRightInput);

        return userInput.equals("네");
    }
}
