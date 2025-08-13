package soundbloom.strategies;

import soundbloom.models.PlayList;
import soundbloom.models.Song;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CustomStrategy implements IPlayingStrategy {

    private PlayList playList;
    private Stack<Integer> history;
    private Queue<Integer> queue;
    private Integer currentIdx;

    @Override
    public void setPlayList(PlayList playList) {
        this.playList = playList;
        this.history = new Stack<>();
        this.queue = new LinkedList<>();
        this.currentIdx = -1;
    }

    // methods
    private Song sequentialNext() {
        currentIdx++;
        Song song = playList.getSongs().get(currentIdx);
        history.push(currentIdx);

        return song;
    }

    @Override
    public Song next() {

        if (playList == null || playList.getSize() == 0) {
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }

        if (queue.isEmpty()) {
            return sequentialNext();
        }

        currentIdx = queue.poll();
        history.push(currentIdx);

        return playList.getSongs().get(currentIdx);
    }

    @Override
    public Song previous() {

        if (playList == null || playList.getSize() == 0) {
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }

        if (history.isEmpty()) {
            throw new RuntimeException("No song left");
        }

        currentIdx = history.pop();

        return playList.getSongs().get(currentIdx);
    }

    @Override
    public Boolean hasNext() {
        return !queue.isEmpty() || (currentIdx + 1 < playList.getSize());
    }

    @Override
    public Boolean hasPrevious() {
        return !history.isEmpty();
    }

    @Override
    public void addToQueue(Song song) {
        for (int i = 0; i < playList.getSize(); i++) {
            Song s = playList.getSongs().get(i);
            if (s.getName().equals(song.getName())) {
                queue.add(i);
                break;
            }
        }
    }
}
