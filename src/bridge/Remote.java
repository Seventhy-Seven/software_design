package bridge;

// Реализация абстракции пульта управления
abstract class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (device instanceof TV) {
            TV tv = (TV) device;
            if (tv.on) {
                tv.turnOff();
            } else {
                tv.turnOn();
            }
        } else {
            System.out.println("Can't turn on/off unknown device");
        }
    }

    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    public int getChannel() {
        return device.getChannel();
    }
}
