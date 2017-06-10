package sample.game;

import sample.Main;

import java.util.Random;

public class Game {

    private static final int width = 800;
    private static final int higth = 800;
    private static final int PERCENTAGE_OF_LIFE = 5;
    public static  int[][] masField = new int[width][higth];

    // рождение рандомной жизни
    static {
        int tmp = (width * higth) / 100 * PERCENTAGE_OF_LIFE;
        Random random = new Random();
        for (int i = 0; i < tmp; i++) {
            masField[random.nextInt(width)][random.nextInt(higth)] = 1;
        }
    }

    public  static void start(){
        countingLife();
        print(masField);
    }

    private static void countingLife() {

        int checkNeighbors = 0;
        for (int x = 0; x < masField.length ; x++) {
            for (int y = 0; y < masField.length ; y++) {

                checkNeighbors = checkNeighbors(x,y);

                    if(masField[x][y] == 0 && checkNeighbors == 3){
                        masField[x][y] = 1;
                        Main.printRectangle(x,y);
                    }

                if(masField[x][y] == 1 && checkNeighbors <= 2 || checkNeighbors > 3){
                        masField[x][y] = 0;
                }
            }
        }
    }

    private static int checkNeighbors(int x, int y) {

        int amountOfLife = 0;

        if (x == 0 && y == 0) { // проверяем верхний левый угол
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
        }

        if (x == masField.length && y == 0) {// проверяем верхний правый угол
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
        }

        if (x == 0 && y == masField.length) { // проверяем нижний левый угол
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
        }

        if (x == masField.length && y == masField.length) { // проверяем правый нижний угол
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
        }

        if (x == 0 & y > 0 && y < masField.length) { // проверяем у левой стенки
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
        }

        if (x == masField.length && y > 0 & y < masField.length) { // проверяем у правой стенки
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
        }

        if (y == 0 & x > 0 && x < masField.length-1) { // проверяем у верхней стенки
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
        }

        if (y == masField.length && x > 0 & x < masField.length) { // проверяем у нижней стенки
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
        }
        // проверка в поле где 8 клеток
        if(x > 0 && y > 0 && y < masField.length-1 && x < masField.length-1) {
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
        }

        return amountOfLife;
    }

    private static void print(int[][] mastmp) {

        for (int x = 0; x <mastmp.length ; x++) {
            for (int y = 0; y <mastmp.length ; y++) {
                System.out.print(mastmp[x][y]+ " ");
            }
            System.out.println();

        }
    }
}

