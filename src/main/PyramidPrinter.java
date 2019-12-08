package main;

import main.Injector.Injectable;

@Injectable
public class PyramidPrinter {

    public void printGivenHeight(int height, String ch) {
        int aux1 = height;
        int aux2 = 1;
        for (int j = 0; j <= aux1; j++) {
            System.out.print(" ");
        }
        System.out.println(ch);

        for(int i = 0; i < height-1; i++) {
            for (int j = 0; j < aux1; j++) {
                System.out.print(" ");
            }
            aux1--;

            for (int j = 0; j <= aux2; j++) {
                System.out.print(ch);
            }
            for (int j = 0; j < aux2; j++) {
                System.out.print(ch);
            }
            aux2++;
            System.out.println();

        }

    }
}
