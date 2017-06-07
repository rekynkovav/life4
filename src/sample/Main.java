package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.game.Game;

public class Main extends Application {

    private static Stage stage; // само окно
    private static Scene scene; // сцены отоброжаемые внутри окна их можеть быть много и использовать их можно для разных задачь
    private static int x,y;
    private static Group pane;// на самом пане мы рисуем
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        pane = new Group();

        scene = new Scene(pane, 800, 800, Color.BLACK);
        Game.start();

        stage.setTitle("Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void printRectangle(int x, int y){
        Rectangle rectangle = new Rectangle(x, y, 0, 0);
        rectangle.setStroke(Color.GREEN);
        pane.getChildren().add(rectangle);
    }

    public static void clearDysplay(){


    }

    public static void main(String[] args) {
        launch(args);

    }
}
