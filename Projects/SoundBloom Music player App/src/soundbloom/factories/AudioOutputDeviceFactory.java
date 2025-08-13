package soundbloom.factories;

import soundbloom.deviceAdapters.BluetoothSpeakerAdapter;
import soundbloom.deviceAdapters.HeadphoneAdapter;
import soundbloom.deviceAdapters.IAudioOutputDevice;
import soundbloom.deviceAdapters.WiredSpeakerAdapter;
import soundbloom.enums.DeviceType;
import soundbloom.external.BluetoothSpeakerAPI;
import soundbloom.external.HeadphoneAPI;
import soundbloom.external.WiredSpeakerAPI;

public class AudioOutputDeviceFactory {

    public static IAudioOutputDevice createDevice(DeviceType deviceType) {
        IAudioOutputDevice obj = null;

        switch (deviceType) {
            case BLUETOOTH -> obj = new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED -> obj = new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONE -> obj = new HeadphoneAdapter(new HeadphoneAPI());
        }

        return obj;
    }
}
