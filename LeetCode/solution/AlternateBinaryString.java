package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/solutions/4452917/red-flag-for-them-who-are-looking-for-solution/
 * @author Akash Prajapati
 *
 */
public class App 
{
    public static int minOperations(String s) {
        AtomicInteger num0 = new AtomicInteger();
        AtomicInteger num1 = new AtomicInteger();
        AtomicBoolean isBinary = new AtomicBoolean(true);
        if(!s.isEmpty() && s.length()<=10000) {
            // for zero
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i)=='0' || s.charAt(i)=='1') {
                        if (i % 2 == 0) {
                            if (s.charAt(i) == '1') {
                                num0.set(num0.get() + 1);
                            }
                        } else {
                            if (s.charAt(i) == '0') {
                                num0.set(num0.get() + 1);
                            }
                        }
                        if (num0.get() > s.length() / 2) {
                            num0.set(Integer.MAX_VALUE);
                            break;
                        }
                    }
                    else {
                        isBinary.set(false);
                        break;
                    }
                }
            }, "t1");

            // for one
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i)=='0' || s.charAt(i)=='1') {
                        if (i % 2 == 0) {
                            if (s.charAt(i) == '0') {
                                num1.set(num1.get() + 1);
                            }
                        } else {
                            if (s.charAt(i) == '1') {
                                num1.set(num1.get() + 1);
                            }
                        }
                        if (num1.get() > s.length() / 2) {
                            num1.set(Integer.MAX_VALUE);
                            break;
                        }
                    }
                    else {
                        isBinary.set(false);
                        break;
                    }
                }
            }, "t2");
            try {
                t1.start();
                t2.start();

                t1.join();
                t2.join();
            } catch (InterruptedException ie) {
                System.out.println("InterruptedException thrown");
            }
        }
        else if (!isBinary.get())
            throw new InputMismatchException();
        else
            throw new RuntimeException();
        return Math.min(num0.get(), num1.get());
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter binary string");
        String s = scan.next();

        System.out.println("required changes: " + minOperations(s));
    }
}
