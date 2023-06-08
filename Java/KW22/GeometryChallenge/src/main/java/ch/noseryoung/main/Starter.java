package ch.noseryoung.main;

public class Starter {

  public static void main(String[] args) {

    SideCreatorService creatorService = new SideCreatorService();
    TriangleManager sm = new TriangleManager(creatorService);
    sm.run();

    // todo: print all sorted Triangles
    System.out.println("\n\n\n\n\nTriangles sorted by longest side");
    for (int i = 0; i < sm.getAllTrianglesSortedByLongestSide().size(); i++){
      System.out.println("Side A: " + sm.getAllTrianglesSortedByLongestSide().get(i).getA());
      System.out.println("Side B: " + sm.getAllTrianglesSortedByLongestSide().get(i).getB());
      System.out.println("Side C: " + sm.getAllTrianglesSortedByLongestSide().get(i).getC());
      System.out.println();
    }

    System.out.println("\n\n\n\n\nTriangles sorted by shortest side");
    for (int i = 0; i < sm.getAllTrianglesSortedByShortestSide().size(); i++){
      System.out.println("Side A: " + sm.getAllTrianglesSortedByShortestSide().get(i).getA());
      System.out.println("Side B: " + sm.getAllTrianglesSortedByShortestSide().get(i).getB());
      System.out.println("Side C: " + sm.getAllTrianglesSortedByShortestSide().get(i).getC());
      System.out.println();
    }
    // ... = sm.getAllTrianglesSortedByLongestSide();
    // ... = sm.getAllTrianglesSortedByLongestSide();

  }
}
