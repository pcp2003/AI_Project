//package breakout;
//
//import java.util.Arrays;
//
//public class GeneticAlgorithm {
//
//    private final int POPULATION_SIZE = 100;
//    private final int NUM_GENERATIONS = 1000;
//    private final double MUTATION_RATE = 0.05;
//    private final double SELECTION_PERCENTAGE = 0.2;
//
//    private final int k_tournament = 2;
//    private final int BOARD_SIZE = 8;
//
//    private QueenBoard[] population = new QueenBoard[POPULATION_SIZE];
//
//    public GeneticAlgorithm() {
//        generatePopulation();
//    }
//
//    public QueenBoard search() {
//        for (int i = 0; i < NUM_GENERATIONS; i++) {
//            Arrays.sort(population );
//            System.out.println("Generation " + i + ":\n" + population[0]);
//
//            if (population[0].getFitness() == population[0].getMaxFitness()) {
//                System.out.println("Solution found!");
//                break;
//            }
//
//            QueenBoard[] newGeneration = new QueenBoard[POPULATION_SIZE];
//            for (int j = 0; j < POPULATION_SIZE; j += 2) {
//                QueenBoard parent1 = selectParent();
//                QueenBoard parent2 = selectParent();
//                QueenBoard[] children = crossover(parent1, parent2);
//
//                newGeneration[j] = mutate(children[0]);
//                if (j + 1 < POPULATION_SIZE) {
//                    newGeneration[j + 1] = mutate(children[1]);
//                }
//            }
//            createNewPopulation(newGeneration);
//        }
//        return population[0];
//    }
//
//    //SELECTION_PERCENTAGE of the best children +
//    //(1-SELECTION_PERCENTAGE) of the best from the previous population
//    private void createNewPopulation(QueenBoard[] newgeneration) {
//
//        Arrays.sort(newgeneration);
//        int cutoff = (int) (POPULATION_SIZE * SELECTION_PERCENTAGE);
//
//        for (int i = 0; i != cutoff; i++ ){
//            population[i] = newgeneration[i];
//        }
//
//    }
//
//    // mutate one gene with MUTATION_RATE chance
//    private QueenBoard mutate(QueenBoard child) {
//        double random = Math.random();
//        if (random <= MUTATION_RATE) {
//            int[] childNewPos = child.getQueens_positions().clone();
//            childNewPos[(int) (Math.random() * BOARD_SIZE)] = (int) (Math.random() * BOARD_SIZE);
//            return new QueenBoard(childNewPos);
//        }
//        return child;
//    }
//
//    // one-point crossover
//    private QueenBoard[] crossover(QueenBoard parent1, QueenBoard parent2) {
//
//        int numberOfChildren = 2;
//        int random = (int) (Math.random() * BOARD_SIZE);
//
//        QueenBoard[] children = new QueenBoard[numberOfChildren];
//
//        int[] child1 = new int[BOARD_SIZE];
//        int[] child2 = new int[BOARD_SIZE];
//        int[] parent1_positions = parent1.getQueens_positions();
//        int[] parent2_positions = parent2.getQueens_positions();
//
//        for (int j = 0; j != random; j++) {
//            child1[j] = parent1_positions[j];
//            child2[j] = parent2_positions[j];
//        }
//        for (int k = random; k != BOARD_SIZE; k++) {
//            child1[k] = parent2_positions[k];
//            child2[k] = parent1_positions[k];
//        }
//        children[0] = new QueenBoard(child1);
//        children[1] = new QueenBoard(child2);
//
//        return children;
//    }
//
//    // tournament selection
//    private QueenBoard selectParent () {
//
//        QueenBoard one = population[(int) (Math.random() * POPULATION_SIZE)];
//        QueenBoard two = population[(int) (Math.random() * POPULATION_SIZE)];
//
//        if (one.compareTo(two) >= 0)
//            return two;
//        else
//            return one;
//
//    }
//
//
//    // generate random population
//    private void generatePopulation() {
//        for (int i = 0; i < population.length; i++) {
//            population[i] = new QueenBoard(BOARD_SIZE);
//        }
//    }
//
//}
//
