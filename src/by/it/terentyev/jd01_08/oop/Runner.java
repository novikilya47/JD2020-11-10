package by.it.terentyev.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        Book encyklopedia = new Book();
        Reference references = new Reference();
        references.printType("Spravochnik");
        System.out.println(encyklopedia.size);
        System.out.println(references.size);
    }
}
