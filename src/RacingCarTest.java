import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class RacingCarTest {
    @Test
    public void runTest(){
        //Car.run Test
        //Given
        Car testCar = new Car("curt");
        //When
        testCar.run(5,testCar);
        //Then
        Assertions.assertEquals(1,testCar.getRunCount());

        //When
        testCar.run(1,testCar);
        //Then
        Assertions.assertEquals(1,testCar.getRunCount());
    }
    @Test
    public void findWinnerTest(){
        //FindWinner.winner Test
        //Given
        ArrayList<Car> cars = new ArrayList<Car>();

        //When
        cars.add(new Car("pobi",4));
        cars.add(new Car("woni",5));
        cars.add(new Car("jun",5));

        //Then
        Assertions.assertEquals("woni,jun",FindWinner.winner(cars));
    }
    @Test //예외처리가 정상적으로 작동되는지 확인 (예외상황이 아닌경우, 예외없이 정상처리 된다는 예외..발생..?)
    public void checkPlayerNameTest(){
        //Input.checkPlayerName Test
        //Given
        String[] player =new String[3];

        //When
        player[0]="aaaaa";
        player[1]="bbbb";
        player[2]="ccc";

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Input.checkPlayerName(player);
        },"예외없이 정상적으로 처리되었습니다");
    }
}
