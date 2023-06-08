package ch.noseryoung.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TriangleManager {

  private ShapeSideCreator generator;
  private TriangleValidator triangleValidator;
  private ArrayList<Triangle> triangles;

  public TriangleManager(ShapeSideCreator generator) {
    this.generator = generator;
    triangleValidator = new TriangleValidator();
    triangles = new ArrayList<>();
  }

  /**
   * This method is the entry point for the triangle manager.
   * It creates at least one triangle with the <code>ShapeSideCreator</code> instance
   * and prints the triangle with its information.
   */
  public void run() {

    printWelcomeText();

    //todo: create multiple triangles with its validation
    for (int i = 0; i < 10; i++){
      Triangle triangle = generateTriangle();
      boolean isEquilateral = triangleValidator.isEquilateral(triangle);
      boolean isIsosceles = triangleValidator.isIsosceles(triangle);
      boolean isScalene = triangleValidator.isScalene(triangle);
      triangles.add(triangle);
      // todo: add a valid Triangle to the triangles list
      printTriangleInfo(triangle, isEquilateral, isIsosceles, isScalene);
    }
  }

  /**
   * This method calls an implementation from the <code>ShapeSideCreator</code> Interface
   * to get three sides for a new triangle.
   *
   * @return created triangle
   */
  private Triangle generateTriangle() {
    return new Triangle(generator.createSide(), generator.createSide(), generator.createSide());
  }

  /**
   * This Method prints out the Triangle Information with the result form the validation.
   *
   * @param t
   * @param isEquilateral
   * @param isIsoceles
   * @param isScalene
   */
  private void printTriangleInfo(Triangle t, boolean isEquilateral, boolean isIsoceles, boolean isScalene) {
    // todo
    System.out.println("Triangle Info:");
    System.out.println("Side A: " + t.getA());
    System.out.println("Side B: " + t.getB());
    System.out.println("Side C: " + t.getC());
    if (isEquilateral){
      System.out.println("This triangle is equilateral\n");
    }
    else if (isIsoceles) {
      System.out.println("This triangle is isocles\n");
    }
    else if (isScalene) {
      System.out.println("This triangle is scalene\n");
    }
    else {
      System.out.println("This triangle is invalid\n");
    }
  }

  /**
   * This method returns out all generated Triangles, which are sorted by side.
   * The Triangles are compared with its shortest side. The longest "shortest Side" is listed first.
   *
   * @return sorted triangle list
   */
  public ArrayList<Triangle> getAllTrianglesSortedByShortestSide(){
    // todo
    Comparator<Triangle> shortestSideComarator = Comparator.comparingDouble(this::getShortestSide);
    Collections.sort(triangles, shortestSideComarator);
    return triangles;
  }

  /**
   * This method returns out all generated Triangles, which are sorted by side.
   * The Triangles are compared with its longest side. The longest "longest Side" is listed first.
   *
   * @return sorted triangle list
   */
  public ArrayList<Triangle> getAllTrianglesSortedByLongestSide() {
    // todo
    Comparator<Triangle> longestSideComparator = Comparator.comparingDouble(this::getLongestSide).reversed();
    Collections.sort(triangles, longestSideComparator);
    return triangles;
  }

  public double getLongestSide(Triangle triangle) {
    double longestSide = Math.max(triangle.getA(), Math.max(triangle.getB(), triangle.getC()));

    return longestSide;
  }

  public double getShortestSide(Triangle triangle) {
    double shortestSide = Math.min(triangle.getA(), Math.min(triangle.getB(), triangle.getC()));

    return shortestSide;
  }

  /**
   * This method prints a welcome text for the triangle manager.
   */
  private void printWelcomeText(){
    // todo
    System.out.println("\n\n\n\n\nHi :) Welcome to the triangle manager!");
  }
}
