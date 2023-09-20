package command;

// Реализация конкретной команды
public class StartCommand  implements Command{

    private Receiver receiver;

    public StartCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.startAction();
    }

    @Override
    public void undo() {
        receiver.stopAction();
    }
}
