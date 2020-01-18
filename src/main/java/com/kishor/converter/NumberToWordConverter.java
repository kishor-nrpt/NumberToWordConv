package com.kishor.converter;

import com.kishor.pojo.ScaleLimits;
import com.kishor.util.EnrichmentUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberToWordConverter {

    private static final Map<Integer, ScaleLimits<Integer, String>> COMPLEX_SCALE = createComplexScaleMap();
    private static final Map<Integer, String> SIMPLE_SCALE = createSimpleScaleMap();
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";
    private static final Integer SIMPLE_NBR_LIMIT = 100;

    private static Map<Integer, ScaleLimits<Integer, String>> createComplexScaleMap() {
        Map<Integer, ScaleLimits<Integer, String>> decimalScales = new HashMap<Integer, ScaleLimits<Integer, String>>();
        decimalScales.put(100, new ScaleLimits<Integer, String>(100, 1000, "Hundred"));
        decimalScales.put(1000, new ScaleLimits<Integer, String>(1000, 1000000, "Thousand"));
        decimalScales.put(1000000, new ScaleLimits<Integer, String>(1000000, 1000000000, "Million"));
        return Collections.unmodifiableMap(decimalScales);
    }

    private static Map<Integer, String> createSimpleScaleMap() {
        Map<Integer, String> scales = new HashMap<Integer, String>();
        scales.put(0, "Zero");
        scales.put(1, "One");
        scales.put(2, "Two");
        scales.put(3, "Three");
        scales.put(4, "Four");
        scales.put(5, "Five");
        scales.put(6, "Six");
        scales.put(7, "Seven");
        scales.put(8, "Eight");
        scales.put(9, "Nine");
        scales.put(10, "Ten");
        scales.put(11, "Eleven");
        scales.put(12, "Twelve");
        scales.put(13, "Thirteen");
        scales.put(14, "Fourteen");
        scales.put(15, "Fifteen");
        scales.put(16, "Sixteen");
        scales.put(17, "Seventeen");
        scales.put(18, "Eighteen");
        scales.put(19, "Nineteen");
        scales.put(20, "Twenty");
        scales.put(30, "Thirty");
        scales.put(40, "Forty");
        scales.put(50, "Fifty");
        scales.put(60, "Sixty");
        scales.put(70, "Seventy");
        scales.put(80, "Eighty");
        scales.put(90, "Ninety");
        return Collections.unmodifiableMap(scales);
    }

    public String convertAndEnrichOutput(Integer aNumberToConvertAndEnrich) {
        if (aNumberToConvertAndEnrich == null) {
            return "";
        }
        return EnrichmentUtil.enrich(covert(aNumberToConvertAndEnrich));
    }

    private String covert(Integer aNumberToConvert) {
        return (aNumberToConvert < SIMPLE_NBR_LIMIT ? convertSimpleNumbers(aNumberToConvert) : convertComplexNumbers(
            aNumberToConvert));
    }

    private String convertSimpleNumbers(Integer simpleNumber) {
        if (SIMPLE_SCALE.get(simpleNumber) != null) {
            return SIMPLE_SCALE.get(simpleNumber);
        }
        int remainder = simpleNumber % 10;
        return (SIMPLE_SCALE.get(simpleNumber - remainder) + SPACE + covert(simpleNumber % 10));
    }

    private String convertComplexNumbers(Integer complexNumber) {
        if (COMPLEX_SCALE.get(complexNumber) != null) {
            return COMPLEX_SCALE.get(complexNumber).getDescription();
        }
        StringBuilder output = new StringBuilder(EMPTY_STRING);
        for (Map.Entry<Integer, ScaleLimits<Integer, String>> entry : COMPLEX_SCALE.entrySet()) {
            output.append(mapDecimalPosToDescriptions(entry, complexNumber));
        }
        return output.toString().trim();
    }

    private String mapDecimalPosToDescriptions(Map.Entry<Integer, ScaleLimits<Integer, String>> entry, Integer complexNumber) {
        int remainder = complexNumber % entry.getKey();
        int roundOffNbr = complexNumber - remainder;
        if (!(complexNumber > entry.getKey()) || !(entry.getValue().getHigh() != null && roundOffNbr < entry.getValue().getHigh())) {
            return EMPTY_STRING;
        }
        //Trailing zeros need not to be converted, restricting here
        String reminderConversionOutput = remainder > 0 ? covert(remainder) : EMPTY_STRING;
        return (
            covert(
                roundOffNbr / entry.getKey()) +
                SPACE +
                entry.getValue().getDescription() +
                SPACE +
                reminderConversionOutput
        );
    }
}

