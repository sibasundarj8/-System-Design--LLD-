package Template;

public abstract class ModelTrainer {

    protected void loadData(String path) {
        System.out.println("[common]: Loading data from path {" + path + "}");
    }

    protected abstract void preprocessData();

    protected abstract void trainModel();

    protected abstract void evaluateModel();

    protected void saveData() {
        System.out.println("[common]: saving data to DB");
    }

    public void trainPipeline(String path) {
        loadData(path);
        preprocessData();
        trainModel();
        evaluateModel();
        saveData();
    }
}