package com.mystical_samurai;

import java.util.Random;
import java.util.Scanner;

import com.mystical_samurai.brute_force.*;
import com.mystical_samurai.aco.AntColonyOptimization;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        bruteForce();
        System.out.println("");
        aco();
        scanner.close();
    }
    
    private static void bruteForce() {
        System.out.println("BRUTE FORCE ALGORITHM");
        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();
		TravelingSalesman salesman = new TravelingSalesman(nodes, random);
        salesman.printCosts();
        TravelingSalesmanBruteForce bruteForce = new TravelingSalesmanBruteForce(salesman);
        long startTime = System.nanoTime();
        bruteForce.run();
        long endTime = System.nanoTime();
        double totalTimeSeconds = (double) (endTime - startTime) / 1000000000;
        System.out.print("\nRuntime: " + totalTimeSeconds);
    }
    
    private static void aco() {
        System.out.println("ACO ALGORITHM");
        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();
        AntColonyOptimization antColony = new AntColonyOptimization(nodes);
        long startTime = System.nanoTime();
        antColony.startAntOptimization();
        long endTime = System.nanoTime();
        double totalTimeSeconds = (double) (endTime - startTime) / 1000000000;
        System.out.println("\nRuntime: " + totalTimeSeconds);
    }
}
