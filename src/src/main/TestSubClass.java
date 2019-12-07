package src.main;

import src.main.Injector.Inject;
import src.main.Injector.Injectable;

@Injectable
public class TestSubClass implements ITestSubClass {

    @Inject
    private TestSubSubClass _testSubSubClass;

    public TestSubClass() {}

    public void helloWorldFromSub() {
        System.out.println("Hello World from Injected Subclass!!!");
        _testSubSubClass.call(3);
        System.out.println("Times called from " + this.getClass().getName() + ": " + _testSubSubClass.getTimesCalled());
    }
}
