package soundbloom.managers;

import soundbloom.enums.StrategyType;
import soundbloom.strategies.CustomStrategy;
import soundbloom.strategies.IPlayingStrategy;
import soundbloom.strategies.RandomStrategy;
import soundbloom.strategies.SequentialStrategy;

public class StrategyManager {
    private static volatile StrategyManager instance;

    private final SequentialStrategy sequentialStrategy;
    private final CustomStrategy customStrategy;
    private final RandomStrategy randomStrategy;

    // constructor
    public StrategyManager() {
        sequentialStrategy = new SequentialStrategy();
        customStrategy = new CustomStrategy();
        randomStrategy = new RandomStrategy();
    }

    public static StrategyManager getInstance() {
        if (instance == null) {
            synchronized (StrategyManager.class) {
                if (instance == null) {
                    instance = new StrategyManager();
                }
            }
        }

        return instance;
    }

    // methods
    public IPlayingStrategy getPlayingStrategy(StrategyType strategyType) {
        IPlayingStrategy strategy = null;

        switch (strategyType) {
            case SEQUENCE -> strategy = sequentialStrategy;
            case RANDOM -> strategy = randomStrategy;
            case CUSTOM -> strategy = customStrategy;
        }

        return strategy;
    }
}