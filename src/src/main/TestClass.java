package src.main;

import src.main.Injector.Inject;
import src.main.Injector.Injectable;

import java.io.Serializable;

@Injectable
public class TestClass implements ITestClass {

    @Inject(type = TestSubClass.class)
    private static ITestSubClass _testSubClass;

    // PUBLIC CONSTRUCTOR REQUIRED
    public TestClass() {}

    public void helloWorld() {
        System.out.println("Hello World from Injector!!!!");
        _testSubClass.helloWorldFromSub();
    }
}
