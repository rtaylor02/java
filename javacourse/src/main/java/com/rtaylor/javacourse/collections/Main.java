package com.rtaylor.javacourse.collections;

/*
Some Collection interfaces that Java provides:
1) List
2) Set
3) Queue
4) Map
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new ListTrial().immutableListInterface();
//        new SortingList().execute();
        new SortingList().executeStudentSorting();
    }

}

class ListTrial {
    public void immutableListInterface() {
        List myPets = List.of("dogs", "cats");
        System.out.println(myPets.getClass());
        System.out.println(myPets);
        System.out.println(myPets.get(0));
        System.out.println(myPets.get(1));
//        System.out.println(myPets.);
        //myPets.add("slugs"); // Exception: List is immutable. Adding contents is not allowed.
        System.out.println("~~~~~~~~~~~");
        mutableListClasses_ArrayList(myPets);
        mutableListClasses_LinkedList(myPets);
        mutableListClasses_Vector(myPets);
    }

    private void mutableListClasses_ArrayList(List theList) {
        List<String> myPetsArrayList = new ArrayList<>(theList);
        myPetsArrayList.add("lizards"); // True if list changed as a result
        System.out.println("ArrayList: " + myPetsArrayList);

        List<String> addition = List.of("turtles", "fish");
        myPetsArrayList.addAll(addition); // True if list changed as a result
        System.out.println("ArrayList: " + myPetsArrayList);

        String replaced = myPetsArrayList.set(1, "pigs"); // Replacing index 1 with pigs
        System.out.println("Replaced by \"pigs\": " + replaced);
        System.out.println("ArrayList: " + myPetsArrayList);

        myPetsArrayList.remove("lizards"); // Remove 1st "lizards". True if exists and removed. False otherwise.
        System.out.println("ArrayList: " + myPetsArrayList);

        // Iterating through ArrayList
        System.out.println("Iterating through ArrayList via: (enhanced) for loop & Iterator");
        for(int i = 0; i < myPetsArrayList.size(); i++) {
            System.out.println("i: " + i + " - " + myPetsArrayList.get(i));
            if(myPetsArrayList.get(i).endsWith("gs")) {
                System.out.println("removed: " + myPetsArrayList.remove(i));
            }
        }

        for(String s : myPetsArrayList) {
            System.out.println(s);
            // With enhanced for loop, it is an exception (ConcurrentModificationException)to
            // operate on the elements while iterating
//            if(s.endsWith("gs")) {
//                myPetsArrayList.remove(s); // ConcurrentModificationException
//            }
        }

        Iterator<String> i = myPetsArrayList.iterator();
        while(i.hasNext()) {
            if(i.next().endsWith("gs")) {
                i.remove(); // Removes the element that ends with "gs"
            }
        }

        Iterator<String> ii = myPetsArrayList.iterator();
        while(ii.hasNext()) {
            System.out.println(ii.next());
        }

        System.out.println("=========================");
    }

    private void mutableListClasses_LinkedList(List theList) {
        List<String> myPetsLinkedList = new LinkedList<>(theList);
        myPetsLinkedList.add(2, "snail"); // Index is specified
        System.out.println("LinkedList: " + myPetsLinkedList);
        List<String> addition = List.of("turtles", "fish");
        myPetsLinkedList.addAll(addition);
        System.out.println("LinkedList: " + myPetsLinkedList);
        System.out.println("=========================");
    }

    private void mutableListClasses_Vector(List theList) {
        List<String> myPetsVector = new Vector<>(theList);
        myPetsVector.add(1, "snakes"); // Index is specified
        System.out.println("Vector: " + myPetsVector);
        List<String> addition = List.of("turtles", "fish");
        myPetsVector.addAll(addition);
        System.out.println("Vector: " + myPetsVector);
        System.out.println("=========================");
    }
}

class SortingList {
    public void execute() {
        List<Integer> listOfIntegers = List.of(22, 11, 55, 33);
        listOfIntegers = new ArrayList<>(listOfIntegers);
        sortUsingCollections(listOfIntegers);
    }

    public void executeStudentSorting() {
        List<Student> students = new ArrayList<>(List.of(
                new Student(11, "Tom Cruise"),
                new Student(2, "Ken Kousen"),
                new Student(3, "Andy Olsen"),
                new Student(45, "Josh Long"),
                new Student(4, "Josh Hornet")
        ));

//        sortUsingCollections(students);
        students.sort(new StudentComparatorAscending());
        System.out.println(students);
        students.sort(new StudentComparatorDescending());
        System.out.println(students);
    }

    private void sortUsingCollections(List listToSort) {
        System.out.println("Before sorting: " + listToSort);
        Collections.sort(listToSort);
        System.out.println("After sorting: " + listToSort);
    }

    private record Student(int id, String name) implements Comparable<Student> {
        @Override
        public int compareTo(Student that) {
            return Integer.compare(this.id, that.id);
        }


    }

    // Inner class to allow flexible sorting Students by implementing Comparator interface
    private class StudentComparatorAscending implements Comparator<Student> {

        @Override
        public int compare(Student thisStudent, Student thatStudent) {
            return thisStudent.compareTo(thatStudent);
        }
    }

    // Inner class to allow flexible sorting Students by implementing Comparator interface
    private class StudentComparatorDescending implements Comparator<Student> {

        @Override
        public int compare(Student thisStudent, Student thatStudent) {
            return thatStudent.compareTo(thisStudent);
        }
    }
}


