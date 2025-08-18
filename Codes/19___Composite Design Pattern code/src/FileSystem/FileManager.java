package FileSystem;

import FileSystem.core.Folder;
import FileSystem.core.Component;

// singleton
public class FileManager {
    private static volatile FileManager instance;
    private final Component component;

    private FileManager() {
        this.component = new Folder("root");
    }

    public static FileManager getInstance() {
        if (instance == null) {
            synchronized (FileManager.class) {
                if (instance == null) {
                    instance = new FileManager();
                }
            }
        }

        return instance;
    }

    // create folder in a particular folder
    public void createFolder(String parentName, String folderName) {
        searchByName(parentName).createFolder(folderName);
    }

    // create file in a particular folder
    public void createFile(String parentName, String fileName, double size) {
        searchByName(parentName).createFile(fileName, size);
    }

    // expand all directories
    public void openAll() {
        this.component.openAll(0);
    }

    // search a file/folder by name
    public Component searchByName(String name) {
        Component component = this.component.searchByName(name);

        if (component == null) {
            throw new RuntimeException("[File/Folder] not found for: " + name);
        }

        return component;
    }

    // get size of file or folder by name
    public Double getSize(String name) {
        Component target = searchByName(name);
        return target.getSize();
    }

    // get type
    public String getType(String name) {
        Boolean type = searchByName(name).isFolder();
        return (type) ? "Folder" : "File";
    }
}
