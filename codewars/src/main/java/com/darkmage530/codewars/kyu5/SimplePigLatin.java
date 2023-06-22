package com.darkmage530.codewars.kyu5;

public class SimplePigLatin {

    private static final String PIG_LATIN_SUFFIX = "ay";

    public static void main(String[] args) {
        SimplePigLatin spl = new SimplePigLatin();
        String result = spl.translateToPigLatin("Hello World !");
        System.out.println(result);
        result = spl.translateToPigLatin("Pig latin is cool");
        System.out.println(result);
    }

    public String translateToPigLatin(String initialText) {
        String[] words = initialText.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String suffixedWord = word;
            if (!word.matches("\\W")) {
                String rearrangedWord = word;
                if (word.length() > 1) {
                    rearrangedWord = rearrangeWord(word);
                }

                suffixedWord = addSuffix(rearrangedWord);
            }
            sb.append(suffixedWord);
            sb.append(" ");

        }
        return sb.toString().trim();
    }

    private String rearrangeWord(String word) {
        String firstChar = word.substring(0, 1);
        return word.substring(1) + firstChar;
    }

    private String addSuffix(String rearrangedWord) {
        return rearrangedWord + PIG_LATIN_SUFFIX;
    }
}
