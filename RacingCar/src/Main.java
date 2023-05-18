import java.sql.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer gameCount;

        /**
         * 카 클래스
         */
        class Car{
            String name = new String();
            Integer runCount = 0;   //몇 번 움직였는지 숫자
            String result = "";     //몇 번 움직였는지 문자

            Car(String name) {
                this.name = name;
            }
            public String run() {
                double random = Math.floor(Math.random() * 10);
                if (random >= 4) {
                    result = result.concat("-");
                    runCount++;
                }
                return result;
            }
        }

        /**
         * 자동차 생성
         * n개의 값을 받아서 차를 생성하기 위해 ,를 기준으로 배열을 나누고
         * 객체를 저장할 수 있는 ArrayList에 Car클래스 생성자를 사용해서 담아줌
         */
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String playerInput = input.next();
        String[] playerStr = playerInput.split(",");

        //입력값이 5글자를 넘지 않도록한다.
        //5글자 이상이면 예외를 발생시켜서 메시지를 뜨게하고 다시 입력받는다.
        while(true) {
            try{
                for(int i=0; i<playerStr.length; i++){
                    if (playerStr[i].length() > 6) {
                        throw new IllegalArgumentException();
                    }
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR]5글자 이하의 이름을 입력하세요!");
                playerInput = input.next();
                playerStr = playerInput.split(",");  //정상값이 입력되면 쉼표를 기준으로 나눈다.
            }
        }

        ArrayList<Car> player = new ArrayList<Car>();
        for(int i=0;i<playerStr.length;i++){
            player.add(new Car(playerStr[i]));
        }


        //입력값이 0이하를 받지 않도록 한다.
        //게임횟수가 0이하면 예외를 발생시켜서 메시지를 뜨게하고 다시 입력받는다.
        System.out.println("시도할 횟수는 몇회인가요?");
        gameCount = input.nextInt();
        while(true){
            try{
                if(gameCount<=0) {
                    System.out.println("[ERROR]1회 이상을 입력하세요");
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e){
                gameCount = input.nextInt();
            }
        }


        /**
         * 게임시작!
         */
        for (int i=0; i<gameCount; i++){            // gameCount만큼 게임진행
            for(int j=0; j<playerStr.length; j++){  // gameCount 안에서 플레이어들 run() 실행
                player.get(j).run();
                System.out.println(player.get(j).name+" : "+player.get(j).result);
            }
            System.out.println();
        }
//
        /**
         * runCount가 가장 높은 값 찾기
         */
        Integer winnerResult = 0;
        for(int i=0; i<playerStr.length; i++) {
            if(winnerResult < player.get(i).runCount) {
                winnerResult = player.get(i).runCount;
            }
        }

        /**
         * runCount 가장 높은 값 출력
         */
        String winner = ""; //우승자 출력할 문자열
        for(int i=0; i<playerStr.length; i++) {
            if(player.get(i).runCount == winnerResult) {
                winner = winner.concat(player.get(i).name+",");
            }
        }
        //마지막 값에 붙은 쉼표제거
        if(winner.endsWith(",")){
            winner = winner.substring(0,winner.length()-1);
        };
        System.out.println("최종 우승자: "+winner);
    }
}