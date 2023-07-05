package ch.noseryoung.blj;

import java.util.HashMap;
import java.util.StringJoiner;

/**
 * This class represents a room in a Zork-like game. Of note, it doesn't have to
 * be an actual room in a building, but instead can be an arbitrary location
 * like forest, street, cave, etc.
 * 
 * @author surber
 *
 */
public class Room {
  private String name;
  private String desc;
  private HashMap<Direction, Room> connectedRooms;

  /**
   * A constructor. An empty string gets assigned for the description of the
   * {@link Room} instance.
   * 
   * @param name The name of a room.
   */
  public Room(String name) {
    this(name, "");
  }

  /**
   * A constructor.
   * 
   * @param name The name of a room.
   * @param desc The description of a room.
   */
  public Room(String name, String desc) {
    this.name = name;
    this.desc = desc;
    this.connectedRooms = new HashMap<>();
  }

  /**
   * This method adds a new connection to another {@link Room} instance. Of note,
   * the other {@link Room} instance doesn't get connected from calling this
   * method. Should that be desired, then call this method relative to the other
   * {@link Room} instance or call {@link #connectBothWays(Direction, Room)} once.
   * 
   * @param direction     The direction (key) at which relative to this room,
   *                      another room can be found.
   * @param roomToConnect Another room (value) that can be accessed from the given
   *                      direction.
   */
  public void connectOneWay(Direction direction, Room roomToConnect) {
    this.connectedRooms.put(direction, roomToConnect);
  }

  /**
   * This method connects two {@link Room} instances with each other. It is
   * equivalent to calling {@link #connectOneWay(Direction, Room)} twice with
   * opposite directions.
   * 
   * @param direction     The direction (key) at which relative to this room,
   *                      another room can be found, and the opposite of the given
   *                      direction, from which this room can be accessed from the
   *                      other room.
   * @param roomToConnect The other room (value) to connect.
   */
  public void connectBothWays(Direction direction, Room roomToConnect) {
    this.connectOneWay(direction, roomToConnect);
    roomToConnect.connectOneWay(direction.opposite(), this);
  }

  /**
   * This method returns the {@link Room} instance that can be found at the given
   * direction.
   * 
   * @param direction The direction of a connected room.
   * @return (a) The room that can be found at the given direction.<br>
   *         (b) null if no room is connected to the given direction.
   */
  public Room getConnectedRoom(Direction direction) {
    return connectedRooms.get(direction);
  }

  public HashMap<Direction, Room> getConnectedRooms() {
    return connectedRooms;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
