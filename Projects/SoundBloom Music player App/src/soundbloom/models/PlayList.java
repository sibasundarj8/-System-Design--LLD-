package soundbloom.models;

import java.util.LinkedList;
import java.util.List;

public class PlayList {
    private final String name;
    private final List<Song> songs;

    // constructor
    public PlayList(String name) {
        this.name = name;
        songs = new LinkedList<>();
    }

    // adding to playlist
    public void addSong(Song song) {
        if (!songs.contains(song)) {
            songs.add(song);
        }
    }

    // removing from playlist
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // getter
    public String getName() {
        return this.name;
    }

    public List<Song> getSongs() {
        return this.songs;
    }

    public Integer getSize() {
        return this.songs.size();
    }
}
