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

public class queryOptions implements org.apache.thrift.TBase<queryOptions, queryOptions._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("queryOptions");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField START_AT_FIELD_DESC = new org.apache.thrift.protocol.TField("startAt", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField END_AT_FIELD_DESC = new org.apache.thrift.protocol.TField("endAt", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField AREAID_FIELD_DESC = new org.apache.thrift.protocol.TField("areaid", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField SOURCE_FIELD_DESC = new org.apache.thrift.protocol.TField("source", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new queryOptionsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new queryOptionsTupleSchemeFactory());
  }

  public String id; // required
  public String startAt; // required
  public String endAt; // required
  public List<String> areaid; // required
  /**
   * 
   * @see com.adp.java.FlowSrc
   */
  public com.adp.java.FlowSrc source; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    START_AT((short)2, "startAt"),
    END_AT((short)3, "endAt"),
    AREAID((short)4, "areaid"),
    /**
     * 
     * @see com.adp.java.FlowSrc
     */
    SOURCE((short)5, "source");

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
        case 1: // ID
          return ID;
        case 2: // START_AT
          return START_AT;
        case 3: // END_AT
          return END_AT;
        case 4: // AREAID
          return AREAID;
        case 5: // SOURCE
          return SOURCE;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.START_AT, new org.apache.thrift.meta_data.FieldMetaData("startAt", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.END_AT, new org.apache.thrift.meta_data.FieldMetaData("endAt", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AREAID, new org.apache.thrift.meta_data.FieldMetaData("areaid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.SOURCE, new org.apache.thrift.meta_data.FieldMetaData("source", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.adp.java.FlowSrc.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryOptions.class, metaDataMap);
  }

  public queryOptions() {
    this.areaid = new ArrayList<String>();

    this.source = com.adp.java.FlowSrc.all;

  }

  public queryOptions(
    String id,
    String startAt,
    String endAt,
    List<String> areaid,
    com.adp.java.FlowSrc source)
  {
    this();
    this.id = id;
    this.startAt = startAt;
    this.endAt = endAt;
    this.areaid = areaid;
    this.source = source;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public queryOptions(queryOptions other) {
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetStartAt()) {
      this.startAt = other.startAt;
    }
    if (other.isSetEndAt()) {
      this.endAt = other.endAt;
    }
    if (other.isSetAreaid()) {
      List<String> __this__areaid = new ArrayList<String>();
      for (String other_element : other.areaid) {
        __this__areaid.add(other_element);
      }
      this.areaid = __this__areaid;
    }
    if (other.isSetSource()) {
      this.source = other.source;
    }
  }

  public queryOptions deepCopy() {
    return new queryOptions(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.startAt = null;
    this.endAt = null;
    this.areaid = new ArrayList<String>();

    this.source = com.adp.java.FlowSrc.all;

  }

  public String getId() {
    return this.id;
  }

  public queryOptions setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public String getStartAt() {
    return this.startAt;
  }

  public queryOptions setStartAt(String startAt) {
    this.startAt = startAt;
    return this;
  }

  public void unsetStartAt() {
    this.startAt = null;
  }

  /** Returns true if field startAt is set (has been assigned a value) and false otherwise */
  public boolean isSetStartAt() {
    return this.startAt != null;
  }

  public void setStartAtIsSet(boolean value) {
    if (!value) {
      this.startAt = null;
    }
  }

  public String getEndAt() {
    return this.endAt;
  }

  public queryOptions setEndAt(String endAt) {
    this.endAt = endAt;
    return this;
  }

  public void unsetEndAt() {
    this.endAt = null;
  }

  /** Returns true if field endAt is set (has been assigned a value) and false otherwise */
  public boolean isSetEndAt() {
    return this.endAt != null;
  }

  public void setEndAtIsSet(boolean value) {
    if (!value) {
      this.endAt = null;
    }
  }

  public int getAreaidSize() {
    return (this.areaid == null) ? 0 : this.areaid.size();
  }

  public java.util.Iterator<String> getAreaidIterator() {
    return (this.areaid == null) ? null : this.areaid.iterator();
  }

  public void addToAreaid(String elem) {
    if (this.areaid == null) {
      this.areaid = new ArrayList<String>();
    }
    this.areaid.add(elem);
  }

  public List<String> getAreaid() {
    return this.areaid;
  }

  public queryOptions setAreaid(List<String> areaid) {
    this.areaid = areaid;
    return this;
  }

  public void unsetAreaid() {
    this.areaid = null;
  }

  /** Returns true if field areaid is set (has been assigned a value) and false otherwise */
  public boolean isSetAreaid() {
    return this.areaid != null;
  }

  public void setAreaidIsSet(boolean value) {
    if (!value) {
      this.areaid = null;
    }
  }

  /**
   * 
   * @see com.adp.java.FlowSrc
   */
  public com.adp.java.FlowSrc getSource() {
    return this.source;
  }

  /**
   * 
   * @see com.adp.java.FlowSrc
   */
  public queryOptions setSource(com.adp.java.FlowSrc source) {
    this.source = source;
    return this;
  }

  public void unsetSource() {
    this.source = null;
  }

  /** Returns true if field source is set (has been assigned a value) and false otherwise */
  public boolean isSetSource() {
    return this.source != null;
  }

  public void setSourceIsSet(boolean value) {
    if (!value) {
      this.source = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    case START_AT:
      if (value == null) {
        unsetStartAt();
      } else {
        setStartAt((String)value);
      }
      break;

    case END_AT:
      if (value == null) {
        unsetEndAt();
      } else {
        setEndAt((String)value);
      }
      break;

    case AREAID:
      if (value == null) {
        unsetAreaid();
      } else {
        setAreaid((List<String>)value);
      }
      break;

    case SOURCE:
      if (value == null) {
        unsetSource();
      } else {
        setSource((com.adp.java.FlowSrc)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case START_AT:
      return getStartAt();

    case END_AT:
      return getEndAt();

    case AREAID:
      return getAreaid();

    case SOURCE:
      return getSource();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case START_AT:
      return isSetStartAt();
    case END_AT:
      return isSetEndAt();
    case AREAID:
      return isSetAreaid();
    case SOURCE:
      return isSetSource();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof queryOptions)
      return this.equals((queryOptions)that);
    return false;
  }

  public boolean equals(queryOptions that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_startAt = true && this.isSetStartAt();
    boolean that_present_startAt = true && that.isSetStartAt();
    if (this_present_startAt || that_present_startAt) {
      if (!(this_present_startAt && that_present_startAt))
        return false;
      if (!this.startAt.equals(that.startAt))
        return false;
    }

    boolean this_present_endAt = true && this.isSetEndAt();
    boolean that_present_endAt = true && that.isSetEndAt();
    if (this_present_endAt || that_present_endAt) {
      if (!(this_present_endAt && that_present_endAt))
        return false;
      if (!this.endAt.equals(that.endAt))
        return false;
    }

    boolean this_present_areaid = true && this.isSetAreaid();
    boolean that_present_areaid = true && that.isSetAreaid();
    if (this_present_areaid || that_present_areaid) {
      if (!(this_present_areaid && that_present_areaid))
        return false;
      if (!this.areaid.equals(that.areaid))
        return false;
    }

    boolean this_present_source = true && this.isSetSource();
    boolean that_present_source = true && that.isSetSource();
    if (this_present_source || that_present_source) {
      if (!(this_present_source && that_present_source))
        return false;
      if (!this.source.equals(that.source))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(queryOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    queryOptions typedOther = (queryOptions)other;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStartAt()).compareTo(typedOther.isSetStartAt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartAt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startAt, typedOther.startAt);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEndAt()).compareTo(typedOther.isSetEndAt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndAt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endAt, typedOther.endAt);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAreaid()).compareTo(typedOther.isSetAreaid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAreaid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.areaid, typedOther.areaid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSource()).compareTo(typedOther.isSetSource());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSource()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.source, typedOther.source);
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
    StringBuilder sb = new StringBuilder("queryOptions(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("startAt:");
    if (this.startAt == null) {
      sb.append("null");
    } else {
      sb.append(this.startAt);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("endAt:");
    if (this.endAt == null) {
      sb.append("null");
    } else {
      sb.append(this.endAt);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("areaid:");
    if (this.areaid == null) {
      sb.append("null");
    } else {
      sb.append(this.areaid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("source:");
    if (this.source == null) {
      sb.append("null");
    } else {
      sb.append(this.source);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class queryOptionsStandardSchemeFactory implements SchemeFactory {
    public queryOptionsStandardScheme getScheme() {
      return new queryOptionsStandardScheme();
    }
  }

  private static class queryOptionsStandardScheme extends StandardScheme<queryOptions> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, queryOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // START_AT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.startAt = iprot.readString();
              struct.setStartAtIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // END_AT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.endAt = iprot.readString();
              struct.setEndAtIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // AREAID
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.areaid = new ArrayList<String>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  String _elem2; // required
                  _elem2 = iprot.readString();
                  struct.areaid.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setAreaidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SOURCE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.source = com.adp.java.FlowSrc.findByValue(iprot.readI32());
              struct.setSourceIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, queryOptions struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.startAt != null) {
        oprot.writeFieldBegin(START_AT_FIELD_DESC);
        oprot.writeString(struct.startAt);
        oprot.writeFieldEnd();
      }
      if (struct.endAt != null) {
        oprot.writeFieldBegin(END_AT_FIELD_DESC);
        oprot.writeString(struct.endAt);
        oprot.writeFieldEnd();
      }
      if (struct.areaid != null) {
        oprot.writeFieldBegin(AREAID_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.areaid.size()));
          for (String _iter3 : struct.areaid)
          {
            oprot.writeString(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.source != null) {
        oprot.writeFieldBegin(SOURCE_FIELD_DESC);
        oprot.writeI32(struct.source.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class queryOptionsTupleSchemeFactory implements SchemeFactory {
    public queryOptionsTupleScheme getScheme() {
      return new queryOptionsTupleScheme();
    }
  }

  private static class queryOptionsTupleScheme extends TupleScheme<queryOptions> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, queryOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetStartAt()) {
        optionals.set(1);
      }
      if (struct.isSetEndAt()) {
        optionals.set(2);
      }
      if (struct.isSetAreaid()) {
        optionals.set(3);
      }
      if (struct.isSetSource()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetStartAt()) {
        oprot.writeString(struct.startAt);
      }
      if (struct.isSetEndAt()) {
        oprot.writeString(struct.endAt);
      }
      if (struct.isSetAreaid()) {
        {
          oprot.writeI32(struct.areaid.size());
          for (String _iter4 : struct.areaid)
          {
            oprot.writeString(_iter4);
          }
        }
      }
      if (struct.isSetSource()) {
        oprot.writeI32(struct.source.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, queryOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.startAt = iprot.readString();
        struct.setStartAtIsSet(true);
      }
      if (incoming.get(2)) {
        struct.endAt = iprot.readString();
        struct.setEndAtIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.areaid = new ArrayList<String>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            String _elem7; // required
            _elem7 = iprot.readString();
            struct.areaid.add(_elem7);
          }
        }
        struct.setAreaidIsSet(true);
      }
      if (incoming.get(4)) {
        struct.source = com.adp.java.FlowSrc.findByValue(iprot.readI32());
        struct.setSourceIsSet(true);
      }
    }
  }

}
