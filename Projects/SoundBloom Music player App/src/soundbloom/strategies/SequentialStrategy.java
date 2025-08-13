package soundbloom.strategies;

import soundbloom.models.PlayList;
import soundbloom.models.Song;

public class SequentialStrategy implements IPlayingStrategy {
    private PlayList playList;
    private Integer idx;

    // constructor
    public SequentialStrategy() {
        this.playList = null;
        this.idx = -1;
    }

    @Override
    public void setPlayList(PlayList playList) {
        this.playList = playList;
        this.idx = -1;
    }

    @Override
    public Boolean hasNext() {
        return idx < playList.getSize() - 1;
    }

    @Override
    public Boolean hasPrevious() {
        return idx > 0;
    }

    @Override
    public Song next() {
        if (playList == null || playList.getSize() == 0) {
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }

        this.idx++;

        return playList.getSongs().get(idx);
    }

    @Override
    public Song previous() {
        if (playList == null || playList.getSize() == 0) {
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }

        this.idx--;

        return playList.getSongs().get(idx);
    }
}