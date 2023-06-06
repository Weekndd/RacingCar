import java.util.Scanner;

/**
 * 카 클래스
 */

public class Car {
    final int NAME_LENGTH_THRESHOLD = 6;
    String name;
    private int runCount =  0;     //몇 번 움직였는지 상황

    public Car() { } //기본생성자
    public Car(String name) {
            this.name = name;
    }
    public Car(String name,int runCount) {
        this.name = name;
        this.runCount = runCount;
    }//테스트용 생성자
    public static void run(int randomNumber, Car player) {
        final int MOVE_THRESHOLD = 4;
        if (randomNumber >= MOVE_THRESHOLD ) {
            player.runCount ++;
        }
    }

    public int getRunCount () {
        return runCount;
    }

    public String getName() {
        return name;
    }
}
