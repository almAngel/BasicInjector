package main;

import main.Injector.Inject;
import main.Injector.Injectable;

@Injectable
public class TestClass implements ITestClass {

    @Inject
    private TestSubClass _testSubClass;
    @Inject
    private TestSubSubClass _testSubSubClass;

    @Override
    public void helloWorld() {
        System.out.println("Hello World from Injector!!!!");
        _testSubSubClass.call(7);
        System.out.println("Times called from " + this.getClass().getName() + ": " + _testSubSubClass.getTimesCalled());
        _testSubClass.helloWorldFromSub();
    }
}
