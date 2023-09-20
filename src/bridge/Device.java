package bridge;

// Реализация интерфейса устройства
public interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
    int getChannel();
}
