package dev.harddrillstudio.genetics.genetics;

import javafx.scene.shape.Polyline;

import java.util.Random;

import static java.awt.geom.Point2D.distance;

public class Individual extends Polyline {

    public final static int SEGMENT_LENGTH = 20;
    public final static int SEGMENT_QUANTITY = 25;
    public final static int GENOME_LENGTH = SEGMENT_QUANTITY;

    private double lastX, lastY;

    private double fitness;

    Genome genome;




    public Individual() {

        genome = new Genome(SEGMENT_QUANTITY);

        setPolylinePoints();

        getFitness();
    }


    public void mutate() {
        Random random = new Random();

        int mutationQuantity = random.nextInt(GENOME_LENGTH);
        for (int i = 0; i < mutationQuantity; i++) {
            int index = random.nextInt(GENOME_LENGTH);
            genome.modGene(index, (1 - Math.random() ) / 2 );
        }

    }


    public double getFitness() {
        this.fitness = distance(lastX, lastY, Algorithm.GOAL_X, Algorithm.GOAL_Y);

        return fitness;
    }


    public void printIndividual() {
        System.out.println("F= " +fitness+ " G= " + genome.getGenesInString());
    }


    private void setPolylinePoints() {
        Double x, y, dx, dy;

        x = y = 100.0;

        for (int i = 0; i < SEGMENT_QUANTITY; i++) {
            dx = Math.cos(genome.getGenes()[i]) * Individual.SEGMENT_LENGTH;
            dy = Math.sin(genome.getGenes()[i]) * Individual.SEGMENT_LENGTH;

            x += dx;
            y += dy;

            this.getPoints().add(x);
            this.getPoints().add(y);

            //System.out.println(x);
            //System.out.println(y);

            if (i == SEGMENT_QUANTITY-1) {
                lastX = x;
                lastY = y;
            }

        }
    }


    public double[] getGenes() {
        return genome.getGenes();
    }



}
