/**
 * 카 클래스의 카운트 값을 문자로 반환
 */
public class View {
    public static String viewRunCount(Car car){
        String runCount = "";
        for(int i=0; i< car.getRunCount();i++) {
            runCount = runCount.concat("-");
       }
        return runCount;
    }
}
