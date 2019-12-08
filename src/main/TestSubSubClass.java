package main;

import main.Injector.Injectable;

@Injectable
public class TestSubSubClass implements ITestSubSubClass {

    int timesCalled = 0;

    @Override
    public void call(int times) {
        for (int i = 0; i < times; i++) {
            this.timesCalled++;
        }
    }

    @Override
    public int getTimesCalled() {
        return timesCalled;
    }
}
