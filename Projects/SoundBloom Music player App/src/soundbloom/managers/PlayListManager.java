package soundbloom.managers;

import soundbloom.models.PlayList;
import soundbloom.models.Song;

import java.util.HashMap;
import java.util.Map;

public class PlayListManager {
    private static volatile PlayListManager instance;
    private final Map<String, PlayList> playListMap;

    // constructor
    private PlayListManager() {
        this.playListMap = new HashMap<>();
    }

    public static PlayListManager getInstance() {
        if (instance == null) {
            synchronized (PlayListManager.class) {
                if (instance == null) {
                    instance = new PlayListManager();
                }
            }
        }
        return instance;
    }

    // methods

    // creating new playlist
    public void createPlayList(String name) {
        if (playListMap.containsKey(name)) {
            throw new RuntimeException("name already used");
        }
        playListMap.put(name, new PlayList(name));
    }

    // deleting playlist
    public void deletePlayList(String name) {
        playListMap.remove(name);
    }

    // add song to playlist
    public void addSongToPlayList(Song song, String playListName) {
        PlayList playList = getPlayListByName(playListName);
        playList.addSong(song);
    }

    // remove song
    public void removeSongFromPlayList(Song song, String playListName) {
        PlayList playList = getPlayListByName(playListName);
        playList.removeSong(song);
    }

    // get playlist
    public PlayList getPlayListByName(String name){
        if (!playListMap.containsKey(name)){
            throw new RuntimeException("No playlist found for: " + name);
        }

        return playListMap.get(name);
    }
}