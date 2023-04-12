package ch.noseryoung.blj;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shelf> Shelves = new ArrayList<>();
        Books book = new Books("The three investigators", " Robert Arthur", 1964);
        CDs cd = new CDs("Mission Impossible", "Christopher McQuarrie", "CD-DA");
        Videogames videogame = new Videogames("GTA V", "Leslie Benzies", 65, 5);
        Movies movie = new Movies("Cars", "Disney", 2006, 0);

        book.printShelf();
        cd.printShelf();
        videogame.printShelf();
        movie.printShelf();

        Shelves.add(book);
        Shelves.add(cd);
        Shelves.add(videogame);
        Shelves.add(movie);
    }
}