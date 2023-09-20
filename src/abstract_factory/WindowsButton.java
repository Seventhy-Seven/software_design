package abstract_factory;

// Конкретная реализация кнопки для Windows
public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Button for Windows");
    }
}
