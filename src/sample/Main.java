package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private static final int width = 800;
    private static final int higth = 800;
    private static final int PERCENTAGE_OF_LIFE = 5;
    static  int[][] masField = new int[width][higth];

    @Override
    public void start(Stage primaryStage) throws Exception{



        countingLife(masField);

        Group root = new Group();
        for (int x = 0; x <masField.length ; x++) {
            for (int y = 0; y <masField.length ; y++) {
                if(masField[x][y] == 1){
                    Rectangle rectangle = new Rectangle(x,y,0,0);
                    rectangle.setStroke(Color.GREEN);
                    root.getChildren().add(rectangle);

                }
            }
        }

        Scene scene = new Scene(root, 800, 800, Color.BLACK) ;
        primaryStage.setTitle("Life") ;
        primaryStage.setScene(scene) ;
        primaryStage.show() ;

    }

    private void countingLife(int[][] mas1) {

        int tmp = (width*higth) / 100 * PERCENTAGE_OF_LIFE;// заполнение массива рандомной жизнью
        Random random = new Random();
        for (int i = 0; i <tmp ; i++) {
            masField[random.nextInt(width)][random.nextInt(higth)] = 1;
        }

        int checkNeighbors = 0;
        for (int x = 0; x < mas1.length ; x++) {
            for (int y = 0; y < mas1.length ; y++) {

                checkNeighbors = checkNeighbors(x,y);

                if(mas1[x][y] == 0){// если жизни нет проверяем соседей и если их 3 тогда даём новую жизнь
                    if(checkNeighbors == 3){
                        mas1[x][y] = 1;
                    }
                }
                if(mas1[x][y] == 1){
                    if(checkNeighbors < 2 || checkNeighbors > 3) {
                        mas1[x][y] = 0;
                    }
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


    public static void main(String[] args) {
        launch(args);
    }
}
