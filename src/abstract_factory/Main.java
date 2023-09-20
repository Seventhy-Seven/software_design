package abstract_factory;

public class Main {
    public static void main(String[] args) {

        // создаем фабрику для Windows
        GUIFactory windowsFactory = new WindowsFactory();

        // создаем приложение с помощью фабрики для Windows
        AbstractFactory abstractFactory = new AbstractFactory(windowsFactory);

        // создаем пользовательский интерфейс
        abstractFactory.createUI();

        // рисуем кнопку
        abstractFactory.paint();
    }
}
