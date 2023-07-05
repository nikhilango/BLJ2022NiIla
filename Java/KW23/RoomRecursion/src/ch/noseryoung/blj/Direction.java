package ch.noseryoung.blj;

import java.awt.Point;

/**
 * This enum represents the four cardinal directions.
 * 
 * @author surber
 *
 */
public enum Direction {
  NORTH, SOUTH, EAST, WEST;

  /**
   * This helper method evaluates the opposite of a direction.
   * 
   * @return The direction that is opposite to this direction.
   */
  public Direction opposite() {
    return switch (this) {
    case NORTH -> SOUTH;
    case SOUTH -> NORTH;
    case EAST -> WEST;
    case WEST -> EAST;
    };
  }

  /**
   * This helper method converts a directions to a movement vector.
   * 
   * @return The direction as a movement vector.
   */
  public Point vector() {
    return switch (this) {
    case NORTH -> new Point(-1, 0);
    case SOUTH -> new Point(1, 0);
    case EAST -> new Point(0, 1);
    case WEST -> new Point(0, -1);
    };
  }
}
