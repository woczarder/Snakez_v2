package dev.harddrillstudio.genetics.genetics;

public class GeneticLauncher implements Runnable {

    Algorithm algorithm;



    public GeneticLauncher() {

        algorithm = new Algorithm();

    }


    public Algorithm getAlgorithm() {
        return algorithm;
    }


    @Override
    public void run() {
        int genCount = 0;


        while(algorithm.getPopulation().getFittest().getFitness() > 120 ) {
            algorithm.setPopulation(algorithm.evolvePopulation(algorithm.getPopulation()));
            genCount++;

            algorithm.getPopulation().printPopulation();
            System.out.println("Generation: " + genCount + " Fittest: " + algorithm.getPopulation().getFittest().getFitness());
        }
    }

}
