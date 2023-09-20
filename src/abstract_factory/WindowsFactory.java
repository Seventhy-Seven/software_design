package abstract_factory;


// Конкретная реализация фабрики для Windows
public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
