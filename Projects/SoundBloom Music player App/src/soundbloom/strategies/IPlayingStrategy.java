package soundbloom.strategies;

import soundbloom.models.PlayList;
import soundbloom.models.Song;

public interface IPlayingStrategy {
    void setPlayList(PlayList playList);
    Song next();
    Song previous();
    Boolean hasNext();
    Boolean hasPrevious();
    default void addToQueue(Song song){}
}