import java.util.HashSet;
import java.util.Set;

public class TypeConverter {
  static String cleanedString = "";
  static String cleanedLong = "";
  /**
   * This method converts a String to a Short.
   * Accepted Values are:
   *    - (only at first place)
   *    _ and ' (10_000 and 10'000 are equal to 10000)
   *    numbers 0-9
   *
   * @param toConvert String to be converted
   * @return converted short
   * @throws IllegalArgumentException if String cannot be converted
   *
   * @author <nikhil&oebadanir>
   */
  public short convertStringToShort(String toConvert) throws IllegalArgumentException{

    cleanedString = toConvert.replaceAll("[_']", "");
    if (cleanedString.startsWith("-")) {
      cleanedString = cleanedString.substring(1);
    }

    try {
      short convertedShort = Short.parseShort(cleanedString);

      if (cleanedString.startsWith("-")) {
        return (short) -convertedShort;
      } else {
        return convertedShort;
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("String is invalid");
    }
  }

  /**
   * This method converts a String to a Double.
   * Accepted Values are:
   *    - (only at first place)
   *    _ and ' (10_000 and 10'000 are equal to 10000)
   *    . and , for decimal (only one allowed)
   *    numbers 0-9
   *
   * @param toConvert String to be converted
   * @return converted Double
   * @throws IllegalArgumentException ifString cannot be converted
   *
   * @author <nikhil&oebadanir>
   */
  public double convertStringToDouble(String toConvert) throws IllegalArgumentException {
    String cleanedDouble = toConvert.replaceAll("[_']", "");
    if (cleanedDouble.startsWith("-")) {
      cleanedDouble = cleanedDouble.substring(1);
    }
    if (cleanedDouble.matches(".*[.,][.,].*")) {
      throw new IllegalArgumentException("String has too many comma or dots");
    }

    double convertedDouble;
    if (cleanedDouble.startsWith("-")) {
      convertedDouble = Double.parseDouble(cleanedDouble.replace(",", "."));
      convertedDouble = -convertedDouble;
    } else {
      convertedDouble = Double.parseDouble(cleanedDouble.replace(",", "."));
    }
    return convertedDouble;
  }

  /**
   * This method converts a String to a Long.
   * Accepted Values are:
   *    - (only at first place)
   *    _ and ' (10_000 and 10'000 are equal to 10000)
   *    numbers 0-9
   *
   * @param toConvert String to be converted
   * @return converted long
   * @throws IllegalArgumentException if String cannot be converted
   *
   * @author <nikhil&oebadanir>
   */
  public Long convertStringToLong(String toConvert) throws IllegalArgumentException{
    cleanedLong = toConvert.replaceAll("[_']", "");
    boolean negative = cleanedLong.startsWith("-");

    if (negative) {
      cleanedLong = cleanedLong.substring(1);
    }

    try {
      long convertedLong = Long.parseLong(cleanedLong);
      if (negative) {
        return -convertedLong;
      } else {
        return convertedLong;
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("String is invalid");
    }
  }

  /**
   * This method converts a String to a lowercase Char Array.
   * Accepted Values are:
   *    - (only after second place and before second last place, e.g. ge-laufen is ok, g-elaufen is not ok)
   *    letters a-z and A-Z
   *
   * @param toConvert String to be converted
   * @return converted Char Array
   * @throws IllegalArgumentException if String cannot be converted
   *
   * @author <nikhil&oebadanir>
   */
  public char[] StringToCharArray(String toConvert) throws IllegalArgumentException{
    // todo implement
    char[] result = new char[toConvert.length()];
    try{
      for (int i = 0; i < toConvert.length(); i++){
        result[i] = toConvert.charAt(i);
      }
    }
    catch (IllegalArgumentException e){
      throw new IllegalArgumentException("String is invalid");
    }
    return result;
  }

  /**
   * This method converts a String to a lowercase Char Array.
   * Accepted Values are:
   *    - (only after second place and before second last place, e.g. ge-laufen is ok, g-elaufen is not ok)
   *    letters a-z and A-Z
   *    each letter is allowed only once
   *
   * @param toConvert String to be converted
   * @return converted Char Array
   * @throws IllegalArgumentException if String cannot be converted
   *
   * @author <nikhil&oebadanir>
   */
  public Set<Character> StringToCharSet(String toConvert){
    // todo implement
    HashSet<Character> result = new HashSet<>();
    try{
      for (int i = 0; i < toConvert.length(); i++){
        result.add(toConvert.charAt(i));
      }
    }
    catch (IllegalArgumentException e){
      throw new IllegalArgumentException("String is invalid");
    }
    return result;
  }
}
