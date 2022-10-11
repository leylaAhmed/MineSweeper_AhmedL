
import java.util.ArrayList;
import java.util.Scanner;

//Author: Leyla Ahmed


public class MineSweeper {
    public static void main(String[] theArgs) {
        ArrayList<char[][]> myFields = new ArrayList<>();
        Scanner scr = new Scanner(System.in);
        String myline;

        int myRows = scr.nextInt();
        int myCols = scr.nextInt();

        while (myRows != 0 && myCols != 0) {
            char[][] myField = new char[myRows][myCols];

            for (int i = 0; i < myField.length; i++) {

                myline = scr.next();

                for (int j = 0; j < myField[i].length; j++) {

                    myField[i][j] = myline.charAt(j);
                }

            }

            myFields.add(myField);
            myRows = scr.nextInt();
            myCols = scr.nextInt();

        }

        scr.close();

        printMineFields(myFields);

    }

    private static int showMineField(final int theRow, final int theCol, final char theField[][]) {
        int myCount = 0;

        if (theField[theRow][theCol] != '*') {


            if (theRow > 0 && theField[theRow - 1][theCol] == '*') {
                myCount++;

            }

            if (theRow < theField.length - 1 && theField[theRow + 1][theCol] == '*') {
                myCount++;

            }

            if (theCol > 0 && theField[theRow][theCol - 1] == '*') {
                myCount++;

            }

            if (theCol < theField[theRow].length - 1 && theField[theRow][theCol + 1] == '*') {
                myCount++;

            }

            if (theRow > 0 && theCol > 0 && theField[theRow - 1][theCol - 1] == '*') {
                myCount++;

            }

            if (theRow > 0 && theCol < theField[theRow].length - 1 && theField[theRow - 1][theCol + 1] == '*') {
                myCount++;

            }

            if (theRow < theField.length - 1 && theCol > 0 && theField[theRow + 1][theCol - 1] == '*') {
                myCount++;

            }
            if (theRow < theField.length - 1 && theCol < theField[theRow].length - 1 && theField[theRow + 1][theCol + 1] == '*') {
                myCount++;

            }

        }
        return myCount;

    }

    private static void printMineFields(ArrayList<char[][]> theFields) {

        for (int i = 1; i <= theFields.size(); i++) {

            System.out.println("Field #" + i + ":");

            for (int row = 0; row < theFields.get(i - 1).length; row++) {

                for (int col = 0; col < theFields.get(i - 1)[0].length; col++) {

                    if (theFields.get(i - 1)[row][col] != '*') {

                        System.out.print(showMineField(row, col, theFields.get(i - 1)));

                    } else {

                        System.out.print("*");
                    }
                }

                System.out.println();
            }
            System.out.println();
        }
    }
}
