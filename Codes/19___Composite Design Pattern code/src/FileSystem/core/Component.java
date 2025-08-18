package FileSystem.core;

public interface Component {
    void openAll(int indent);

    String getName();

    Boolean isFolder();

    Double getSize();

    default void createFolder(String name) {
    }

    default void createFile(String name, double size) {
    }

    default Component searchByName(String name) {
        return null;
    }
}
