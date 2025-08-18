package FileSystem.core;

import java.util.HashMap;
import java.util.Map;

public class Folder implements Component {
    private final String name;
    private final Map<String, Component> openableMap;

    public Folder(String name) {
        this.name = name;
        this.openableMap = new HashMap<>();
    }

    @Override
    public void openAll(int indent) {
        String space = " ".repeat(indent);
        System.out.println(space + "◿ " + this.name);

        for (String component : openableMap.keySet()) {
            openableMap.get(component).openAll(indent + 4);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Boolean isFolder() {
        return true;
    }

    @Override
    public Double getSize() {
        Double size = 0.0;

        for (Component component : openableMap.values()) {
            size += component.getSize();
        }

        return size;
    }

    @Override
    public void createFolder(String name) {
        Component component = searchByName(name);
        if (component == null) {
            component = new Folder(name);
            openableMap.put(name, component);
        } else {
            throw new RuntimeException("[File/Folder] already exist with name: " + name);
        }
    }

    @Override
    public void createFile(String name, double size) {
        Component component = searchByName(name);
        if (component == null) {
            component = new File(name, size);
            openableMap.put(name, component);
        } else {
            throw new RuntimeException("[File/Folder] already exist with name: " + name);
        }
    }

    @Override
    public Component searchByName(String name) {
        // base case
        if (this.name.equals(name)) return this;
        if (openableMap.containsKey(name)) {
            return openableMap.get(name);
        }

        for (String folder : openableMap.keySet()){
            Component temp = openableMap.get(folder).searchByName(name);
            if (temp != null) return temp;
        }

        return null;
    }
}