public class Starter {
  public static void main(String[] args) {
    new GameIO(new Game(), 64, 0.9);
    Timer timer = new Timer();
    timer.start();
  }
}
