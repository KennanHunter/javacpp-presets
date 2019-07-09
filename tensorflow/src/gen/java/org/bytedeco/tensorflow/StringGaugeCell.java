// Targeted by JavaCPP version 1.5.1: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@Name("tensorflow::monitoring::GaugeCell<tensorflow::string>") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class StringGaugeCell extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringGaugeCell(Pointer p) { super(p); }

  public StringGaugeCell(@StdString BytePointer value) { super((Pointer)null); allocate(value); }
  private native void allocate(@StdString BytePointer value);
  public StringGaugeCell(@StdString String value) { super((Pointer)null); allocate(value); }
  private native void allocate(@StdString String value);

  // Atomically sets the value.
  public native void Set(@StdString BytePointer value);
  public native void Set(@StdString String value);

  // Retrieves the current value.
  public native @StdString BytePointer value();
}