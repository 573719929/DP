/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.baicdata.stat;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class pageOptions implements org.apache.thrift.TBase<pageOptions, pageOptions._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("pageOptions");

  private static final org.apache.thrift.protocol.TField PAGE_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("pageNumber", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSize", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField ORDER_FIELD_DESC = new org.apache.thrift.protocol.TField("order", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ORDER_BY_FIELD_DESC = new org.apache.thrift.protocol.TField("orderBy", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new pageOptionsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new pageOptionsTupleSchemeFactory());
  }

  public int pageNumber; // required
  public int pageSize; // required
  /**
   * 
   * @see ORDER
   */
  public ORDER order; // required
  public String orderBy; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PAGE_NUMBER((short)1, "pageNumber"),
    PAGE_SIZE((short)2, "pageSize"),
    /**
     * 
     * @see ORDER
     */
    ORDER((short)3, "order"),
    ORDER_BY((short)4, "orderBy");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PAGE_NUMBER
          return PAGE_NUMBER;
        case 2: // PAGE_SIZE
          return PAGE_SIZE;
        case 3: // ORDER
          return ORDER;
        case 4: // ORDER_BY
          return ORDER_BY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PAGENUMBER_ISSET_ID = 0;
  private static final int __PAGESIZE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PAGE_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("pageNumber", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("pageSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ORDER, new org.apache.thrift.meta_data.FieldMetaData("order", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ORDER.class)));
    tmpMap.put(_Fields.ORDER_BY, new org.apache.thrift.meta_data.FieldMetaData("orderBy", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(pageOptions.class, metaDataMap);
  }

  public pageOptions() {
    this.pageNumber = 1;

    this.pageSize = 10;

    this.order = com.baicdata.stat.ORDER.ASC;

  }

  public pageOptions(
    int pageNumber,
    int pageSize,
    ORDER order,
    String orderBy)
  {
    this();
    this.pageNumber = pageNumber;
    setPageNumberIsSet(true);
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    this.order = order;
    this.orderBy = orderBy;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public pageOptions(pageOptions other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.pageNumber = other.pageNumber;
    this.pageSize = other.pageSize;
    if (other.isSetOrder()) {
      this.order = other.order;
    }
    if (other.isSetOrderBy()) {
      this.orderBy = other.orderBy;
    }
  }

  public pageOptions deepCopy() {
    return new pageOptions(this);
  }

  @Override
  public void clear() {
    this.pageNumber = 1;

    this.pageSize = 10;

    this.order = com.baicdata.stat.ORDER.ASC;

    this.orderBy = null;
  }

  public int getPageNumber() {
    return this.pageNumber;
  }

  public pageOptions setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
    setPageNumberIsSet(true);
    return this;
  }

  public void unsetPageNumber() {
    __isset_bit_vector.clear(__PAGENUMBER_ISSET_ID);
  }

  /** Returns true if field pageNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetPageNumber() {
    return __isset_bit_vector.get(__PAGENUMBER_ISSET_ID);
  }

  public void setPageNumberIsSet(boolean value) {
    __isset_bit_vector.set(__PAGENUMBER_ISSET_ID, value);
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public pageOptions setPageSize(int pageSize) {
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    return this;
  }

  public void unsetPageSize() {
    __isset_bit_vector.clear(__PAGESIZE_ISSET_ID);
  }

  /** Returns true if field pageSize is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSize() {
    return __isset_bit_vector.get(__PAGESIZE_ISSET_ID);
  }

  public void setPageSizeIsSet(boolean value) {
    __isset_bit_vector.set(__PAGESIZE_ISSET_ID, value);
  }

  /**
   * 
   * @see ORDER
   */
  public ORDER getOrder() {
    return this.order;
  }

  /**
   * 
   * @see ORDER
   */
  public pageOptions setOrder(ORDER order) {
    this.order = order;
    return this;
  }

  public void unsetOrder() {
    this.order = null;
  }

  /** Returns true if field order is set (has been assigned a value) and false otherwise */
  public boolean isSetOrder() {
    return this.order != null;
  }

  public void setOrderIsSet(boolean value) {
    if (!value) {
      this.order = null;
    }
  }

  public String getOrderBy() {
    return this.orderBy;
  }

  public pageOptions setOrderBy(String orderBy) {
    this.orderBy = orderBy;
    return this;
  }

  public void unsetOrderBy() {
    this.orderBy = null;
  }

  /** Returns true if field orderBy is set (has been assigned a value) and false otherwise */
  public boolean isSetOrderBy() {
    return this.orderBy != null;
  }

  public void setOrderByIsSet(boolean value) {
    if (!value) {
      this.orderBy = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PAGE_NUMBER:
      if (value == null) {
        unsetPageNumber();
      } else {
        setPageNumber((Integer)value);
      }
      break;

    case PAGE_SIZE:
      if (value == null) {
        unsetPageSize();
      } else {
        setPageSize((Integer)value);
      }
      break;

    case ORDER:
      if (value == null) {
        unsetOrder();
      } else {
        setOrder((ORDER)value);
      }
      break;

    case ORDER_BY:
      if (value == null) {
        unsetOrderBy();
      } else {
        setOrderBy((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PAGE_NUMBER:
      return Integer.valueOf(getPageNumber());

    case PAGE_SIZE:
      return Integer.valueOf(getPageSize());

    case ORDER:
      return getOrder();

    case ORDER_BY:
      return getOrderBy();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PAGE_NUMBER:
      return isSetPageNumber();
    case PAGE_SIZE:
      return isSetPageSize();
    case ORDER:
      return isSetOrder();
    case ORDER_BY:
      return isSetOrderBy();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof pageOptions)
      return this.equals((pageOptions)that);
    return false;
  }

  public boolean equals(pageOptions that) {
    if (that == null)
      return false;

    boolean this_present_pageNumber = true;
    boolean that_present_pageNumber = true;
    if (this_present_pageNumber || that_present_pageNumber) {
      if (!(this_present_pageNumber && that_present_pageNumber))
        return false;
      if (this.pageNumber != that.pageNumber)
        return false;
    }

    boolean this_present_pageSize = true;
    boolean that_present_pageSize = true;
    if (this_present_pageSize || that_present_pageSize) {
      if (!(this_present_pageSize && that_present_pageSize))
        return false;
      if (this.pageSize != that.pageSize)
        return false;
    }

    boolean this_present_order = true && this.isSetOrder();
    boolean that_present_order = true && that.isSetOrder();
    if (this_present_order || that_present_order) {
      if (!(this_present_order && that_present_order))
        return false;
      if (!this.order.equals(that.order))
        return false;
    }

    boolean this_present_orderBy = true && this.isSetOrderBy();
    boolean that_present_orderBy = true && that.isSetOrderBy();
    if (this_present_orderBy || that_present_orderBy) {
      if (!(this_present_orderBy && that_present_orderBy))
        return false;
      if (!this.orderBy.equals(that.orderBy))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(pageOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    pageOptions typedOther = (pageOptions)other;

    lastComparison = Boolean.valueOf(isSetPageNumber()).compareTo(typedOther.isSetPageNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageNumber, typedOther.pageNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageSize()).compareTo(typedOther.isSetPageSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSize, typedOther.pageSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOrder()).compareTo(typedOther.isSetOrder());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrder()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.order, typedOther.order);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOrderBy()).compareTo(typedOther.isSetOrderBy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrderBy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.orderBy, typedOther.orderBy);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("pageOptions(");
    boolean first = true;

    sb.append("pageNumber:");
    sb.append(this.pageNumber);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageSize:");
    sb.append(this.pageSize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("order:");
    if (this.order == null) {
      sb.append("null");
    } else {
      sb.append(this.order);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("orderBy:");
    if (this.orderBy == null) {
      sb.append("null");
    } else {
      sb.append(this.orderBy);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class pageOptionsStandardSchemeFactory implements SchemeFactory {
    public pageOptionsStandardScheme getScheme() {
      return new pageOptionsStandardScheme();
    }
  }

  private static class pageOptionsStandardScheme extends StandardScheme<pageOptions> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, pageOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PAGE_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageNumber = iprot.readI32();
              struct.setPageNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageSize = iprot.readI32();
              struct.setPageSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ORDER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.order = ORDER.findByValue(iprot.readI32());
              struct.setOrderIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ORDER_BY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.orderBy = iprot.readString();
              struct.setOrderByIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, pageOptions struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PAGE_NUMBER_FIELD_DESC);
      oprot.writeI32(struct.pageNumber);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAGE_SIZE_FIELD_DESC);
      oprot.writeI32(struct.pageSize);
      oprot.writeFieldEnd();
      if (struct.order != null) {
        oprot.writeFieldBegin(ORDER_FIELD_DESC);
        oprot.writeI32(struct.order.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.orderBy != null) {
        oprot.writeFieldBegin(ORDER_BY_FIELD_DESC);
        oprot.writeString(struct.orderBy);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class pageOptionsTupleSchemeFactory implements SchemeFactory {
    public pageOptionsTupleScheme getScheme() {
      return new pageOptionsTupleScheme();
    }
  }

  private static class pageOptionsTupleScheme extends TupleScheme<pageOptions> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, pageOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPageNumber()) {
        optionals.set(0);
      }
      if (struct.isSetPageSize()) {
        optionals.set(1);
      }
      if (struct.isSetOrder()) {
        optionals.set(2);
      }
      if (struct.isSetOrderBy()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetPageNumber()) {
        oprot.writeI32(struct.pageNumber);
      }
      if (struct.isSetPageSize()) {
        oprot.writeI32(struct.pageSize);
      }
      if (struct.isSetOrder()) {
        oprot.writeI32(struct.order.getValue());
      }
      if (struct.isSetOrderBy()) {
        oprot.writeString(struct.orderBy);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, pageOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.pageNumber = iprot.readI32();
        struct.setPageNumberIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pageSize = iprot.readI32();
        struct.setPageSizeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.order = ORDER.findByValue(iprot.readI32());
        struct.setOrderIsSet(true);
      }
      if (incoming.get(3)) {
        struct.orderBy = iprot.readString();
        struct.setOrderByIsSet(true);
      }
    }
  }

}

