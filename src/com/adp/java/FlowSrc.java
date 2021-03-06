/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.adp.java;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum FlowSrc implements org.apache.thrift.TEnum {
  all(0),
  tanx(1),
  doubleclick(2),
  sax(3),
  tencent(4),
  youku(5),
  self_media(6);

  private final int value;

  private FlowSrc(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }
 
  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static FlowSrc findByValue(int value) { 
    switch (value) {
      case 0:
        return all;
      case 1:
        return tanx;
      case 2:
        return doubleclick;
      case 3:
        return sax;
      case 4:
        return tencent;
      case 5:
        return youku;
      case 6:
        return self_media;
      default:
        return null;
    }
  }
}
