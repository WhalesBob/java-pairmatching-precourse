package pairmatching;

import java.io.File;
import java.io.FileNotFoundException;

public class Application {
    private static final Initializer initializer = new Initializer();
    private static final MatchingProgram matchingProgram = new MatchingProgram();

    public static void main(String[] args){
        try{
            initializeProgram();
            matchingProgram.startMatching();
        }catch(FileNotFoundException ignored){}
    }
    private static void initializeProgram() throws FileNotFoundException{
        initializer.initializeCourseAndStudent();
        initializer.initializeLevelAndMissions();
    }
}
