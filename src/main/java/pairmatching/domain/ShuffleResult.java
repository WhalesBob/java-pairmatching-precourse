package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.repository.Course;

import java.util.ArrayList;
import java.util.List;

public class ShuffleResult {
    private Course course;
    private String missionName;
    private List<StudentPair> shuffleList;

    public ShuffleResult(Course course, String missionName) {
        this.course = course;
        this.missionName = missionName;
        this.shuffleList = makeShuffleList();
    }

    public List<StudentPair> getShuffleList() {
        return shuffleList;
    }

    private List<StudentPair> makeShuffleList(){
        List<String> studentList = Course.getStudentList(course);
        List<String> shuffledCrew = Randoms.shuffle(studentList);

        List<StudentPair> studentPairs = new ArrayList<>();
        // 짝수이면, 짝수로 만들어서 내고, 홀수면, 홀수로 만들어서 낸다.
        int shuffledCrewSize = shuffledCrew.size();
        for(int i = 0; i < shuffledCrewSize-1; i+=2){
            StudentPair studentPair;
            if(i == shuffledCrewSize - 3){
                studentPair = new StudentPair(shuffledCrew.get(i),shuffledCrew.get(i+1),shuffledCrew.get(i+2));
                studentPairs.add(studentPair);
                break;
            }
            studentPair = new StudentPair(shuffledCrew.get(i),shuffledCrew.get(i+1));
            studentPairs.add(studentPair);
        }
        return studentPairs;
    }

    public static boolean haveDuplicatePairs(ShuffleResult result1, ShuffleResult result2){
        for(int i = 0; i < result2.shuffleList.size(); i++){
            if(result1.shuffleList.contains(result2.shuffleList.get(i))){
                return true;
            }
        }
        return false;
    }
}
