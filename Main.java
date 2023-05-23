import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;

interface RandomUtil {
    public int generate();
}

public class Main {
    @Test
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /**
         * 랜덤값 정의 클래스
         */
        class RandomNum{
            public int generate(){
                Random random = new Random();
                return random.nextInt();
            }
        }


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
        }
        /**
         * 게임에 필요한 메서드들
         */

        class Game {

            //플레이어의 이름이 5글자 이상이면 예외를 발생시켜서 메시지를 뜨게하고 다시 입력받는다.
            //while문으로 처리함 (정상적인 값을 받을 때 까지)

            public String[] join(String playerInput) {
                String[] playerStr = playerInput.split(","); //쉼표를 기준으로 문자열을 나눈다.
                while (true) {
                    try {
                        for (int i = 0; i < playerStr.length; i++) {
                            if (playerStr[i].length() >= 6) {
                                throw new IllegalArgumentException();
                            }
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("[ERROR]5글자 이하의 이름을 입력하세요!");
                        playerInput = input.next();
                        playerStr = playerInput.split(",");  //재입력된 값을 쉼표를 기준으로 나눈다.
                    }
                }
                return playerStr;
            }

            public ArrayList<Car> createPlayer(String[] playerStr) {
                ArrayList<Car> player = new ArrayList<Car>();
                for (int i = 0; i < playerStr.length; i++) {
                    player.add(new Car(playerStr[i])); //플레이어 리스트에 Car클래스 생성자로 만들어서 추가
                }
                return player;
            }

            //입력값이 0이하를 받지 않도록 한다.
            //게임횟수가 0이하면 예외를 발생시켜서 메시지를 뜨게하고 다시 입력받는다.
            public Integer setGameCount() {
                Integer gameCount = input.nextInt();
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
            public String run(int randomNum,Car player) {
                if (randomNum >= 4) {
                    player.result = player.result.concat("-");
                    player.runCount++;
                }
                return player.result;
            }


            public void start(String[] playerStr, ArrayList<Car> player, Integer gameCount) {
                RandomNum randomNum = new RandomNum();
                for (int i=0; i<gameCount; i++){            // gameCount만큼 게임진행
                    for(int j=0; j<playerStr.length; j++){  // gameCount 안에서 플레이어들 run() 실행
                        run(randomNum.generate(),player.get(j));
                        System.out.println(player.get(j).name+" : "+player.get(j).result);
                    }
                    System.out.println();
                }
            }



            public void winner(String[] playerStr, ArrayList<Car> player) {
                //runCount가 가장 높은 값 찾기
                Integer winnerResult = 0;
                for(int i=0; i<playerStr.length; i++) {
                    if(winnerResult < player.get(i).runCount) {
                        winnerResult = player.get(i).runCount;
                    }
                }

                //runCount 가장 높은 값 출력
                String winner = ""; //우승자 출력할 문자열
                for(int i=0; i<playerStr.length; i++) {
                    if(player.get(i).runCount == winnerResult) {
                        winner = winner.concat(player.get(i).name+",");
                    }
                }

                //마지막에 붙은 쉼표값 제거
                if(winner.endsWith(",")){
                    winner = winner.substring(0,winner.length()-1);
                };
                System.out.println("최종 우승자: "+winner);
            }
        }
        //===================================================================================

        Game game = new Game();
//        Random random = new Random();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String playerInput = input.next();

        String[] playerStr = game.join(playerInput); //쉼표를 기준으로 나눈 문자배열

        ArrayList<Car> player = game.createPlayer(playerStr);

        System.out.println("시도할 횟수는 몇회인가요?");
        Integer gameCount = game.setGameCount();

        game.start(playerStr,player,gameCount);
        game.winner(playerStr, player);

        RandomNum randomNum = new RandomNum();
        //Given
        Car testCar = new Car("curt");
        //When
        game.run(5,testCar);
        //Then
        Assertions.assertEquals(testCar.runCount,1);

        //When
        game.run(1,testCar);
        //Then
        Assertions.assertEquals(testCar.runCount,2);

    }
}