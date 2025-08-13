package soundbloom.managers;

import soundbloom.deviceAdapters.IAudioOutputDevice;
import soundbloom.enums.DeviceType;
import soundbloom.factories.AudioOutputDeviceFactory;

public class DeviceManager {
    private IAudioOutputDevice audioOutputDevice;
    private static volatile DeviceManager instance;

    // constructor
    private DeviceManager() {
    }

    // methods
    public static DeviceManager getInstance() {
        if (instance == null) {
            synchronized (DeviceManager.class) {
                if (instance == null) {
                    instance = new DeviceManager();
                }
            }
        }

        return instance;
    }

    public void connectDevice(DeviceType deviceType) {
        audioOutputDevice = AudioOutputDeviceFactory.createDevice(deviceType);
    }

    public IAudioOutputDevice getAudioOutputDevice() {
        if (this.audioOutputDevice != null) return this.audioOutputDevice;
        throw new RuntimeException("Audio Device not found");
    }
}
