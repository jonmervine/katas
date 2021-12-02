package com.darkmage530.adventOfCode.y2020;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.darkmage530.adventOfCode.Utilities;

public class Day6 {

    public static void main(String[] args) {
        Day6 day6 = new Day6();

        List<String> inputFromFile = Utilities.getStringFromFile("2020/day6input.txt");
        List<Set<Character>> allAnswers = day6.parseAndCombineAnswers(inputFromFile);
        int count = 0;
        for (Set<Character> groupsAnswers : allAnswers) {
            count = count + groupsAnswers.size();
        }
        System.out.println(count);
    }

    private List<Set<Character>> parseAndCombineAnswers(List<String> inputFromFile) {
        List<Set<Character>> allGroupAnswers = Lists.newArrayList();
        List<Set<Character>> groupAnswers = Lists.newArrayList();
        for (String line : inputFromFile) {

            if (line.isEmpty()) {
                Set<Character> groupsAgreedAnswers = Sets.newHashSet(groupAnswers.get(0));
                for (Set<Character> personAnswers : groupAnswers) {
                    groupsAgreedAnswers.retainAll(personAnswers);
                }

                allGroupAnswers.add(groupsAgreedAnswers);
                groupAnswers = Lists.newArrayList();
                continue;
            }

            groupAnswers.add(line.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
        }
        return allGroupAnswers;
    }
}
