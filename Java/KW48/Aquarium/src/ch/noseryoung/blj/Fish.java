package ch.noseryoung.blj;

public class Fish {
    private String name;
    private int fishType;

    public Fish(String name, int fishType){
        this.name = name;
        this.fishType = fishType;
    }

    public void presentYouself(){
        System.out.println("You have selected " +name+ " and the fish type is " + fishType);
    }
}
