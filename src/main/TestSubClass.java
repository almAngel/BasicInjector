package main;

import main.Injector.Inject;
import main.Injector.Injectable;

@Injectable
public class TestSubClass implements ITestSubClass {

    @Inject
    private TestSubSubClass _testSubSubClass;

    @Override
    public void helloWorldFromSub() {
        System.out.println("Hello World from Injected Subclass!!!");
        _testSubSubClass.call(3);
        System.out.println("Times called from " + this.getClass().getName() + ": " + _testSubSubClass.getTimesCalled());
    }
}
