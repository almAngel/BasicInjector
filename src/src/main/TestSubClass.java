package src.main;

public class TestSubClass implements ITestSubClass {

    public TestSubClass() {}

    public void helloWorldFromSub() {
        System.out.println("Hello World from Injected Subclass!!!");
    }
}
