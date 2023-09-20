package bridge;

public class Main {

    public static void main(String[] args) {
        TV tv = new TV();
        Remote remote = new TVRemote(tv);

        remote.togglePower();
        remote.setChannel(3);
        ((TVRemote) remote).nextChannel();
        ((TVRemote) remote).prevChannel();
        remote.getChannel();
        remote.togglePower();

    }
}
