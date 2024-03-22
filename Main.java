public class Main {

    public static void main(String[] args) {
        double[] values = {0.5,0.5,0.5,0.5,0.5,0.5,0.2,0.1,0.3,0.3,0.5}; NeuronalNetwork nn_values =
                new NeuronalNetwork(3, 2, 1, values); System.out.println(nn_values);
        System.out.println("Forward result:"); double[] input = {0.0,0.0,1.0};
        double[] result = nn_values.forward(input); for (int i = 0; i < result.length; i++) {
            System.out.println(" Result for neuron ouput"+(i+1)+
                    "= "+result[i]);
        }
    }

}
