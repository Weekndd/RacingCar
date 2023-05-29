import java.util.ArrayList;

/**
 * 게임종류 후 우승자를 찾는 클래스
 */
public class Finish {
    public static void winner(ArrayList<Car> player) {
        //runCount가 가장 높은 값 찾기
        int winnerRunCount = 0;
        for(int i=0; i<player.size(); i++) {
            if(winnerRunCount < player.get(i).getRunCount()) {
                winnerRunCount = player.get(i).getRunCount();
            }
        }

        //runCount 가장 높은 값 출력
        String winnerName = ""; //우승자 출력할 문자열
        for(int i=0; i<player.size(); i++) {
            if(player.get(i).getRunCount() == winnerRunCount) {
                winnerName = winnerName.concat(player.get(i).name+",");
            }
        }

        //마지막에 붙은 쉼표값 제거
        if(winnerName.endsWith(",")){
            winnerName = winnerName.substring(0,winnerName.length()-1);
        };
        System.out.println("최종 우승자: "+winnerName);
    }
}
