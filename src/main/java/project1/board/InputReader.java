package project1.board;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    private final Scanner scanner = new Scanner(System.in);


    public Integer getValidIntegerInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("잘 못된 입력입니다. 숫자만 입력하세요.");
                scanner.nextLine();
                System.out.println();
                return null;
            }
        }
    }

    public String getValidStringInput(){
        return scanner.nextLine();
    }

    public boolean isNumeric(String string){
        if (string == null || string.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(string);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public void bufferScanner(){scanner.nextLine();}

}
