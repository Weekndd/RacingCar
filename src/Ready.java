import java.util.ArrayList;
import java.util.Scanner;

/**
 * 게임시작 전 준비단계 클래스
 */
public class Ready {
    static Scanner input = new Scanner(System.in);
    public static String[] join() {

        String playerInput = input.next();
        String[] playerName = playerInput.split(",");
        return playerName;
    }

    public static ArrayList<Car> createPlayer(String[] playerName) {
        ArrayList<Car> player = new ArrayList<Car>();
        try{
            for (int i = 0; i < playerName.length; i++) {
                player.add(new Car(playerName[i])); //플레이어 리스트에 Car클래스 생성자로 만들어서 추가
            }
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR]5글자 이하의 이름을 입력하세요!");
            playerName = join();
            player = createPlayer(playerName);
        }
        return player;
    }

    //입력값이 0이하를 받지 않도록 한다.
    //게임횟수가 0이하면 예외를 발생시켜서 메시지를 뜨게하고 다시 입력받는다.
    public static int setGameCount() {
        int gameCount = input.nextInt();
        while (true) {
            try {
                if (gameCount <= 0) {
                    System.out.println("[ERROR]1회 이상을 입력하세요");
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                gameCount = input.nextInt();
            }
        }
        return gameCount;
    }
}
