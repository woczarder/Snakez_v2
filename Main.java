package dev.harddrillstudio.genetics;

import dev.harddrillstudio.genetics.genetics.Algorithm;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import dev.harddrillstudio.genetics.genetics.GeneticLauncher;
import javafx.util.Duration;

public class Main extends Application implements Runnable {

    private Text fittestText;
    private Ellipse goal;
    private Group root, UIAddons;
    private Scene scene;
    private Stage primaryStage;
    private Timeline timeline;

    private GeneticLauncher geneticLauncher;
    private Thread algorithm;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        startGeneticThread();
        
        initGroups();

        initAnimation();

        initScene();

        initStage();
    }


    @Override
    public void run() {

    }


    private void updateScreen() {
        fittestText = new Text("Fittest: " + geneticLauncher.getAlgorithm().getPopulation().getFittest().getFitness());
        root = new Group(geneticLauncher.getAlgorithm().getPopulation(), UIAddons);
        scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
    }


    private void initStage() {
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snakez v2");
        primaryStage.show();
    }

    private void initScene() {
        scene = new Scene(root, 600,600);
        scene.setFill(Color.WHITE);
    }

    private void initGroups() {
        goal = new Ellipse(Algorithm.GOAL_X, Algorithm.GOAL_Y, 10, 10);
        fittestText = new Text("Fittest: " + geneticLauncher.getAlgorithm().getPopulation().getFittest().getFitness());
        fittestText.setX(400);
        fittestText.setY(50);

        UIAddons = new Group(goal, fittestText);
        root = new Group(geneticLauncher.getAlgorithm().getPopulation(), UIAddons);
    }

    private void initAnimation() {
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateScreen();
            }
        };

        Duration duration = Duration.millis(1000);
        KeyFrame keyFrame = new KeyFrame(duration);

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        timer.start();
    }

    private void startGeneticThread() {
        geneticLauncher = new GeneticLauncher();
        algorithm = new Thread(geneticLauncher);
        algorithm.start();
    }

}
