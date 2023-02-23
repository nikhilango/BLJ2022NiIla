package ch.noseryoung.blj;

public class Videogames extends Shelf{
    private int rating;
    private int size;

    public Videogames(String name, String author, int size, int rating){
        this.name = name;
        this.author = author;
        this.size = size;
        this.rating = rating;
    }
    @Override
    public void printShelf(){
        super.printShelf();
        System.out.println("Size: " + size + " GB");
        System.out.println("Rating: " + rating + " stars");
    }
}
