package command;

public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command startCommand = new StartCommand(receiver);
        Command stopCommand = new StopCommand(receiver);
        Invoker invoker = new Invoker();

        // Исполнение команд
        invoker.setCommand(startCommand);
        invoker.executeCommand();
        invoker.setCommand(stopCommand);
        invoker.executeCommand();

        // Отмена последней выполенной команды
        invoker.undoCommand();
    }
}
