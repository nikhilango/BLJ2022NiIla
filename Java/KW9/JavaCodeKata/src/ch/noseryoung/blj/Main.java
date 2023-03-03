package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) throws Exception {
        Set set1 = new Set(6);
        Set set2 = new Set(6);
        set1.addElem(1);
        set1.addElem(2);
        set1.addElem(3);
        set2.addElem(3);
        set2.addElem(4);
        set2.addElem(5);

        System.out.println("First set: " + set1);
        System.out.println("Second set: " + set2);
        System.out.println("Union numbers: " + set1.union(set2).toString());
        System.out.println("Intersected numbers: " + set1.intersection(set2).toString());
    }
}