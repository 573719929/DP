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

public class reportResult implements org.apache.thrift.TBase<reportResult, reportResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("reportResult");

  private static final org.apache.thrift.protocol.TField TOTAL_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("totalSize", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CURRENT_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("currentSize", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TOTAL_PAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("totalPage", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField PAGE_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("pageNumber", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new reportResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new reportResultTupleSchemeFactory());
  }

  public int totalSize; // required
  public int currentSize; // required
  public int totalPage; // required
  public int pageNumber; // required
  public List<Response> data; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL_SIZE((short)1, "totalSize"),
    CURRENT_SIZE((short)2, "currentSize"),
    TOTAL_PAGE((short)3, "totalPage"),
    PAGE_NUMBER((short)4, "pageNumber"),
    DATA((short)5, "data");

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
        case 1: // TOTAL_SIZE
          return TOTAL_SIZE;
        case 2: // CURRENT_SIZE
          return CURRENT_SIZE;
        case 3: // TOTAL_PAGE
          return TOTAL_PAGE;
        case 4: // PAGE_NUMBER
          return PAGE_NUMBER;
        case 5: // DATA
          return DATA;
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
  private static final int __TOTALSIZE_ISSET_ID = 0;
  private static final int __CURRENTSIZE_ISSET_ID = 1;
  private static final int __TOTALPAGE_ISSET_ID = 2;
  private static final int __PAGENUMBER_ISSET_ID = 3;
  private BitSet __isset_bit_vector = new BitSet(4);
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL_SIZE, new org.apache.thrift.meta_data.FieldMetaData("totalSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CURRENT_SIZE, new org.apache.thrift.meta_data.FieldMetaData("currentSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOTAL_PAGE, new org.apache.thrift.meta_data.FieldMetaData("totalPage", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("pageNumber", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Response.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(reportResult.class, metaDataMap);
  }

  public reportResult() {
  }

  public reportResult(
    int totalSize,
    int currentSize,
    int totalPage,
    int pageNumber,
    List<Response> data)
  {
    this();
    this.totalSize = totalSize;
    setTotalSizeIsSet(true);
    this.currentSize = currentSize;
    setCurrentSizeIsSet(true);
    this.totalPage = totalPage;
    setTotalPageIsSet(true);
    this.pageNumber = pageNumber;
    setPageNumberIsSet(true);
    this.data = data;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public reportResult(reportResult other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.totalSize = other.totalSize;
    this.currentSize = other.currentSize;
    this.totalPage = other.totalPage;
    this.pageNumber = other.pageNumber;
    if (other.isSetData()) {
      List<Response> __this__data = new ArrayList<Response>();
      for (Response other_element : other.data) {
        __this__data.add(new Response(other_element));
      }
      this.data = __this__data;
    }
  }

  public reportResult deepCopy() {
    return new reportResult(this);
  }

  @Override
  public void clear() {
    setTotalSizeIsSet(false);
    this.totalSize = 0;
    setCurrentSizeIsSet(false);
    this.currentSize = 0;
    setTotalPageIsSet(false);
    this.totalPage = 0;
    setPageNumberIsSet(false);
    this.pageNumber = 0;
    this.data = null;
  }

  public int getTotalSize() {
    return this.totalSize;
  }

  public reportResult setTotalSize(int totalSize) {
    this.totalSize = totalSize;
    setTotalSizeIsSet(true);
    return this;
  }

  public void unsetTotalSize() {
    __isset_bit_vector.clear(__TOTALSIZE_ISSET_ID);
  }

  /** Returns true if field totalSize is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalSize() {
    return __isset_bit_vector.get(__TOTALSIZE_ISSET_ID);
  }

  public void setTotalSizeIsSet(boolean value) {
    __isset_bit_vector.set(__TOTALSIZE_ISSET_ID, value);
  }

  public int getCurrentSize() {
    return this.currentSize;
  }

  public reportResult setCurrentSize(int currentSize) {
    this.currentSize = currentSize;
    setCurrentSizeIsSet(true);
    return this;
  }

  public void unsetCurrentSize() {
    __isset_bit_vector.clear(__CURRENTSIZE_ISSET_ID);
  }

  /** Returns true if field currentSize is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrentSize() {
    return __isset_bit_vector.get(__CURRENTSIZE_ISSET_ID);
  }

  public void setCurrentSizeIsSet(boolean value) {
    __isset_bit_vector.set(__CURRENTSIZE_ISSET_ID, value);
  }

  public int getTotalPage() {
    return this.totalPage;
  }

  public reportResult setTotalPage(int totalPage) {
    this.totalPage = totalPage;
    setTotalPageIsSet(true);
    return this;
  }

  public void unsetTotalPage() {
    __isset_bit_vector.clear(__TOTALPAGE_ISSET_ID);
  }

  /** Returns true if field totalPage is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalPage() {
    return __isset_bit_vector.get(__TOTALPAGE_ISSET_ID);
  }

  public void setTotalPageIsSet(boolean value) {
    __isset_bit_vector.set(__TOTALPAGE_ISSET_ID, value);
  }

  public int getPageNumber() {
    return this.pageNumber;
  }

  public reportResult setPageNumber(int pageNumber) {
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

  public int getDataSize() {
    return (this.data == null) ? 0 : this.data.size();
  }

  public java.util.Iterator<Response> getDataIterator() {
    return (this.data == null) ? null : this.data.iterator();
  }

  public void addToData(Response elem) {
    if (this.data == null) {
      this.data = new ArrayList<Response>();
    }
    this.data.add(elem);
  }

  public List<Response> getData() {
    return this.data;
  }

  public reportResult setData(List<Response> data) {
    this.data = data;
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOTAL_SIZE:
      if (value == null) {
        unsetTotalSize();
      } else {
        setTotalSize((Integer)value);
      }
      break;

    case CURRENT_SIZE:
      if (value == null) {
        unsetCurrentSize();
      } else {
        setCurrentSize((Integer)value);
      }
      break;

    case TOTAL_PAGE:
      if (value == null) {
        unsetTotalPage();
      } else {
        setTotalPage((Integer)value);
      }
      break;

    case PAGE_NUMBER:
      if (value == null) {
        unsetPageNumber();
      } else {
        setPageNumber((Integer)value);
      }
      break;

    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((List<Response>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL_SIZE:
      return Integer.valueOf(getTotalSize());

    case CURRENT_SIZE:
      return Integer.valueOf(getCurrentSize());

    case TOTAL_PAGE:
      return Integer.valueOf(getTotalPage());

    case PAGE_NUMBER:
      return Integer.valueOf(getPageNumber());

    case DATA:
      return getData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOTAL_SIZE:
      return isSetTotalSize();
    case CURRENT_SIZE:
      return isSetCurrentSize();
    case TOTAL_PAGE:
      return isSetTotalPage();
    case PAGE_NUMBER:
      return isSetPageNumber();
    case DATA:
      return isSetData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof reportResult)
      return this.equals((reportResult)that);
    return false;
  }

  public boolean equals(reportResult that) {
    if (that == null)
      return false;

    boolean this_present_totalSize = true;
    boolean that_present_totalSize = true;
    if (this_present_totalSize || that_present_totalSize) {
      if (!(this_present_totalSize && that_present_totalSize))
        return false;
      if (this.totalSize != that.totalSize)
        return false;
    }

    boolean this_present_currentSize = true;
    boolean that_present_currentSize = true;
    if (this_present_currentSize || that_present_currentSize) {
      if (!(this_present_currentSize && that_present_currentSize))
        return false;
      if (this.currentSize != that.currentSize)
        return false;
    }

    boolean this_present_totalPage = true;
    boolean that_present_totalPage = true;
    if (this_present_totalPage || that_present_totalPage) {
      if (!(this_present_totalPage && that_present_totalPage))
        return false;
      if (this.totalPage != that.totalPage)
        return false;
    }

    boolean this_present_pageNumber = true;
    boolean that_present_pageNumber = true;
    if (this_present_pageNumber || that_present_pageNumber) {
      if (!(this_present_pageNumber && that_present_pageNumber))
        return false;
      if (this.pageNumber != that.pageNumber)
        return false;
    }

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(reportResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    reportResult typedOther = (reportResult)other;

    lastComparison = Boolean.valueOf(isSetTotalSize()).compareTo(typedOther.isSetTotalSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalSize, typedOther.totalSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCurrentSize()).compareTo(typedOther.isSetCurrentSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrentSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.currentSize, typedOther.currentSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalPage()).compareTo(typedOther.isSetTotalPage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalPage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalPage, typedOther.totalPage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetData()).compareTo(typedOther.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, typedOther.data);
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
    StringBuilder sb = new StringBuilder("reportResult(");
    boolean first = true;

    sb.append("totalSize:");
    sb.append(this.totalSize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("currentSize:");
    sb.append(this.currentSize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalPage:");
    sb.append(this.totalPage);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageNumber:");
    sb.append(this.pageNumber);
    first = false;
    if (!first) sb.append(", ");
    sb.append("data:");
    if (this.data == null) {
      sb.append("null");
    } else {
      sb.append(this.data);
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

  private static class reportResultStandardSchemeFactory implements SchemeFactory {
    public reportResultStandardScheme getScheme() {
      return new reportResultStandardScheme();
    }
  }

  private static class reportResultStandardScheme extends StandardScheme<reportResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, reportResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOTAL_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalSize = iprot.readI32();
              struct.setTotalSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CURRENT_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.currentSize = iprot.readI32();
              struct.setCurrentSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TOTAL_PAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalPage = iprot.readI32();
              struct.setTotalPageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PAGE_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageNumber = iprot.readI32();
              struct.setPageNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.data = new ArrayList<Response>(_list8.size);
                for (int _i9 = 0; _i9 < _list8.size; ++_i9)
                {
                  Response _elem10; // required
                  _elem10 = new Response();
                  _elem10.read(iprot);
                  struct.data.add(_elem10);
                }
                iprot.readListEnd();
              }
              struct.setDataIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, reportResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TOTAL_SIZE_FIELD_DESC);
      oprot.writeI32(struct.totalSize);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CURRENT_SIZE_FIELD_DESC);
      oprot.writeI32(struct.currentSize);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_PAGE_FIELD_DESC);
      oprot.writeI32(struct.totalPage);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAGE_NUMBER_FIELD_DESC);
      oprot.writeI32(struct.pageNumber);
      oprot.writeFieldEnd();
      if (struct.data != null) {
        oprot.writeFieldBegin(DATA_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.data.size()));
          for (Response _iter11 : struct.data)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class reportResultTupleSchemeFactory implements SchemeFactory {
    public reportResultTupleScheme getScheme() {
      return new reportResultTupleScheme();
    }
  }

  private static class reportResultTupleScheme extends TupleScheme<reportResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, reportResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTotalSize()) {
        optionals.set(0);
      }
      if (struct.isSetCurrentSize()) {
        optionals.set(1);
      }
      if (struct.isSetTotalPage()) {
        optionals.set(2);
      }
      if (struct.isSetPageNumber()) {
        optionals.set(3);
      }
      if (struct.isSetData()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTotalSize()) {
        oprot.writeI32(struct.totalSize);
      }
      if (struct.isSetCurrentSize()) {
        oprot.writeI32(struct.currentSize);
      }
      if (struct.isSetTotalPage()) {
        oprot.writeI32(struct.totalPage);
      }
      if (struct.isSetPageNumber()) {
        oprot.writeI32(struct.pageNumber);
      }
      if (struct.isSetData()) {
        {
          oprot.writeI32(struct.data.size());
          for (Response _iter12 : struct.data)
          {
            _iter12.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, reportResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.totalSize = iprot.readI32();
        struct.setTotalSizeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.currentSize = iprot.readI32();
        struct.setCurrentSizeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.totalPage = iprot.readI32();
        struct.setTotalPageIsSet(true);
      }
      if (incoming.get(3)) {
        struct.pageNumber = iprot.readI32();
        struct.setPageNumberIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.data = new ArrayList<Response>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            Response _elem15; // required
            _elem15 = new Response();
            _elem15.read(iprot);
            struct.data.add(_elem15);
          }
        }
        struct.setDataIsSet(true);
      }
    }
  }

}
