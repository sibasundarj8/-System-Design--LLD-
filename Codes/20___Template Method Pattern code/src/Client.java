import Template.DecisionTreeModel;
import Template.ModelTrainer;
import Template.NeuralNetworkModel;

public class Client {
    public static void main(String[] args) {
        ModelTrainer neuralNetworkModel = new NeuralNetworkModel();
        ModelTrainer decisionTreeModel = new DecisionTreeModel();

        System.out.println("\n==========Neural-Network==========");
        neuralNetworkModel.trainPipeline("c:/neural_network/data");

        System.out.println("\n==========Decision-Tree==========");
        decisionTreeModel.trainPipeline("c:/decision_tree/data");
    }
}
