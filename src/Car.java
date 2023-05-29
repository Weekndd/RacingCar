import java.util.Scanner;

/**
 * 카 클래스
 */

public class Car {
    final int NAME_LENGTH_THRESHOLD = 6;
    Scanner input = new Scanner(System.in);
    String name;
    private String runCount = "";     //몇 번 움직였는지 상황

    Car(String name) throws IllegalArgumentException {
        while(true){
            if(name.length()>=NAME_LENGTH_THRESHOLD) {
                throw new IllegalArgumentException();
            } else {
                this.name = name;
                break;
            }
        }
    }
    public static String run(int randomNumber, Car player) {
        final int MOVE_THRESHOLD = 4;
        if (randomNumber >= MOVE_THRESHOLD ) {
            player.runCount = player.runCount.concat("-");
        }
        return player.runCount;
    }

    public int getRunCount () {
        return runCount.length();
    }

}
