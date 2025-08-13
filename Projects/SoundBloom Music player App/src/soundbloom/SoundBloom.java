package soundbloom;

import soundbloom.enums.DeviceType;
import soundbloom.enums.StrategyType;
import soundbloom.managers.PlayListManager;
import soundbloom.models.Song;

import java.util.LinkedList;
import java.util.List;

public class SoundBloom {
    private static volatile SoundBloom instance;

    // variables
    private final List<Song> myLibrary;

    // constructor
    private SoundBloom() {
        this.myLibrary = new LinkedList<>();
    }

    public static SoundBloom getInstance() {
        if (instance == null) {
            synchronized (SoundBloom.class) {
                if (instance == null) {
                    instance = new SoundBloom();
                }
            }
        }
        return instance;
    }

    // methods
    public void createSongInLibrary(String name, String artist, String path) {
        myLibrary.add(new Song(name, artist, path));
    }

    // setting up -Audio Output Device
    public void connectDevice(DeviceType deviceType) {
        MusicPlayerFacade.getInstance().connectDevice(deviceType);
    }

    // play Searched Song
    public void playSong(String title) {
        Song song = this.findByTitle(title);
        MusicPlayerFacade.getInstance().play(song);
    }

    // pause the song
    public void pauseCurrentSong() {
        MusicPlayerFacade.getInstance().pause();
    }

    // creating playlist
    public void createPlayList(String name) {
        PlayListManager.getInstance().createPlayList(name);
    }

    // adding songs to playlist
    public void addSongToPlayList(String playlistName, String songName) {
        Song song = findByTitle(songName);
        PlayListManager.getInstance().addSongToPlayList(song, playlistName);
    }

    // remove song from playlist
    public void removeSongFromPlayList(String songName, String playListName) {
        Song song = findByTitle(songName);
        PlayListManager.getInstance().removeSongFromPlayList(song, playListName);
    }

    // load playlist by name
    public void loadPlayList(String playListName) {
        MusicPlayerFacade.getInstance().loadPlayList(playListName);
    }

    // select playing strategy
    public void selectPlayingStrategy(StrategyType strategyType) {
        MusicPlayerFacade.getInstance().setPlayingStrategy(strategyType);
    }

    // play all songs of a playlist
    public void playAllTracksOfPlayList() {
        MusicPlayerFacade.getInstance().playAll();
    }

    // play next song
    public void playNextSongOfPlayList() {
        MusicPlayerFacade.getInstance().playNext();
    }

    // play previous track
    public void playPreviousTrackOfPlayList() {
        MusicPlayerFacade.getInstance().playPrevious();
    }

    // Add song to play next
    public void addToQueue(String songName) {
        Song song = findByTitle(songName);
        MusicPlayerFacade.getInstance().addToQueue(song);
    }

    // Search Songs by -Name
    private Song findByTitle(String title) {

        for (Song song : myLibrary) {
            if (song.getName().equalsIgnoreCase(title)){
                return song;
            }
        }

        throw new RuntimeException("no result found for: " + title);
    }
}