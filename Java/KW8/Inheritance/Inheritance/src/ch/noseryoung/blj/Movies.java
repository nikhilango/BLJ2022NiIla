package ch.noseryoung.blj;

public class Movies extends Books{
    private int releaseYear;
    private int ageRating;

    public Movies(String name, String author, int releaseYear, int ageRating) {
        super(name, author, releaseYear);
        this.ageRating = ageRating;
    }

    @Override
    public void printShelf(){
        super.printShelf();
        System.out.println("Age Rating: " + ageRating );
    }
}
