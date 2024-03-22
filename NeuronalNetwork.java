public class NeuronalNetwork {

    private int inputDim;
    private int hiddenDim;
    private int outputDim;
    private double[][] hiddenWeights;
    private double[] hiddenBiases;
    private double[][] outputWeights;
    private double[] outputBiases;

    public NeuronalNetwork(int inputDim, int hiddenDim, int outputDim) {
        this.inputDim = inputDim;
        this.hiddenDim = hiddenDim;
        this.outputDim = outputDim;
        initializeParameters();
    }

    public NeuronalNetwork(int inputDim, int hiddenDim, int outputDim, double[] values) {
        this.inputDim = inputDim;
        this.hiddenDim = hiddenDim;
        this.outputDim = outputDim;
        fillParametersWithValues(values);

    }

    public void fillParametersWithValues (double[] values){

        // [w1,1; w1,2; w2,1; w2,2; B1; B2; w1,o; w2,o; Bo]
        hiddenWeights = new double[inputDim][hiddenDim];
        hiddenBiases = new double[hiddenDim];
        outputWeights = new double[hiddenDim][outputDim];
        outputBiases = new double[outputDim];

        int index = 0;

        for (int i = 0; i != inputDim; i++ ) {
            for (int j = 0; j != hiddenDim; j++ ) {
                hiddenWeights[i][j] = values[index++];
            }
        }

        for (int i = 0; i != hiddenDim; i++ ) {
            hiddenBiases[i] = values[index++];
        }

        for (int i = 0; i != hiddenDim; i++ ) {
            for (int j = 0; j != outputDim; j++ ) {
                outputWeights[i][j] = values[index++];

            }
        }

        for (int i = 0; i != outputDim; i++ ) {
            outputBiases[i] = values[index++];
        }
    }

    public void initializeParameters() {

        hiddenWeights = new double[inputDim][hiddenDim];
        hiddenBiases = new double[hiddenDim];
        outputWeights = new double[hiddenDim][outputDim];
        outputBiases = new double[outputDim];

        for (int i = 0; i != inputDim; i++ ) {
            for (int j = 0; j != hiddenDim; j++ ) {
                hiddenWeights[i][j] = Math.random() * 0.5;
            }
        }

        for (int i = 0; i != hiddenDim; i++ ) {
            hiddenBiases[i] = Math.random() * 0.5;
        }

        for (int i = 0; i != hiddenDim; i++ ) {
            for (int j = 0; j != outputDim; j++ ) {
                outputWeights[i][j] = Math.random() * 0.5;
            }
        }

        for (int i = 0; i != outputDim; i++ ) {
            outputBiases[i] = Math.random() * 0.5;
        }

    }

    public double sigmoid (double x ){
       return  1.0/(1.0+Math.exp(-x));
    }

    public double[] forward(double[] inputValues) {

        double [] hiddenLayerOutput = new double[hiddenDim];
        double [] outputLayerOutput = new double[outputDim];

        for (int i = 0; i != hiddenDim; i++ ) {
            double res = 0;
            for (int j = 0; j != inputDim; j++ ) {
                res += hiddenWeights[j][i] * inputValues[j];
            }
            res += hiddenBiases[i];
            hiddenLayerOutput[i] = sigmoid(res);
        }


        for (int i = 0; i != outputDim; i++ ) {
            double res = 0;
            for (int j = 0; j != hiddenDim; j++ ) {
                res += outputWeights[j][i] * hiddenLayerOutput[j];
            }
            res += outputBiases[i];
            outputLayerOutput[i] = sigmoid(res);
        }

        return outputLayerOutput;
    }

//    public double[] getNeuralNetwork() {
//
//    }

    @Override
    public String toString() {
        String result = "Neural Network: \nNumber of inputs: "
                + inputDim + "\n"
                + "Weights between input and hidden layer with " + hiddenDim + " neurons: \n";
        String hidden = "";
        for (int input = 0; input < inputDim; input++) {
            for (int i = 0; i < hiddenDim; i++) {
                hidden += " input" + input + "-hidden" + i + ": "
                        + hiddenWeights[input][i] + "\n";
            }
        }
        result += hidden;
        String biasHidden = "Hidden biases: \n";
        for (int i = 0; i < hiddenDim; i++) {
            biasHidden += " bias hidden" + i + ": " + hiddenBiases[i] + "\n";
        }
        result += biasHidden;
        String output = "Weights between hidden and output layer with "
                + outputDim + " neurons: \n";
        for (int hiddenw = 0; hiddenw < hiddenDim; hiddenw++) {
            for (int i = 0; i < outputDim; i++) {
                output += " hidden" + hiddenw + "-output" + i + ": "
                        + outputWeights[hiddenw][i] + "\n";
            }
        }
        result += output;
        String biasOutput = "Ouput biases: \n";
        for (int i = 0; i < outputDim; i++) {
            biasOutput += " bias ouput" + i + ": " + outputBiases[i] + "\n";
        }
        result += biasOutput;
        return result;
    }

}
