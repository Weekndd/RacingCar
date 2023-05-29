import java.util.ArrayList;
/**
 * 게임진행 클래스
 */
public class Start {
    public static void play(ArrayList<Car> player, int gameCount) {
        RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();
        for (int i=0; i<gameCount; i++){            // gameCount만큼 게임진행
            for(int j=0; j< player.size(); j++){  // gameCount 안에서 플레이어들 run() 실행
                Car.run(randomNumberGenerater.generate(),player.get(j));
                System.out.println(player.get(j).name+" : "+player.get(j).getRunCount());
            }
            System.out.println();
        }
    }
}
