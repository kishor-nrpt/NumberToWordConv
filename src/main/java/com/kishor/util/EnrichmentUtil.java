package com.kishor.util;

public class EnrichmentUtil {
    private static final String WORD_HUNDRED = "Hundred";
    private static final String WORD_AND = "And";
    private static final String SPACE = " ";

    public static String insertAndPrefix(String finalOutput) {
        System.out.println("Enriching the output: " + finalOutput);
        String output = finalOutput;
        output = output.replaceAll(WORD_HUNDRED, WORD_HUNDRED + SPACE + WORD_AND);
        output = output.endsWith(" And") ? output.substring(0, output.length() -4) : output;
        System.out.println("Enriched output : " + output);
        return output.toLowerCase();
    }
}
