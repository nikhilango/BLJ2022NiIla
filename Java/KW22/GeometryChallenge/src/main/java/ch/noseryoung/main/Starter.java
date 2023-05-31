package ch.noseryoung.main;

public class Starter {

  public static void main(String[] args) {

    SideCreatorService creatorService = new SideCreatorService();
    TriangleManager sm = new TriangleManager(creatorService);
    sm.run();

    // todo: print all sorted Triangles
    for (int i = 0; i < sm.getAllTrianglesSortedByLongestSide().size(); i++){
      sm.getAllTrianglesSortedByLongestSide().get(i);
    }

    for (int i = 0; i < sm.getAllTrianglesSortedByShortestSide().size(); i++){
      sm.getAllTrianglesSortedByShortestSide().get(i);
    }
    // ... = sm.getAllTrianglesSortedByLongestSide();
    // ... = sm.getAllTrianglesSortedByLongestSide();

  }
}
