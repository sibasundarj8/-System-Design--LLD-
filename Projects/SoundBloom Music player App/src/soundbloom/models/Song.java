package soundbloom.models;

public class Song {
    private String name;
    private String artist;
    private String path;

    public Song(String name, String artist, String path) {
        this.name = name;
        this.artist = artist;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}