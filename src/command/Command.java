package command;

// Интерфейс Команды
public interface Command {
    void execute();
    void undo();
}
