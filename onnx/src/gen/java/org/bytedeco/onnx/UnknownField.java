// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;


// #if GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
// #endif  // GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER

// Represents one field in an UnknownFieldSet.
@Namespace("google::protobuf") @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class UnknownField extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public UnknownField() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public UnknownField(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public UnknownField(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public UnknownField position(long position) {
        return (UnknownField)super.position(position);
    }

  /** enum google::protobuf::UnknownField::Type */
  public static final int
    TYPE_VARINT = 0,
    TYPE_FIXED32 = 1,
    TYPE_FIXED64 = 2,
    TYPE_LENGTH_DELIMITED = 3,
    TYPE_GROUP = 4;

  // The field's field number, as seen on the wire.
  public native int number();

  // The field type.
  public native @Cast("google::protobuf::UnknownField::Type") int type();

  // Accessors -------------------------------------------------------
  // Each method works only for UnknownFields of the corresponding type.

  public native @Cast("google::protobuf::uint64") long varint();
  public native @Cast("google::protobuf::uint32") int fixed32();
  public native @Cast("google::protobuf::uint64") long fixed64();
  public native @StdString BytePointer length_delimited();
  public native @Const @ByRef UnknownFieldSet group();

  public native void set_varint(@Cast("google::protobuf::uint64") long value);
  public native void set_fixed32(@Cast("google::protobuf::uint32") int value);
  public native void set_fixed64(@Cast("google::protobuf::uint64") long value);
  public native void set_length_delimited(@StdString BytePointer value);
  public native void set_length_delimited(@StdString String value);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_length_delimited();
  public native UnknownFieldSet mutable_group();

  // Serialization API.
  // These methods can take advantage of the underlying implementation and may
  // archieve a better performance than using getters to retrieve the data and
  // do the serialization yourself.
  public native void SerializeLengthDelimitedNoTag(CodedOutputStream output);
  public native @Cast("google::protobuf::uint8*") BytePointer SerializeLengthDelimitedNoTagToArray(@Cast("google::protobuf::uint8*") BytePointer target);
  public native @Cast("google::protobuf::uint8*") ByteBuffer SerializeLengthDelimitedNoTagToArray(@Cast("google::protobuf::uint8*") ByteBuffer target);
  public native @Cast("google::protobuf::uint8*") byte[] SerializeLengthDelimitedNoTagToArray(@Cast("google::protobuf::uint8*") byte[] target);

  public native @Cast("size_t") long GetLengthDelimitedSize();


  // If this UnknownField contains a pointer, delete it.
  public native void Delete();

  // Make a deep copy of any pointers in this UnknownField.
  public native void DeepCopy(@Const @ByRef UnknownField other);

  // Set the wire type of this UnknownField. Should only be used when this
  // UnknownField is being created.
  public native void SetType(@Cast("google::protobuf::UnknownField::Type") int type);

  public native @Cast("google::protobuf::uint32") int number_(); public native UnknownField number_(int setter);
  public native @Cast("google::protobuf::uint32") int type_(); public native UnknownField type_(int setter);
    @Name("data_.varint_") public native @Cast("google::protobuf::uint64") long data__varint_(); public native UnknownField data__varint_(long setter);
    @Name("data_.fixed32_") public native @Cast("google::protobuf::uint32") int data__fixed32_(); public native UnknownField data__fixed32_(int setter);
    @Name("data_.fixed64_") public native @Cast("google::protobuf::uint64") long data__fixed64_(); public native UnknownField data__fixed64_(long setter);
    @Name("data_.group_") public native UnknownFieldSet data__group_(); public native UnknownField data__group_(UnknownFieldSet setter);
}