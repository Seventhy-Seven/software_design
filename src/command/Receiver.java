package command;

// Определение класса, методы которого будут вызываться с помощью Команды
public class Receiver {
    public void startAction() {
        System.out.println("Start Action");
    }

    public void stopAction() {
        System.out.println("Stop Action");
    }
}
