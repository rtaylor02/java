package com.rtaylor.javacourse.map;

/*
Key Lessons:
#1 - Create immutable Map with of() method. Note: any Map created with of() method is immutable.
#2 - Map is stored unordered.
#3 - Immutable map cannot have new element or remove existing element. Exception - UnsupportedOperationException.
#4 - get(a) - Returns value of key a.
#5 - size() - Returns size of map.
#6 - isEmpty() - Checks if map is empty. True = empty map.
#7 - containsKey(a) - Checks if key a is in the map. True = key exists.
#8 - containsValue(a) - Checks if value a is in the map. True = value exists.
#9 - keySet() - Returns a set of keys.
#10 - values() - Returns a collection of values.
#11 - Create a HashMap from a Map. Notice that HashMap does not maintain insertion order.
#12 - Create a HashMap from scratch. Notice that HashMap does not maintain insertion order.
#13 - put(a, b) - Insert a new key-value pair into HashMap. Returns previous value of the key (with the new value
      being stored) or null if new key-value pair.
#14 - Create a LinkedHashMap from scratch. Notice that, unlike HashMap, LinkedHashMap maintains insertion order.
#15 - put(a, b) - Insert a new key-value pair into LinkedHashMap. Returns previous value of the key (with the new
      value being stored) or null if new key-value pair.
#16 - Create a TreeMap from scratch. Notice that TreeMap stores elements in sorted order.
#17 - put(a, b) - Insert a new key-value pair into TreeMap. Returns previous value of the key (with the new
      value being stored) or null if new key-value pair.
#18 - Example of using HashMap to count characters in a String.
#18 - Example of using HashMap to count words in a String.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new MapTrial().execute();
//        new MapTrial().hashMapExecute();
//        new MapTrial().linkedHashMapExecute();
//        new MapTrial().treeMapExecute();
//        new MapTrial().characterCounter("Hello World in Java World");
        new MapTrial().wordsCounter("Hello World in Java World");
    }
}

class MapTrial {
    public void execute() {
        Map<Character, Integer> map = Map.of('A', 3, 'B', 2, 'D', 8);
        System.out.println(map); // #2
//        map.put('R', 1); // #3
//        map.remove('A'); // #3
        System.out.println(map.get('B')); // #4
        System.out.println(map.size()); // #5
        System.out.println(map.isEmpty()); // #6
        System.out.println(map.containsKey('D')); // #7
        System.out.println(map.containsValue(3)); // #8
        System.out.println(map.keySet()); // #9
        System.out.println(map.values()); // #10
    }

    public void hashMapExecute() {
        Map<Character, Integer> map = Map.of('A', 3, 'Z', 2, 'D', 8);
        HashMap<Character, Integer> hashMap = new HashMap<>(map); // #11
        System.out.println(hashMap);

        hashMap = new HashMap<>(); // #12
        hashMap.put('A',3); // #13
        hashMap.put('Z',13);
        hashMap.put('D',5);
        System.out.println(hashMap);

        System.out.println(hashMap.put('Z', 14)); // #13
        System.out.println(hashMap);
    }

    public void linkedHashMapExecute() {
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>(); // #14
        linkedHashMap.put('A',3);
        linkedHashMap.put('Z',13);
        linkedHashMap.put('D',5);
        System.out.println(linkedHashMap);

        System.out.println(linkedHashMap.put('Z', 24)); // #15
        System.out.println(linkedHashMap);
    }

    public void treeMapExecute() {
        TreeMap<Character, Integer> treeMap = new TreeMap<>(); // #16
        treeMap.put('A',3);
        treeMap.put('Z',13);
        treeMap.put('D',5);
        System.out.println(treeMap);

        System.out.println(treeMap.put('Z', 24)); // #17
        System.out.println(treeMap);
    }

    public void characterCounter(String inputString) { // #18
        // Strip inputString into characters
        char[] characters = inputString.toCharArray();

        Map<Character, Integer> characterOccurances = new HashMap<>();
        for(char c : characters) {
            Integer charCounter = characterOccurances.get(c);
            if(charCounter == null) {
                characterOccurances.put(c,1);
            } else {
                characterOccurances.put(c, ++charCounter);
            }
        }

        System.out.println(characterOccurances);
    }

    public void wordsCounter(String inputString) { // #19
        // Strip inputString into characters
        String[] words = inputString.split(" ");

        Map<String, Integer> wordOccurances = new HashMap<>();
        for(String s : words) {
            Integer wordCounter = wordOccurances.get(s);
            if(wordCounter == null) {
                wordOccurances.put(s,1);
            } else {
                wordOccurances.put(s, ++wordCounter);
            }
        }

        System.out.println(wordOccurances);
    }
}
