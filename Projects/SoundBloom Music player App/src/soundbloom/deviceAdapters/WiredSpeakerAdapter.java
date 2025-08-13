package soundbloom.deviceAdapters;

import soundbloom.external.WiredSpeakerAPI;

public class WiredSpeakerAdapter implements IAudioOutputDevice {

    private final WiredSpeakerAPI wiredSpeakerAPI;

    public WiredSpeakerAdapter(WiredSpeakerAPI wiredSpeakerAPI) {
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    @Override
    public String playAudio() {
        return wiredSpeakerAPI.playWiredSpeaker();
    }

    @Override
    public String pauseAudio() {
        return wiredSpeakerAPI.pauseWiredSpeaker();
    }
}