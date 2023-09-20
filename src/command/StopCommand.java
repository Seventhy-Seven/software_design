package command;

// Реализация конкретной команды
public class StopCommand  implements Command{
    private Receiver receiver;

    public StopCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.stopAction();
    }

    @Override
    public void undo() {
        receiver.startAction();
    }
}
