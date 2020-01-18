package com.kishor.validator;

import java.util.Scanner;

public class InputValidator {
    public Integer validateInputs(String[] args) {
        Integer firstArg = null;
        try {
            if (args.length > 0) {
                firstArg = Integer.parseInt(args[0]);
            }
            else {
                System.out.println("Enter number of your choice ...");
                Scanner in = new Scanner(System.in);
                firstArg = in.nextInt();
                System.out.println("You entered integer " + firstArg);
            }
        }
        catch (Exception ex) {
            System.err.println("Input must be an integer.");
            System.exit(1);
        }
        return firstArg;
    }
}
