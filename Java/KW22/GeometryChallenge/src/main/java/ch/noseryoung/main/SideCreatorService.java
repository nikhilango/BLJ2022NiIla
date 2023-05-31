package ch.noseryoung.main;

import java.util.Random;

public class SideCreatorService implements ShapeSideCreator{

  /**
   * This method generates a random <code>double</code>, rounded to .0 or .5.
   *
   * @return the generated value, to be used as a side for a shape
   */
  @Override
  public double createSide() {
    //todo implement
    Random random = new Random();

    double randomNumber = Math.round((random.nextDouble() * 10 + 1) * 2) / 2.0;
    return randomNumber;
  }
}
