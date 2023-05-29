
import java.sql.Array;
import java.util.*;

interface RandomUtil {
    public int generate();
}


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String[] playerName = Ready.join();


        ArrayList<Car> player = Ready.createPlayer(playerName);

        System.out.println("시도할 횟수는 몇회인가요?");
        int gameCount = Ready.setGameCount();

        Start.play(player,gameCount);
        Finish.winner(player);
    }
}