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
