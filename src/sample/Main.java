package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import sample.game.Game;

public class Main extends Application {

    private static Stage stage; // само окно
    private static Scene scene,scene1; // сцены отоброжаемые внутри окна их можеть быть много и использовать их можно для разных задачь
    private static Group pane;// на самом пане мы рисуем
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        pane = new Group();

        scene = new Scene(pane, 800, 800, Color.BLACK);

        stage.setTitle("Life");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Game.start();
            }
        };
        timer.start();
    }

    public static void printRectangle(int x, int y){
        Line line = new Line(x,y,x,y);
        line.setStroke(Color.FORESTGREEN);
        pane.getChildren().add(line);
    }

    public static void clearDisplay(){

    }

    public static void main(String[] args) {
        launch(args);

    }
}