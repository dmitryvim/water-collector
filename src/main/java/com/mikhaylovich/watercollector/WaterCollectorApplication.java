package com.mikhaylovich.watercollector;

import java.util.Scanner;

/**
 * @author dmitry.mikhailovich@gmail.com
 */
public class WaterCollectorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input heights count and then input heights:");
        int count = scanner.nextInt();
        LandscapeWalker walker = new LandscapeWalker();
        for (int index = 0; index < count; index++) {
            walker.addHeight(scanner.nextInt());
        }
        System.out.println("Amount of collected water: " + walker.getWaterCount());
    }
}
