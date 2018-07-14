package dev.harddrillstudio.genetics.genetics;

public class Genome {

    private double[] genes; // holds the degrees values

    public Genome(int length) {
        genes = new double[length];

        randomizeGenome();
    }

    private void randomizeGenome() {
        for (int i = 0; i < genes.length; i++) {
            //genes[i] = ( Math.random()*Math.PI ) / 2;
            genes[i] = Math.random()*Math.PI;
        }
    }

    public double[] getGenes() {
        return genes;
    }

    public void setGene(int index, double value) {
        genes[index] = value;
    }

    public double getGene(int index) {
        return genes[index];
    }

    public void modGene(int index, double amount) {
        genes[index] += amount;
    }

    public String getGenesInString() {
        StringBuilder builder = new StringBuilder();

        for (double chunk : this.genes) {
            builder.append(String.valueOf(chunk));
            builder.append(", ");
        }

        return builder.toString();
    }

}
