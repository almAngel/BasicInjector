package main;

import main.Injector.Inject;
import main.Injector.InjectorBehaviorImpl;

public class Main {

    @Inject
    static TestClass tc;
    @Inject
    static PyramidPrinter pp;

    public static void main(String ...args) {
        // FIND DEPENDENCIES & INJECT
        try {
            InjectorBehaviorImpl.findAllInjectables(Main.class.getPackage().getName());
            InjectorBehaviorImpl.findAndInject(Main.class.getPackage().getName());

            tc.helloWorld();

            pp.printGivenHeight(5, "□");
        }
        catch (IllegalArgumentException | IllegalAccessException | InstantiationException ie) {
            ie.printStackTrace();
        }
    }

}
