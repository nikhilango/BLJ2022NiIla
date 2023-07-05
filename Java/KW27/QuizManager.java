package ch.noseryoung;

public class QuizManager {

  private Console console;

  public QuizManager(Console console) {
    this.console = console;
  }

  public void handleTextInput(String textInput) {
    console.appendLine("└> " + textInput);
  }
}
