package bridge;


// Реализация конкретного устройства - телевизора
public class TV implements Device{
    boolean on = false;
    private int channel = 1;

    @Override
    public void turnOn() {
        System.out.println("TV is turned on");
        on = true;
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off");
        on = false;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Channel is set to " + channel);
    }

    @Override
    public int getChannel() {
        System.out.println("Channel is " + channel);
        return channel;
    }
}
