package dev.harddrillstudio.genetics.genetics;

public class GeneticLauncher {

    Algorithm algorithm;



    public GeneticLauncher() {

        algorithm = new Algorithm();

    }


    public void start() {
        int genCount = 0;


        while(algorithm.getPopulation().getFittest().getFitness() > 120 ) {
            algorithm.population = algorithm.evolvePopulation(algorithm.getPopulation());
            genCount++;

            algorithm.getPopulation().printPopulation();
            System.out.println("Generation: " + genCount + " Fittest: " + algorithm.getPopulation().getFittest().getFitness());
        }
    }


    public Algorithm getAlgorithm() {
        return algorithm;
    }
}
