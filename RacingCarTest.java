import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RacingCarTest {
    @Test
    public void carTest(){
        //Given
        Car testCar = new Car("curt");
        //When
        testCar.run(5,testCar);
        //Then
        Assertions.assertEquals(1,testCar.getRunCount());

        //When
        testCar.run(1,testCar);
        //Then
        Assertions.assertEquals(2,testCar.getRunCount());
    }

}
