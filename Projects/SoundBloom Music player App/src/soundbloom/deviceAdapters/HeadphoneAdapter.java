package soundbloom.deviceAdapters;

import soundbloom.external.HeadphoneAPI;

public class HeadphoneAdapter implements IAudioOutputDevice {

    private final HeadphoneAPI headphoneAPI;

    public HeadphoneAdapter(HeadphoneAPI headphoneAPI) {
        this.headphoneAPI = headphoneAPI;
    }

    @Override
    public String playAudio() {
        return headphoneAPI.playHeadphone();
    }

    @Override
    public String pauseAudio() {
        return headphoneAPI.pauseHeadphone();
    }
}