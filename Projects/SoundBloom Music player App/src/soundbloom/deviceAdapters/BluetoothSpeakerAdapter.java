package soundbloom.deviceAdapters;

import soundbloom.external.BluetoothSpeakerAPI;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice {

    private final BluetoothSpeakerAPI bluetoothSpeakerAPI;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI bluetoothSpeakerAPI) {
        this.bluetoothSpeakerAPI = bluetoothSpeakerAPI;
    }

    @Override
    public String playAudio() {
        return bluetoothSpeakerAPI.playBluetoothSpeaker();
    }

    @Override
    public String pauseAudio() {
        return bluetoothSpeakerAPI.pauseBluetoothSpeaker();
    }
}
