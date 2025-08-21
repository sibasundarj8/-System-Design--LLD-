package Template;

public class NeuralNetworkModel extends ModelTrainer {

    @Override
    protected void preprocessData() {
        System.out.println("[Neural-Network]: pre-processing the data");
    }

    @Override
    protected void trainModel() {
        System.out.println("[Neural-Network]: training the model");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[Neural-Network]: evaluating the data");
    }

    @Override
    protected void saveData() {
        System.out.println("[Neural-Network]: saving data as .j5 file");
    }
}