package by.it.kglushchenko.jd01_12;

import java.util.*;

// Люди удаляются покругу

public class TaskB2 {
    public static void main(String[] args) {
        int players = 7; // 7 игроков задействовано
        ArrayList<String> list1 = new ArrayList<>();
        //list1 = Arrays.asList("Vanya", "Manya", "Petya", "Dania", "Sonya", "Monya", "Borya");
        list1.add("Vanya");
        list1.add("Manya");
        list1.add("Petya");
        list1.add("Dania");
        list1.add("Sonya");
        list1.add("Monya");
        list1.add("Borya");

        LinkedList<String> list2 = new LinkedList<>();
        //list2 = Arrays.asList("Vanya", "Manya", "Petya", "Dania", "Sonya", "Monya", "Borya");
        list2.add("Vanya");
        list2.add("Manya");
        list2.add("Petya");
        list2.add("Dania");
        list2.add("Sonya");
        list2.add("Monya");
        list2.add("Borya");

        //System.out.println(list1.indexOf(2));

        process(list1);
        process(list2);

        int[] arr = {22,54,78};
        try{
            System.out.println(arr[4]);
            int x=100/0;
            //System.out.println(arr[4]);
        }catch (ArithmeticException e){
            System.out.println("Error " + e);
        }
//        try{
//            System.out.println(arr[4]);
//        }
        catch (Exception e){
            System.out.println("Error" + e);
        }finally {
            System.out.println("finally is working");
        }
    }

    static String process(ArrayList<String> peoples) {
        String result = ""; // имя счастливчика
        int second = 0;    // если элемент второй - его удаляем
        int index = 0;    // индекс элемента
        int size = peoples.size();

        System.out.println("Size " + size);

        for (; ; ) {
            if (second == 1) {
                peoples.remove(index);
                size = peoples.size(); // обновляем размер списка
                System.out.println("Size " + size); // отслеживаем размер списка
                second = 0;
                continue;
            }

            second++;
            System.out.println(peoples.get(index));

            size = peoples.size(); // обновляем размер списка
            System.out.println("Size " + size); // отслеживаем размер списка
            System.out.println("Index "+ index);
            //index++;
            if (index == size-1 ){
                index=0;
                break;
            }
            index++;
        }
        //peoples.remove();
        return result;
    }

    static String process(LinkedList<String> peoples) {
        String result = " "; // имя счастливчика
        int second = 0;    // если элемент второй - его удаляем
        int index = 0;    // индекс элемента
        // Displaying Elements before remove
        System.out.println("Before Remove:");
        for(String str: peoples){
            System.out.println(str);
        }
        System.out.println();

//        ListIterator<String> listIterator = peoples.listIterator(); // помещаем указатель в начало списка
        // peoples.descendingIterator() - обход с конца списка
        //int second=0; // если элемент второй - его удаляем
//        while (listIterator.hasNext()){
//            if(second==1){
//                listIterator.remove();
//                second=0;
//                continue;
//         }
//            System.out.println(listIterator.toString());

//            second++;
//        }

        for(String str: peoples){
            System.out.println(str);
        }
        return result;
    }

}
