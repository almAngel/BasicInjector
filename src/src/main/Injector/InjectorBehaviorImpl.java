package src.main.Injector;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Set;

public class InjectorBehaviorImpl {

    public static void findAndInject(String inPath) throws IllegalAccessException {
        Reflections reflections = new Reflections(inPath, new FieldAnnotationsScanner());

        Set<Field> annotated = reflections.getFieldsAnnotatedWith(Inject.class);

        for (Field field : annotated) {
            while (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.isAccessible()) {
                field.set(field, new Injector().get(field.getAnnotation(Inject.class).type()));
            }
        }
    }

    public static void findAllInjectables(String inPath) throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections(inPath);

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Injectable.class);

        for (Class<?> clazz : annotated) {
            new Injector().tie(clazz.newInstance()).with(clazz).make();
        }
    }

}