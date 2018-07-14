package dev.harddrillstudio.genetics;


import dev.harddrillstudio.genetics.genetics.Individual;

public class MathHelper {




    public static Double[] getPointsForPolyline(double[] degrees) {
        Double points[] = new Double[degrees.length*2];
        Double x, y;

        for (int i = 0; i < degrees.length; i++) {
            x = Math.cos(degrees[i]) * Individual.SEGMENT_LENGTH;
            y = Math.sin(degrees[i]) * Individual.SEGMENT_LENGTH;

            points[i] = x;
            points[i+1] = y;
        }

        return points;
    }

}
