package abstract_factory;

// Конкретная реализация фабрики для MacOS
public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}
