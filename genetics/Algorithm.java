package dev.harddrillstudio.genetics.genetics;

public class Algorithm {

    public static final int GOAL_X = 500;
    public static final int GOAL_Y = 500;

    public static final int POP_SIZE = 50;
    public static final int TOURNAMENT_SIZE = (int) (POP_SIZE * 0.4);
    public static final double MUTATION_RATE = 0.7;

    public static final boolean elitism = true;

    Population population;




    public Algorithm() {
        population = new Population(POP_SIZE);
    }


    public Population evolvePopulation(Population pop) {
        Population newPop = new Population(pop.size);

        for (int i = 0; i < pop.size; i++) {
            Individual mother = tournamentSelect(pop);
            Individual father = tournamentSelect(pop);

            Individual offspring = crossoverAverage(mother, father);
            offspring = mutate(offspring);

            newPop.individuals.set(i, offspring);
        }


        if (elitism) {
            Individual fittest = pop.getFittest();
            newPop.individuals.set(0, fittest);
        }

        newPop.calculateFitness();
        return newPop;
    }


    public Population getPopulation() {
        return population;
    }


    // CROSSOVER
    private Individual crossoverAlternating(Individual mother, Individual father) {
        Individual offspring = new Individual();
        for (int i = 0; i < Individual.GENOME_LENGTH; i++) {
            if (i % 2 == 0)
                offspring.genome.setGene(i, mother.genome.getGene(i));
            else
                offspring.genome.setGene(i, father.genome.getGene(i));
        }

        return offspring;
    }

    private Individual crossoverAverage(Individual mother, Individual father) {
        Individual offspring = new Individual();
        for (int i = 0; i < Individual.GENOME_LENGTH; i++) {
            double averageValue = ( mother.genome.getGene(i) + father.genome.getGene(i) ) / 2 ;
                offspring.genome.setGene(i, averageValue);
        }

        return offspring;
    }

    // MUTATION
    private Individual mutate(Individual individual) {
        if (Math.random() < MUTATION_RATE) {
            individual.mutate();
        }
        return individual;
    }


    // SELECTION
    private Individual tournamentSelect(Population pop) {
        pop.calculateFitness();

        Population tournament = new Population(TOURNAMENT_SIZE);
        for (int i = 0; i < TOURNAMENT_SIZE; i++) {
            int randomId = (int) (Math.random() * POP_SIZE);
            tournament.individuals.add(pop.individuals.get(randomId));
        }

        // get fittest
        Individual fittest = tournament.getFittest();
        return fittest;
    }


}
