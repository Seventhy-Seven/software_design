package bridge;

// Реализация конкретного пульта управления для телевизора
public class TVRemote extends Remote{

    public TVRemote(Device device) {
        super(device);
    }

    public void nextChannel() {
        device.setChannel(device.getChannel() + 1);
    }

    public void prevChannel() {
        device.setChannel(device.getChannel() - 1);
    }
}
