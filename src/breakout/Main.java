package breakout;

public class Main {

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"DLS_DEAD_LOCAL_STORE", "DLS_DEAD_LOCAL_STORE"})

    public static void main(String[] args) {

        int seed = 1;
        GeneticAlgorithm ga = new GeneticAlgorithm();
        BreakoutBoard gaBB = new BreakoutBoard(ga.search(), true, seed);
        gaBB.setSeed(seed);
        gaBB.runSimulation();
        System.out.println("Kills " + gaBB.getKills());
        Double fitnessGa = gaBB.getFitness();
        new Breakout(ga.search(), seed);


    }
}

