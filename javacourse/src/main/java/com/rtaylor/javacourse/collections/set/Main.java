package com.rtaylor.javacourse.collections.set;

import java.util.*;

/*
Lessons:
#1 - Create an immutable Set
#2 - Set can only have unique elements - no duplication. Exception: IllegalArgumentException
#3 - Set has no index. Print result can result in any order.
#4 - Set is immutable; addition or removal are prohibited. For mutable set, use HashSet, LinkedHashSet, or TreeSet
#5 - Set does not allow duplication; result = false.
#6 - Create a mutable set - HashSet
#7 - HashSet doesn't care about order. Print result can be in any order.
#8 - HashSet can only have unique elements - no duplication. Non-unique addition is ignored; result = false.
#9 - Create a mutable set - LinkedHashSet
#10 - LinkedHashSet elements are stored in order they're created. Note: just like Set, no index accessible.
#11 - HashSet can only have unique elements - no duplication. Non-unique addition is ignored; result = false.
#12 - Create a TreeSet
#13 - TreeSet elements are stored in their 'natural ordering' order automatically. See what 'natural ordering' for
      a class is in Comparable interface documentation.
#14 - TreeSet can only have unique elements - no duplication. Non-unique addition is ignored; result = false.
#15 - Create a unique character collection in natural ordering from a list. Note: TreeSet or HashSet constructor
      can take a Collection as the argument.
#16 - Create a unique character collection in order of assignment from a list. Note: LinkedHashSet constructor
      can take a Collection as the argument.
 */

public class Main {
    public static void main(String[] args) {
//        new SetTrial().execute();
//        new SetTrial().hashSetExecute();
//        new SetTrial().linkedHashSetExecute();
//        new SetTrial().treeSetExecute();

        new SetTrial().exerciseUniqueCharacterInNaturalOrdering(List.of('A', 'Z', 'A', 'B', 'Z', 'F'));
        new SetTrial().exerciseUniqueCharacterInOrderOfAssignment(List.of('A', 'Z', 'A', 'B', 'Z', 'F'));
    }
}

class SetTrial {
    public void execute() {
        Set<String> set = Set.of("Apple", "Orange", "Avocado", "Durian", "Mango", "Guava"); // #1
//        Set<String> set = Set.of("Apple", "Orange", "Avocado", "Durian", "Mango", "Guava", "Orange"); // #2
        System.out.println(set); // #3
//        mySet.add("Not allowed! IMMUTABLE!"); // #4

        // Create a HashSet instance
        set = new HashSet<>(set);
        System.out.println(set);
        boolean result = set.add("Orange"); // #5
        System.out.println(result);
    }

    public void hashSetExecute() {
        Set<Integer> hashSet = new HashSet<>(); // #6
        hashSet.add(1);
        hashSet.add(21);
        hashSet.add(33);
        hashSet.add(42);
        hashSet.add(59);
        System.out.println(hashSet); // #7

        System.out.println(hashSet.add(1)); // #8
        System.out.println(hashSet);
    }

    public void linkedHashSetExecute() {
        Set<Integer> linkedHashSet = new LinkedHashSet<>(); // #9
        linkedHashSet.add(1);
        linkedHashSet.add(21);
        linkedHashSet.add(33);
        linkedHashSet.add(42);
        linkedHashSet.add(59);
        System.out.println(linkedHashSet); // #10

        System.out.println(linkedHashSet.add(42)); // #11
        System.out.println(linkedHashSet);
    }

    public void treeSetExecute() {
        Set<Integer> treeSet = new TreeSet<>(); // #12
        treeSet.add(1);
        treeSet.add(221);
        treeSet.add(33);
        treeSet.add(442);
        treeSet.add(59);
        System.out.println(treeSet); // #13

        System.out.println(treeSet.add(442)); // #14
        System.out.println(treeSet);
    }

    public void exerciseUniqueCharacterInNaturalOrdering(List<Character> list) {
        TreeSet<Character> treeSet = new TreeSet<>(list); // #15
        System.out.println(treeSet);

        HashSet<Character> hashSet = new HashSet<>(list); // #15
        System.out.println(hashSet);
    }

    public void exerciseUniqueCharacterInOrderOfAssignment(List<Character> list) {
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>(list); // #16
        System.out.println(linkedHashSet);
    }
}

