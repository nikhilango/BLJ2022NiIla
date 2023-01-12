package ch.noseryoung.app;

import java.util.Scanner;

// import the exceptions
import ch.noseryoung.exceptions.*;

public class TriangleApp {

  private static String company = "NOSER YOUNG";
  private static String handler = "Nikhil Ilango";

  private static boolean isRunning = true;

  private static String sideAInput;
  private static String sideBInput;
  private static String sideCInput;

  private static double sideA;
  private static double sideB;
  private static double sideC;

  private static String code;

  private static boolean hasLettersAndSymbols = false;
  //private static char


  /**
   * The constructor.
   * 
   * @param company of type String to print in the application header
   * @param handler of type String to print in the application header
   */
  public TriangleApp(String company, String handler) {
    // persist company and handler
    this.company = company;
    this.handler = handler;
	// with initialisation program is running.
    start();
  }

  /**
   * This method starts the actual application. It will remain in a loop as long
   * as the field "isRunning" is true.
   */
  public static void start() {
    hasLettersAndSymbols = false;
    printHeader();
    while (isRunning) {
      System.out.println("\nTEST CASES TRIANGLE\n");

      Scanner scan = new Scanner(System.in);

      System.out.print("Cathetus A:      ");
      sideAInput = scan.nextLine();
      System.out.print("Cathetus B:      ");
      sideBInput = scan.nextLine();
      System.out.print("Hypotenuse C:    ");
      sideCInput = scan.nextLine();
      // get all 3 sides from the triangle

      try {
		// validate Input (might throw exception)
        validateInput(sideAInput, sideBInput, sideCInput);
		// get triangle code and write it to field code
      } catch (TriangleException e) {
        // get error code from exception and write it to field code
      } finally {
        printResult();
		// print result
        promptAction();
		// ask user for next step
      }
    }
  }

  /**
   * This method prints the application header.
   */
  private static void printHeader() {
    System.out.println("********************************");
    System.out.println("       TRIANGLE EVALUATOR");
    System.out.println("********************************");
    System.out.println("COMPANY: " + company+ ", 2023");
    System.out.println("HANDLER: " + handler);
    System.out.println("********************************");
  }

  /**
   * This method prints the evaluated code in an aesthetically pleasing way.
   */
  private static void printResult() {
    code = determineTriangleType();
    System.out.println();
    System.out.println("--------------------------------");
    System.out.println("CODE:            " + code);
    System.out.println("--------------------------------");
    System.out.println();
    // todo
  }

  /**
   * This method prompts the user to give an input.<br>
   * "q": Quits the program.<br>
   * "c": Continues the program.<br>
   * else: Keeps asking for an input until "q" or "c" is entered.
   */
  private static void promptAction() {
    String action = "";
    // get valid prompt
    Scanner scan = new Scanner(System.in);
    System.out.println("<q> QUIT");
    System.out.println("<c> CONTINUE");
    action = scan.nextLine();

    // check if program needs to be cancelled
    if (action.equals("q")){
      isRunning = false;
    }
    else if (action.equals("c")){
      start();
    }
    else {
      promptAction();
    }
    System.out.println("*********************************");
  }

  /**
   * This method validates the three entered values, to be used as sides for a
   * triangle.
   * 
   * @throws TriangleException if the validation fails. This means that the
   *                           entered values do not lead to a triangle.
   */
  private static void validateInput(String sideAInput, String sideBInput, String sideCInput) throws TriangleException {
    // validate sideAInput, sideBInput, sideCInput as double
    try {
      sideA = Double.parseDouble(sideAInput);
      sideB = Double.parseDouble(sideBInput);
      sideC = Double.parseDouble(sideCInput);
    }
    catch (NumberFormatException e){
      hasLettersAndSymbols = true;
      throw new IllegalTriangleSideException();
    }
    if (0 == sideA || 0 == sideB || 0 == sideC) {
      // throws ZeroTriangleSideException
      throw new ZeroTriangleSideException();
    }
    // validates other triangle cases
    else if (0 > sideA  || 0 > sideB || 0 > sideC) {
      throw new NegativeTriangleSideException();
    }
    else if (sideA + sideB == sideC) {
      throw new TriangleIsLineException();
    }
    else if (sideA == sideB && sideA != sideC && sideB != sideC){
      throw new TriangleException("TRI84TF");
    }
    else if (sideA == sideB && sideA == sideC){
      throw new TriangleException("TRI66TF");
    }
    else if (sideA + sideB >= sideC || sideA + sideC >= sideB || sideB + sideC >= sideA){
      throw new TriangleException("TRI60TF");
    }
    else if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA){
      throw new ImpossibleTriangleException();
    }
    else if (Math.sqrt((sideA * sideA) + (sideB * sideB)) == sideC){
      throw new TriangleException("TRI72TF");
    }
  }

  /**
   * This method determines whether the three entered values lead to a
   * equilateral, isosceles, right-angled or scalene triangle.
   * 
   * @return The corresponding code for each triangle.
   */
  private static String determineTriangleType() {
    if (hasLettersAndSymbols){
      return "ERR96TF";
    }
    else if (0 == sideA || 0 == sideB || 0 == sideC) {
      // throws ZeroTriangleSideException
      return "ERR16TF";
    }
    // validates other triangle cases
    else if (0 > sideA  || 0 > sideB || 0 > sideC) {
      return "ERR12TF";
    }
    else if (sideA + sideB == sideC) {
      return "ERR56TF";
    }
    else if (sideA == sideB && sideA != sideC && sideB != sideC){
      return "TRI84TF";
    }
    else if (Math.sqrt((sideA * sideA) + (sideB * sideB)) == sideC){
      return "TRI72TF";
    }
    else if (sideA == sideB && sideA == sideC){
      return "TRI66TF";
    }
    else if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA){
      return "ERR36TF";
    }

    else if (sideA + sideB >= sideC || sideA + sideC >= sideB || sideB + sideC >= sideA){
      return "TRI60TF";
    }
    else {
      return null;
    }
  }
}
