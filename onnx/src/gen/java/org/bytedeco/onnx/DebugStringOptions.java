// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;


// Options when generating machine-parsable output from a descriptor with
// DebugString().
@Namespace("google::protobuf") @NoOffset @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class DebugStringOptions extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DebugStringOptions(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DebugStringOptions(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DebugStringOptions position(long position) {
        return (DebugStringOptions)super.position(position);
    }

  // include original user comments as recorded in SourceLocation entries. N.B.
  // that this must be |false| by default: several other pieces of code (for
  // example, the C++ code generation for fields in the proto compiler) rely on
  // DebugString() output being unobstructed by user comments.
  public native @Cast("bool") boolean include_comments(); public native DebugStringOptions include_comments(boolean setter);
  // If true, elide the braced body in the debug string.
  public native @Cast("bool") boolean elide_group_body(); public native DebugStringOptions elide_group_body(boolean setter);
  public native @Cast("bool") boolean elide_oneof_body(); public native DebugStringOptions elide_oneof_body(boolean setter);

  public DebugStringOptions() { super((Pointer)null); allocate(); }
  private native void allocate();
}