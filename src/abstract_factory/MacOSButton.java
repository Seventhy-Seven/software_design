package abstract_factory;

// Конкретная реализация кнопки для MacOS
public class MacOSButton implements Button{
    @Override
    public void paint() {
        System.out.println("Button for MacOS");
    }
}
