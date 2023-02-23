package ch.noseryoung.blj;

public class CDs extends Shelf{
    private String type;

    public CDs(String name, String author, String type){
        this.name = name;
        this.author = author;
        this.type = type;
    }
    @Override
    public void printShelf(){
        super.printShelf();
        System.out.println("Type: " + type);
    }
}
