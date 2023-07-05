package ch.noseryoung.blj;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for creating a sample Zork-like level using
 * instances of {@link Room}. Below is a visual representation on how the room
 * instances are connected to each other.
 * 
 * <pre>
 *     ┌───────┐    
 *     │r09 r10│    
 * ┌───┘   ────┴───┐ 
 * │r03 r01 r02 r07│ 
 * ├────   ────┐   │ 
 * │r06 r04 r05│r08│ 
 * └───────────┤   │ 
 *             │r11│
 *             └───┘
 * </pre>
 * 
 * @author surber
 *
 */
public class RoomTest {

  private Room r01, r02, r03, r04, r05, r06, r07, r08, r09, r10, r11;

  /**
   * A constructor. It runs methods that are responsible for setting up all
   * {@link Room} instances and their connection.
   */
  public RoomTest() {
    initRooms();
    createConnections();
  }

  /**
   * This method
   */
  public void run() {
    System.out.println("----------------------------------------");

    // TRAVERSE ALL ROOMS
    List<Room> rooms = new ArrayList<>();
    traverse(r01, rooms);
    rooms.forEach(r -> System.out.println(r.getName()));

    System.out.println("----------------------------------------");

    // TRAVERSE ALL ROOMS WITH LOCATION
    Map<Point, Room> roomLocations = new HashMap<>();
    traverseWithLocation(r01, new Point(0, 0), roomLocations);
    roomLocations.forEach((p, r) -> System.out.println(p + " " + r.getName()));

    System.out.println("----------------------------------------");

    // NORMALISE POSITIONS
    normalisePositions(roomLocations);
    roomLocations.forEach((p, r) -> System.out.println(p + " " + r.getName()));

    System.out.println("----------------------------------------");

    // VISUAL MAP
    for (int[] x : generateVisualMap(roomLocations)) {
      for (int y : x) {
        System.out.print(y + " ");
      }
      System.out.println();
    }

    System.out.println("----------------------------------------");
  }

  /**
   * This method traverses all connected {@link Room} instances using recursion.
   * 
   * @param room           In the initial call of the method, the room to start
   *                       traversing from. After that, the instance from which
   *                       the traversing should continue.
   * @param traversedRooms A list that holds all rooms. The initial call of the
   *                       method should be given an empty list. It is also used
   *                       to determine whether to continue with the recursive
   *                       traversal or not.
   */
  private void traverse(Room room, List<Room> traversedRooms) {
    // TODO: Implement according to the Javadoc.
    traversedRooms.add(room);

    HashMap<Direction, Room> connectedRooms = room.getConnectedRooms();

    for (Room connectedRoom : connectedRooms.values()) {
      if (!traversedRooms.contains(connectedRoom)) {
        traverse(connectedRoom, traversedRooms);
      }
    }
  }

  /**
   * This method traverses all connected {@link Room} instances using recursion.
   * Additionally, for each {@link Room} instance, a location gets generated that
   * stays true to the rooms position, relative to the other rooms positions.
   * 
   * @param room           In the initial call of the method, the room to start
   *                       traversing from. After that, the instance from which
   *                       the traversing should continue.
   * @param location       In the initial call of the method, the location of the
   *                       first room. After that, the locations relative to the
   *                       first instance.
   * @param traversedRooms A map that holds positions (key) and their associated
   *                       room (value). The initial call of the method should be
   *                       given an empty map. It is also used to determine
   *                       whether to continue with the recursive traversal or
   *                       not.
   */
  private void traverseWithLocation(Room room, Point location, Map<Point, Room> traversedRooms) {
    // TODO: Implement according to the Javadoc.
    traversedRooms.put(location, room);

    HashMap<Direction, Room> connectedRooms = room.getConnectedRooms();

    for (Direction direction : connectedRooms.keySet()) {
      Room connectedRoom = connectedRooms.get(direction);

      Point vector = direction.vector();
      Point connectedLocation = new Point(location.x + vector.x, location.y + vector.y);

      if (!traversedRooms.containsKey(connectedLocation)) {
        traverseWithLocation(connectedRoom, connectedLocation, traversedRooms);
      }
    }
  }
  /**
   * This method shifts all positions of the given argument so that the smallest
   * coordinate of a position is 0 for X and / or Y. This is done by evaluating
   * the smallest X and Y value in the map and translating each position by
   * the negation of the evaluated smallest values.
   * 
   * Example:
   * 
   * <pre>
   * - Smallest position for X is (-3, 5), smallest position for Y is (1, 1)
   * - Translate all points by (3, -1)
   * - (-3, 5) becomes (0, 4), (1, 1) becomes (4, 0), etc.
   * </pre>
   * 
   * @param roomLocations A map that holds positions (key) and their associated
   *                      room instances (value).
   */
  private void normalisePositions(Map<Point, Room> roomLocations) {
    // TODO: Implement according to the Javadoc. Hint: Make use of Streams.

  }

  /**
   * This method creates a 2D array representing the connected {@link Room}
   * instances using the positions of the given argument. This is done by
   * evaluating the largest X and Y value in the map and using them to create a 2D
   * array of perfect width and height and changing the initial value of 0 to 1
   * for every position in the map.
   * 
   * Example based on the class description of {@link RoomTest}:
   * 
   * <pre>
   * 0110
   * 1111
   * 1111
   * 0001
   * </pre>
   * 
   * @param roomLocations A map that holds positions (key) and their associated
   *                      room (value).
   * @return The generated 2D array representing the connected room instnaces.
   */
  private int[][] generateVisualMap(Map<Point, Room> roomLocations) {
    // TODO: Implement according to the Javadoc. Hint: Make use of Streams.
    return null;
  }

  /**
   * This method initialises all 11 {@link Room} instances with a name and a
   * description.
   */
  private void initRooms() {
    r01 = new Room("Outside", "You are outside the main entrance of the university.");
    r02 = new Room("Theatre", "You are in a lecture theatre.");
    r03 = new Room("Pub", "You are in the campus pub.");
    r04 = new Room("Lab", "You are in a computing lab.");
    r05 = new Room("Office", "You are in the computing admin office.");
    r06 = new Room("Facility", "You are in a research facility.");
    r07 = new Room("Janitor", "You are in a small janitor's room.");
    r08 = new Room("Dungeon", "You are at the entrance of a dungeon.");
    r09 = new Room("Park", "You are in a public park.");
    r10 = new Room("Shed", "You are in an old shed.");
    r11 = new Room("Prison", "You are in front of some iron bars.");
  }

  /**
   * This method connects all 11 {@link Room} instances according to the map. Of
   * note, all rooms are connected both ways, i.e. there are no one-way doors.
   */
  private void createConnections() {
    r01.connectBothWays(Direction.EAST, r02);
    r01.connectBothWays(Direction.SOUTH, r04);
    r01.connectBothWays(Direction.WEST, r03);
    r01.connectBothWays(Direction.NORTH, r09);
    r02.connectBothWays(Direction.EAST, r07);
    r04.connectBothWays(Direction.EAST, r05);
    r04.connectBothWays(Direction.WEST, r06);
    r07.connectBothWays(Direction.SOUTH, r08);
    r08.connectBothWays(Direction.SOUTH, r11);
    r09.connectBothWays(Direction.EAST, r10);
  }
}
