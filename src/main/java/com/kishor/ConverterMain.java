package com.kishor;

import com.kishor.converter.NumberToWordConverter;
import com.kishor.validator.InputValidator;

public class ConverterMain {

    public static void main(String[] args) {
        System.out.println("NumberToWordConverter Application is running ...");
        NumberToWordConverter numberToWordConverter = new NumberToWordConverter();
        InputValidator validator = new InputValidator();
        // Input Validation
        Integer aValidInput = validator.validateInputs(args);
        System.out.println("Input Validation completed ...");
        // Converting Input number into words goes below
        String finalOutput = numberToWordConverter.convertAndEnrichOutput(aValidInput);
        // Final response
        System.out.println("Converted output is: " + finalOutput);
    }

}
