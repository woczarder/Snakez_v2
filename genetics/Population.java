package dev.harddrillstudio.genetics.genetics;

import javafx.scene.Group;

import java.util.ArrayList;

public class Population extends Group {

    public int size;

    ArrayList<Individual> individuals;

    int totalFitness;




    public Population(int size) {
        this.size = size;

        individuals = new ArrayList<>();

        for (int i = 0; i < this.size; i++) {
            Individual temp = new Individual();

            individuals.add(temp);
            getChildren().add(temp);
        }

        calculateFitness();
    }

    public Individual getFittest() {
        Individual fittest = individuals.get(0);

        for (Individual i: individuals) {
            if (i.getFitness() < fittest.getFitness())
                fittest = i;
        }

        return fittest;
    }


    public void calculateFitness() {
        totalFitness = 0;
        for (Individual i: individuals) {
            totalFitness += i.getFitness();
        }
    }

    public void printPopulation() {
        for (int i = 0; i < individuals.size(); i++) {
            System.out.print(i + ": ");
            individuals.get(i).printIndividual();
        }
        System.out.println();
    }

}
