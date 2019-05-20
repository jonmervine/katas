package com.darkmage530.codewars.kyu5;

import java.util.LinkedList;
import java.util.List;

public class WeightForWeight {

    public static void main(String[] args) {
        System.out.println(orderWeight("56 65 74 100 99 68 86 180 90"));
    }

    public static String orderWeight(String strng) {
        WeightForWeight weightForWeight = new WeightForWeight();
        return weightForWeight.convertAndOrderWeights(strng);
    }

    public String convertAndOrderWeights(String strng) {
        String[] s = strng.split(" ");
        List<Weights> weights = new LinkedList<>();
        for (String weight : s) {
            String convertedWeight = convertWeightToWeight(weight);
            weights.add(new Weights(weight, convertedWeight));
        }

        sortWeights(weights);

        StringBuilder sb = new StringBuilder();
        for (Weights weight : weights) {
            sb.append(weight.originalWeight).append(" ");
        }

        return sb.toString().trim();
    }

    public String convertWeightToWeight(String weight) {
        int digitSum = 0;
        for (char digit : weight.toCharArray()) {
            if (Character.isDigit(digit)) {
                digitSum = digitSum + Character.getNumericValue(digit);
            }
        }

        return String.valueOf(digitSum);
    }

    public List<Weights> sortWeights(List<Weights> weights) {
        weights.sort(Weights::compareTo);
        return weights;
    }

    private class Weights implements Comparable {
        String originalWeight;
        String convertedWeight;

        public Weights(String originalWeight, String convertedWeight) {
            this.originalWeight = originalWeight;
            this.convertedWeight = convertedWeight;
        }

        public String getOriginalWeight() {
            return originalWeight;
        }

        public int getConvertedWeightNum() {
            return Integer.parseInt(convertedWeight);
        }


        @Override
        public int compareTo(Object o) {
            Weights compared = (Weights) o;
            if (getConvertedWeightNum() == compared.getConvertedWeightNum()) {
                return getOriginalWeight().compareToIgnoreCase(compared.getOriginalWeight());
            }
            return Integer.compare(getConvertedWeightNum(), compared.getConvertedWeightNum());
        }
    }
}