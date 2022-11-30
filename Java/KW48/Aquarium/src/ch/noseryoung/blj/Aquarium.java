package ch.noseryoung.blj;
import java.util.Random;

public class Aquarium {
    private int waterType;
    private int aquariumSize;
    private int xpos;
    private int ypos;

    public Aquarium(int waterType, int aquariumSize){
        this.waterType = waterType;
        this.aquariumSize = aquariumSize;
        this.xpos = xpos;
        this.ypos = ypos;
    }
    public int generateFish(){
        Random randomGen = new Random();
        int amountOfFish = (int)(Math.random() * (aquariumSize * aquariumSize) + 1);

        return amountOfFish;
    }
    public int generateWatertype(){
        Random randomGen = new Random();
        int genWatertype = randomGen.nextInt((1 - 0) + 1) + 0;
        if (genWatertype == 1){
            waterType = 1;
        }
        else {
            waterType = 0;
        }
        return waterType;
    }
    public int getAquariumSize() {
        return aquariumSize;
    }
}
