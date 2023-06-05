import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * 게임종류 후 우승자를 찾는 클래스
 */
public class FindWinner {
    public static String winner(ArrayList<Car> player) {


        //runCount가 가장 높은 값 찾기
        Comparator<Car> comparatorByRunCount = Comparator.comparingInt(Car::getRunCount);

        Car winner = player.stream()
                .max(comparatorByRunCount)
                .orElseThrow(NoSuchElementException::new);
        int winnerRunCount = winner.getRunCount();



        //가장 높은 runCount에 해당되는 객체들의 이름 찾기
        String winnerName = ""; //우승자 출력할 문자열
        winnerName = player.stream()
                .filter(car -> car.getRunCount()==winnerRunCount)
                .map(Car::getName)
                .collect(Collectors.joining(","));


        //마지막에 붙은 쉼표값 제거
        if(winnerName.endsWith(",")){
            winnerName = winnerName.substring(0,winnerName.length()-1);
        };
        return winnerName;
    }
}
