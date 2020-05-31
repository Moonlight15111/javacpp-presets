// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


// Base class for logical schema types. A type has a name, repetition level,
// and optionally a logical type (ConvertedType in Parquet metadata parlance)
@Namespace("parquet::schema") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class Node extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Node(Pointer p) { super(p); }

  public enum type { PRIMITIVE(0), GROUP(1);

      public final int value;
      private type(int v) { this.value = v; }
      private type(type e) { this.value = e.value; }
      public type intern() { for (type e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  public native @Cast("bool") boolean is_primitive();

  public native @Cast("bool") boolean is_group();

  public native @Cast("bool") boolean is_optional();

  public native @Cast("bool") boolean is_repeated();

  public native @Cast("bool") boolean is_required();

  public native @Cast("bool") boolean Equals(@Const Node other);

  public native @StdString String name();

  public native type node_type();

  public native Repetition.type repetition();

  public native ConvertedType.type converted_type();

  public native @Const @Cast("const parquet::LogicalType*") @SharedPtr @ByRef LogicalType logical_type();

  /** \brief The field_id value for the serialized SchemaElement. If the
   *  field_id is less than 0 (e.g. -1), it will not be set when serialized to
   *  Thrift. */
  public native int field_id();

  public native @Deprecated int id();

  public native @Const Node parent();

  public native @SharedPtr ColumnPath path();

  public native void ToParquet(Pointer element);

  // Node::Visitor abstract class for walking schemas with the visitor pattern
  public static class Visitor extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Visitor(Pointer p) { super(p); }
  

    public native void Visit(Node node);
  }
  public static class ConstVisitor extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public ConstVisitor(Pointer p) { super(p); }
  

    public native void Visit(@Const Node node);
  }

  public native void Visit(Visitor visitor);
  public native void VisitConst(ConstVisitor visitor);
}