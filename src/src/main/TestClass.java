package src.main;

import src.main.Injector.Inject;
import src.main.Injector.Injectable;
import src.main.Injector.Injector;

import java.io.Serializable;

@Injectable
public class TestClass implements ITestClass {

    @Inject
    TestSubClass _testSubClass;
    @Inject
    TestSubSubClass _testSubSubClass;

    // PUBLIC CONSTRUCTOR REQUIRED
    public TestClass() {}

    public void helloWorld() {
        System.out.println("Hello World from Injector!!!!");
        _testSubSubClass.call(7);
        System.out.println("Times called from " + this.getClass().getName() + ": " + _testSubSubClass.getTimesCalled());
        _testSubClass.helloWorldFromSub();
    }
}
