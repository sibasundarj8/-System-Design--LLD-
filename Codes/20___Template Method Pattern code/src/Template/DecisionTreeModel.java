package Template;

public class DecisionTreeModel extends ModelTrainer {

    @Override
    protected void preprocessData() {
        System.out.println("[Decision-Tree]: pre-processing the data");
    }

    @Override
    protected void trainModel() {
        System.out.println("[Decision-Tree]: training the model");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[Decision-Tree]: evaluating the data");
    }
}
