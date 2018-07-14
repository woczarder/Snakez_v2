package dev.harddrillstudio.genetics;

import dev.harddrillstudio.genetics.genetics.Algorithm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;
import dev.harddrillstudio.genetics.genetics.GeneticLauncher;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GeneticLauncher geneticLauncher = new GeneticLauncher();
        geneticLauncher.start();
        Ellipse goal = new Ellipse(Algorithm.GOAL_X, Algorithm.GOAL_Y, 10, 10);

        Group stuff = new Group(goal);

        Group root = new Group(geneticLauncher.getAlgorithm().getPopulation(), stuff);


        Scene scene = new Scene(root, 600,600);
        scene.setFill(Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snakez v2");

        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        final long timeStart = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent ae)
                    {
                        double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                        double x = 232 + 128 * Math.cos(t);
                        double y = 232 + 128 * Math.sin(t);

                        // Clear the canvas
                        gc.clearRect(0, 0, 512,512);

                        // background image clears canvas

                    }
                }
        );

        primaryStage.show();

        //geneticLauncher.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
