package ch.noseryoung.blj;

public class Books extends Shelf{
    private int releaseYear;

    public Books(String name, String author, int releaseYear){
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    @Override
    public void printShelf(){
        super.printShelf();
        System.out.println("Release Year: " + releaseYear);
    }
}
