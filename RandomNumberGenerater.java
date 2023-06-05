import java.util.Random;
/**
 * 랜덤값 정의 클래스
 */
public class RandomNumberGenerater {
        public int generate(){
            Random random = new Random();
            return random.nextInt();
        }
}
