package soundbloom.core;

import soundbloom.deviceAdapters.IAudioOutputDevice;
import soundbloom.models.Song;

public class AudioEngine {
    private Song song;
    private Boolean playing = false;
    private IAudioOutputDevice device;

    // methods

    public Song getCurrentSong() {
        return this.song;
    }

    public void play(Song song, IAudioOutputDevice device) {
        this.song = song;
        this.device = device;
        playing = true;
        System.out.println(device.playAudio() + song.getName());
    }

    public void pause() {
        if (playing) {
            playing = false;
            System.out.println(device.pauseAudio() + song.getName());
        }
    }
}
