package com.rtaylor.javacourse.collection.set;

import java.util.*;

/*
Key Lessons:
#1 - Create an immutable Set with of() method. Note: any collection created with of() is immutable.
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
#17 - NavigableSet interface has lots of useful methods that based on Set and SortedSet interfaces. Thus, NavigableSet
      is naturally unique and sorted. Any class implement NavigableSet has these properties. E.g. TreeSet.
#17a - lower(a) - returns an element < a.
#17b - floor(a) - returns an element <= a.
#17c - ceiling(a) - returns an element >= a.
#17d - higher(a) - returns an element > a.
#17e - subset(a, b) - returns element between a (inclusive) and b (exclusive)
#17f - subset(a, aa, b, bb) - variation of subset(a, b) with more control on inclusivity (aa, bb). True as inclusive.
#17g - headSet(a) - returns elements < a (exclusive).
#17h - tailSet(a) - returns elements > a (inclusive).
 */

public class Main {
    public static void main(String[] args) {
//        new SetTrial().execute();
//        new SetTrial().hashSetExecute();
//        new SetTrial().linkedHashSetExecute();
//        new SetTrial().treeSetExecute();

//        new SetTrial().exerciseUniqueCharacterInNaturalOrdering(List.of('A', 'Z', 'A', 'B', 'Z', 'F'));
//        new SetTrial().exerciseUniqueCharacterInOrderOfAssignment(List.of('A', 'Z', 'A', 'B', 'Z', 'F'));
        new SetTrial().navigableSet(List.of(22,99,67,45, 82, 101, 78, 52));
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

    public void navigableSet(List<Integer> list) {
        TreeSet treeSet = new TreeSet(list);
        System.out.println(treeSet);
        System.out.println(treeSet.lower(78)); // #17a
        System.out.println(treeSet.floor(78)); // #17b
        System.out.println(treeSet.ceiling(78)); // #17c
        System.out.println(treeSet.higher(78)); // #17d
        System.out.println(treeSet.subSet(45, 99)); // #17e
        System.out.println(treeSet.subSet(45, true, 99, true)); // #17f
        System.out.println(treeSet.headSet(78)); // #17g
        System.out.println(treeSet.tailSet(78)); // #17h
    }
}

