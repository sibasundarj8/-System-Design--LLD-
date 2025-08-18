package FileSystem.core;

public class File implements Component {
    private final String name;
    private final Double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void openAll(int indent) {
        String space = " ".repeat(indent);
        System.out.println(space + this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Boolean isFolder() {
        return false;
    }

    @Override
    public Double getSize() {
        return this.size;
    }
}