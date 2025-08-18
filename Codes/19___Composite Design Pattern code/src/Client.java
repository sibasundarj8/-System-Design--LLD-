import FileSystem.FileManager;

public class Client {
    public static void main(String[] args) {
        try {
            FileManager fileManager = FileManager.getInstance();

            fileManager.createFolder("root", "Photos");

            fileManager.createFile("Photos", "Sibasundar.png", 1.2);
            fileManager.createFile("Photos", "Manoranjan.png", 1.5);
            fileManager.createFile("Photos", "Sanjulata.png", 1.4);

            fileManager.createFolder("root", "Music");

            fileManager.createFolder("Music", "sad_songs");
            fileManager.createFile("sad_songs", "Dillagi.mp3", 3.6);
            fileManager.createFile("sad_songs", "Sanso_ki_mala.mp3", 4.3);

            fileManager.createFolder("Music", "item_songs");
            fileManager.createFile("item_songs", "Dilber.mp3", 4.1);
            fileManager.createFile("item_songs", "Aaj_ki_raat.mp3", 3.5);

            fileManager.openAll();

            System.out.println(fileManager.getSize("item_songs"));

            fileManager.createFolder("root", "Photos");
        } catch (RuntimeException r) {
            System.out.println("⚠️ " + r.getMessage() + " ⚠️");
        }
    }
}
