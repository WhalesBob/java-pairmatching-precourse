package pairmatching;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public void initializeCourseAndStudent() throws FileNotFoundException {
        FileReader backendFile = new FileReader("src/main/resources/backend-crew.md");
        FileReader frontendFile = new FileReader("src/main/resources/frontend-crew.md");
        try{
            Course.updateNewStudents(Course.BACKEND, uploadStudentList(backendFile));
            Course.updateNewStudents(Course.FRONTEND, uploadStudentList(frontendFile));
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void initializeLevelAndMissions(){
        Level.updateNewMissions(Level.LEVEL1,List.of("자동차경주","로또","숫자야구게임"));
        Level.updateNewMissions(Level.LEVEL2,List.of("장바구니","결제","지하철노선도"));
        Level.updateNewMissions(Level.LEVEL4,List.of("성능개선","배포"));
    }

    private List<String> uploadStudentList(FileReader file) throws IOException {
        BufferedReader br = new BufferedReader(file);
        List<String> studentList = new ArrayList<>();
        while(true){
            String studentName = br.readLine();
            if(studentName == null){
                break;
            }
            studentList.add(studentName);
        }
        return studentList;
    }
}
