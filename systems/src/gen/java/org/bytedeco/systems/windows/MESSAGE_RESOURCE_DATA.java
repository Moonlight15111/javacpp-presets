// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class MESSAGE_RESOURCE_DATA extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public MESSAGE_RESOURCE_DATA() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public MESSAGE_RESOURCE_DATA(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MESSAGE_RESOURCE_DATA(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public MESSAGE_RESOURCE_DATA position(long position) {
        return (MESSAGE_RESOURCE_DATA)super.position(position);
    }

    public native @Cast("DWORD") int NumberOfBlocks(); public native MESSAGE_RESOURCE_DATA NumberOfBlocks(int setter);
    public native @ByRef MESSAGE_RESOURCE_BLOCK Blocks(int i); public native MESSAGE_RESOURCE_DATA Blocks(int i, MESSAGE_RESOURCE_BLOCK setter);
    @MemberGetter public native MESSAGE_RESOURCE_BLOCK Blocks();
}