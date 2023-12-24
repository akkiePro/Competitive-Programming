package org.example;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-stdin-stdout/problem?isFullScreen=true
 * @author Akash Prajapati
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter int");
        int i = scan.nextInt();

        System.out.println("Enter double");
        double d = scan.nextDouble();
        scan.nextLine();

        System.out.println("Enter String");
        String s = scan.nextLine();

        // Write your code here.
        System.out.println("########## O/P ###########");
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
