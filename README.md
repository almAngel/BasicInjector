# BasicInjector
Basic Dependencies Injector made in Java

**@Injectable** - Class annotation for registering a class instance inside our container.
**@Inject** - Class field annotation for injecting class instance.

```Java
public class Main {

    @Inject
    static TestClass tc;
    @Inject
    static PyramidPrinter pp;

    public static void main(String ...args) {
        // FIND DEPENDENCIES & INJECT
        try {
            InjectorBehaviorImpl.findAllInjectables(Main.class.getPackage().getName()); //Scan Injectables
            InjectorBehaviorImpl.findAndInject(Main.class.getPackage().getName()); //Scan Injects, then inject dependencies

            tc.helloWorld();

            pp.printGivenHeight(6, "□");
        }
        catch (IllegalArgumentException | IllegalAccessException | InstantiationException ie) {
            ie.printStackTrace();
        }
    }

}
```
### How should you annotate your class
```Java
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

```
