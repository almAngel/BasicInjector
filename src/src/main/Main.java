package src.main;

import src.main.Injector.Inject;
import src.main.Injector.Injector;
import src.main.Injector.InjectorBehaviorImpl;

public class Main {

    public static void main(String ...args) {
        // FIND DEPENDENCIES & INJECT
        try {
            InjectorBehaviorImpl.findAllInjectables("src.main");
            InjectorBehaviorImpl.findAndInject("src.main");

            TestClass tc = (TestClass) new Injector().get(TestClass.class);
            tc.helloWorld();
        }
        catch (IllegalArgumentException | IllegalAccessException | InstantiationException ie) {
            ie.printStackTrace();
        }
    }

}
