package com.rtaylor.javacourse.generics;

import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;

/*
Key Lessons:
#1 - Generics solves a problem of creating 1 piece of template code that is applicable to any data type.
#2 - Create a class that contains a generic type
#3 - Create a method that contains a generic type.
     Note: The generic type should be introduced before the return type.
#4 - Use keyword 'extends' to limit the type scope of the generic type, i.e. the generic type must be in a
     hierarchy of a certain class / interface. This will provide you with list of methods from that class that
     you can use in your logic.
#5 - Use wildcard when you want to limit a generic type. 3 limits are possible: unbounded, upper bounded, lower bounded.
     Unbounded: List<?> - allowed types: any type
     Upper bounded: List<? extends Number> - allowed types: Number, Integer, Double, etc
     Lower bounded: List<? super Integer> - allowed types: Integer, Number, Object
     Note:
#5a - ? wildcard can only be used to replace generic type.
#5b - Use ? wildcard whenever unbounded type is needed and when it's only being used once at the method declaration.
 */
public class Main {
    public static void main(String[] args) {
        MyCustomList<String> list1 = new MyCustomList<>();
        list1.add("Hello");
        list1.add("World");
        System.out.println(list1);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.add(33);
        list2.add(77);
        System.out.println(list2);
    }

    static <T> T staticGenericMethod(T x) { // #3
        return x;
    }

    <T> T instanceGenericMethod(T x) { // #3
        return x;
    }

    <T> void anotherInstanceGenericMethod(T e) { // #3
        // do something
    }

    <T extends ArrayList> boolean genericMethodWithScope(T list) { // #4
        return list.isEmpty();
    }

    void processUpperBoundedCustomList(MyCustomList<? extends Number> customList) { // #5 #5a

    }

    void processLowerBoundedCustomList(MyCustomList<? super Integer> customList) { // #5 #5a

    }

    void processUnboundedCustomList(MyCustomList<?> customList) { // #5 #5a #5b

    }


}

//interface CustomList<T> {
//    ArrayList<T> list = new ArrayList<>();
//
//}

class MyCustomList<T> { // #2
    ArrayList<T> list = new ArrayList<>();
    public void add(T element) {
        list.add(element);
    }
    public T remove(T element) {
        return list.remove(list.indexOf(element));
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

class MyCustomExtendedList<T extends List> { // #4

}

class MyCustomExtendedClassList<T extends ArrayList> { //#4
    void deleteAll(T list) {
        list.clear();
    }
    void addRectangle(List<?> c) { // #5b
        c.size();
    }
}