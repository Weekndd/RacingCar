import java.util.Scanner;

/**
 * 플레이어 이름 입력과 체크(5글자 이상인지)
 */
public class Input {
    static Scanner input = new Scanner(System.in);
    static final int NAME_LENGTH_THRESHOLD = 6;

    static public String[] splitPlayerName(){
        String playerInput = input.next();
        String[] playerName = playerInput.split(",");
        return  playerName;
    }


    static public String[] checkPlayerName(String[] playerName){
        while(true){
            try{
                for (int i=0; i< playerName.length; i++){
                    if(playerName[i].length()>= NAME_LENGTH_THRESHOLD) {
                        throw new IllegalArgumentException();
                    }
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR]5글자 이하의 이름을 입력하세요!");
                playerName = splitPlayerName();
            }
        }
        return playerName;
    }

}
