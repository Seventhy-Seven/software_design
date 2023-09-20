package abstract_factory;

// Класс, который будет использовать фабрику для создания объектов
public class AbstractFactory {
    private GUIFactory guiFactory;
    private Button button;

    public AbstractFactory(GUIFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    public void createUI() {
        button = guiFactory.createButton();
    }

    public void paint() {
        button.paint();
    }

}
