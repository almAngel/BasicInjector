package src.main;

import src.main.Injector.Inject;
import src.main.Injector.InjectorBehaviorImpl;

import java.io.Serializable;

public class Main {

    @Inject(type = TestClass.class)
    private static ITestClass _testClass;

    public static void main(String[] args) {
        // FIND DEPENDENCIES & INJECT
        try {
            InjectorBehaviorImpl.findAllInjectables("src.main");
            InjectorBehaviorImpl.findAndInject("src.main");

            //INVOKE INJECTED CLASS' METHOD
            _testClass.helloWorld();
        }
        catch (InstantiationException ie) {}
        catch (IllegalAccessException iae) {}
    }
}
