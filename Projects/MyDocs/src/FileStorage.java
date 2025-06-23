import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class FileStorage implements Persistence {
    private final String name;
    private final Logger logger = Logger.getLogger(FileStorage.class.getName());

    public FileStorage(String name) {
        this.name = name + ".txt";
    }

    @Override
    public void save(String data) {
        String msg = "successfully saved";
        try {
            FileWriter writer = new FileWriter(name);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            logger.severe("Something went wrong" + e.getMessage());
            msg = "app ended";
        }
        logger.info(msg);
    }
}