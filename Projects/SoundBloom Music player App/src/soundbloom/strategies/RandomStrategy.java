package soundbloom.strategies;

import soundbloom.models.PlayList;
import soundbloom.models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RandomStrategy implements IPlayingStrategy {

    private PlayList playList;
    private Random random;
    private Stack<Song> history;
    private List<Song> remainingSongs;

    @Override
    public void setPlayList(PlayList playList) {
        this.playList = playList;
        this.random = new Random();
        this.history = new Stack<>();
        this.remainingSongs = new ArrayList<>(playList.getSongs());
    }

    @Override
    public Song next() {

        if (playList == null || playList.getSize() == 0) {
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }

        if (remainingSongs.isEmpty()) {
            throw new RuntimeException("no song left");
        }

        int size = remainingSongs.size();
        int idx = random.nextInt(size);
        Song song = remainingSongs.get(idx);

        // removing by swapping on O(1)
        remainingSongs.set(idx, remainingSongs.get(size - 1));
        remainingSongs.remove(size - 1);

        history.push(song);

        return song;
    }

    @Override
    public Song previous() {

        if (playList == null || playList.getSize() == 0) {
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }

        if (history.isEmpty()) {
            throw new RuntimeException("no song left");
        }

        return history.pop();
    }

    @Override
    public Boolean hasNext() {
        return (playList != null) && !remainingSongs.isEmpty();
    }

    @Override
    public Boolean hasPrevious() {
        return (playList != null) && !history.isEmpty();
    }
}