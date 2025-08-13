package soundbloom;

import soundbloom.core.AudioEngine;
import soundbloom.deviceAdapters.IAudioOutputDevice;
import soundbloom.enums.DeviceType;
import soundbloom.enums.StrategyType;
import soundbloom.managers.DeviceManager;
import soundbloom.managers.PlayListManager;
import soundbloom.managers.StrategyManager;
import soundbloom.models.PlayList;
import soundbloom.models.Song;
import soundbloom.strategies.IPlayingStrategy;

public class MusicPlayerFacade {
    private static volatile MusicPlayerFacade instance;

    private final AudioEngine audioEngine;
    private PlayList currentPlayList;
    private IPlayingStrategy playingStrategy;

    // constructor
    private MusicPlayerFacade() {
        // setting up audio engin
        this.audioEngine = new AudioEngine();
        // taking SEQUENCE as default strategy
        this.playingStrategy = StrategyManager.getInstance().getPlayingStrategy(StrategyType.SEQUENCE);
    }

    public static MusicPlayerFacade getInstance() {
        if (instance == null) {
            synchronized (MusicPlayerFacade.class) {
                if (instance == null) {
                    instance = new MusicPlayerFacade();
                }
            }
        }
        return instance;
    }

    // Connecting to an Audio output Device
    public void connectDevice(DeviceType deviceType) {
        DeviceManager.getInstance().connectDevice(deviceType);
    }

    // Play a song
    public void play(Song song) {
        audioEngine.play(song, DeviceManager.getInstance().getAudioOutputDevice());
    }

    // Pause a song
    public void pause() {
        audioEngine.pause();
    }

    // loading playlist
    public void loadPlayList(String name) {
        PlayList playList = PlayListManager.getInstance().getPlayListByName(name);
        this.currentPlayList = playList;
        this.playingStrategy.setPlayList(playList);
    }

    // selecting strategy
    public void setPlayingStrategy(StrategyType strategyType) {
        this.playingStrategy = StrategyManager.getInstance().getPlayingStrategy(strategyType);
    }

    // play all tracks of loaded playlist
    public void playAll() {

        if (currentPlayList == null) {
            throw new RuntimeException("no playlist loaded");
        }

        while (playingStrategy.hasNext()) {
            Song song = playingStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getAudioOutputDevice();
            audioEngine.play(song, device);
        }

        System.out.println("Playlist completed: " + currentPlayList.getName() + "\n");
    }

    // play next song of the playlist
    public void playNext(){
        if (currentPlayList == null) {
            throw new RuntimeException("no playlist loaded");
        }
        if (playingStrategy.hasNext()) {
            Song song = playingStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getAudioOutputDevice();
            audioEngine.play(song, device);
        } else {
            System.out.println("Completed playlist: " + currentPlayList.getName());
        }
    }

    // play previous song of the playlist
    public void playPrevious() {
        if (currentPlayList == null) {
            throw new RuntimeException("no playlist loaded");
        }
        if (playingStrategy.hasPrevious()) {
            Song song = playingStrategy.previous();
            IAudioOutputDevice device = DeviceManager.getInstance().getAudioOutputDevice();
            audioEngine.play(song, device);
        } else {
            System.out.println("Completed playlist: " + currentPlayList.getName());
        }
    }

    // Add song to play next
    public void addToQueue(Song song) {
        playingStrategy.addToQueue(song);
    }
}
