// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.Module;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;


// A representation of a set of DispatchKeys.  A tensor may have multiple
// tensor type ids, e.g., a Variable tensor can also be a CPU tensor; the
// DispatchKeySet specifies what type ids apply.  The internal representation is
// as a 64-bit bit set (this means only 64 tensor type ids are supported).
//
// Note that DispatchKeys are ordered; thus, we can ask questions like "what is
// the highest priority DispatchKey in the set"?  (The set itself is not
// ordered; two sets with the same ids will always have the ids ordered in the
// same way.)
//
// At the moment, there are no nontrivial uses of this set; tensors are always
// singletons.  In the near future, this set will represent variable? + tensor
// type id.  In the far future, it will be requires grad? + profiling? +
// tracing? + lazy? + tensor type id.
//
// (The difference between variable and requires grad, is that
// there are currently three states a tensor can be:
//  1. Not a variable
//  2. Variable with requires_grad=False
//  3. Variable with requires_grad=True
// Eventually, we want to kill state (1), and only dispatch to autograd
// handling code if one of the inputs requires grad.)
//
// An undefined tensor is one with an empty tensor type set.
@Namespace("c10") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class DispatchKeySet extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DispatchKeySet(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DispatchKeySet(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DispatchKeySet position(long position) {
        return (DispatchKeySet)super.position(position);
    }
    @Override public DispatchKeySet getPointer(long i) {
        return new DispatchKeySet((Pointer)this).offsetAddress(i);
    }

  public enum Full { FULL(0);

      public final int value;
      private Full(int v) { this.value = v; }
      private Full(Full e) { this.value = e.value; }
      public Full intern() { for (Full e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
  public enum FullAfter { FULL_AFTER(0);

      public final int value;
      private FullAfter(int v) { this.value = v; }
      private FullAfter(FullAfter e) { this.value = e.value; }
      public FullAfter intern() { for (FullAfter e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
  public enum Raw { RAW(0);

      public final int value;
      private Raw(int v) { this.value = v; }
      private Raw(Raw e) { this.value = e.value; }
      public Raw intern() { for (Raw e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  // NB: default constructor representation as zero is MANDATORY as
  // use of DispatchKeySet in TLS requires this.
  public DispatchKeySet() { super((Pointer)null); allocate(); }
  private native void allocate();
  public DispatchKeySet(Full arg0) { super((Pointer)null); allocate(arg0); }
  private native void allocate(Full arg0);
  public DispatchKeySet(@Cast("c10::DispatchKeySet::Full") int arg0) { super((Pointer)null); allocate(arg0); }
  private native void allocate(@Cast("c10::DispatchKeySet::Full") int arg0);
  public DispatchKeySet(FullAfter arg0, DispatchKey t) { super((Pointer)null); allocate(arg0, t); }
  private native void allocate(FullAfter arg0, DispatchKey t);
  public DispatchKeySet(@Cast("c10::DispatchKeySet::FullAfter") int arg0, @Cast("c10::DispatchKey") byte t) { super((Pointer)null); allocate(arg0, t); }
  private native void allocate(@Cast("c10::DispatchKeySet::FullAfter") int arg0, @Cast("c10::DispatchKey") byte t);
  // Public version of DispatchKeySet(uint64_t) API; external users
  // must be explicit when they do this!
  public DispatchKeySet(Raw arg0, @Cast("uint64_t") long x) { super((Pointer)null); allocate(arg0, x); }
  private native void allocate(Raw arg0, @Cast("uint64_t") long x);
  public DispatchKeySet(@Cast("c10::DispatchKeySet::Raw") int arg0, @Cast("uint64_t") long x) { super((Pointer)null); allocate(arg0, x); }
  private native void allocate(@Cast("c10::DispatchKeySet::Raw") int arg0, @Cast("uint64_t") long x);
  public DispatchKeySet(DispatchKey t) { super((Pointer)null); allocate(t); }
  private native void allocate(DispatchKey t);
  public DispatchKeySet(@Cast("c10::DispatchKey") byte t) { super((Pointer)null); allocate(t); }
  private native void allocate(@Cast("c10::DispatchKey") byte t);
  // Test if a DispatchKey is in the set
  public native @Cast("bool") boolean has(DispatchKey t);
  public native @Cast("bool") boolean has(@Cast("c10::DispatchKey") byte t);
  // Test if DispatchKeySet is a superset of ks.
  public native @Cast("bool") boolean isSupersetOf(@ByVal DispatchKeySet ks);
  // Perform set union
  public native @Const @ByVal @Name("operator |") DispatchKeySet or(@ByVal DispatchKeySet other);
  // Perform set intersection
  public native @ByVal @Name("operator &") DispatchKeySet and(@ByVal DispatchKeySet other);
  // Compute the set difference self - other
  public native @ByVal @Name("operator -") DispatchKeySet subtract(@ByVal DispatchKeySet other);
  // Perform set equality
  
  // Add a DispatchKey to the DispatchKey set.  Does NOT mutate,
  // returns the extended DispatchKeySet!
  public native @ByVal DispatchKeySet add(DispatchKey t);
  public native @ByVal DispatchKeySet add(@Cast("c10::DispatchKey") byte t);
  // Remove a DispatchKey from the DispatchKey set.  This is
  // generally not an operation you should be doing (it's
  // used to implement operator<<)
  public native @ByVal DispatchKeySet remove(DispatchKey t);
  public native @ByVal DispatchKeySet remove(@Cast("c10::DispatchKey") byte t);
  // Is the set empty?  (AKA undefined tensor)
  public native @Cast("bool") boolean empty();
  public native @Cast("uint64_t") long raw_repr();
  // Return the type id in this set with the highest priority (i.e.,
  // is the largest in the DispatchKey enum).  Intuitively, this
  // type id is the one that should handle dispatch (assuming there
  // aren't any further exclusions or inclusions).
  public native DispatchKey highestPriorityTypeId();

  public native DispatchKey highestPriorityBackendTypeId();
  // STL iterator for DispatchKeySet. Iterates through all DispatchKeys in the
  // set. The iterator is only invalidated by the destruction of the underlying
  // DispatchKeySet as the iterator stores a pointer to the raw representation of
  // the DispatchKeySet.
  @NoOffset public static class iterator extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public iterator(Pointer p) { super(p); }
  

    public iterator(@Cast("const uint64_t*") LongPointer data_ptr, @Cast("uint8_t") byte i/*=0*/) { super((Pointer)null); allocate(data_ptr, i); }
    private native void allocate(@Cast("const uint64_t*") LongPointer data_ptr, @Cast("uint8_t") byte i/*=0*/);
    public iterator(@Cast("const uint64_t*") LongPointer data_ptr) { super((Pointer)null); allocate(data_ptr); }
    private native void allocate(@Cast("const uint64_t*") LongPointer data_ptr);
    public iterator(@Cast("const uint64_t*") LongBuffer data_ptr, @Cast("uint8_t") byte i/*=0*/) { super((Pointer)null); allocate(data_ptr, i); }
    private native void allocate(@Cast("const uint64_t*") LongBuffer data_ptr, @Cast("uint8_t") byte i/*=0*/);
    public iterator(@Cast("const uint64_t*") LongBuffer data_ptr) { super((Pointer)null); allocate(data_ptr); }
    private native void allocate(@Cast("const uint64_t*") LongBuffer data_ptr);
    public iterator(@Cast("const uint64_t*") long[] data_ptr, @Cast("uint8_t") byte i/*=0*/) { super((Pointer)null); allocate(data_ptr, i); }
    private native void allocate(@Cast("const uint64_t*") long[] data_ptr, @Cast("uint8_t") byte i/*=0*/);
    public iterator(@Cast("const uint64_t*") long[] data_ptr) { super((Pointer)null); allocate(data_ptr); }
    private native void allocate(@Cast("const uint64_t*") long[] data_ptr);

    public native @Cast("c10::DispatchKeySet::iterator::self_type*") @ByRef @Name("operator ++") iterator increment();

    public native @ByVal @Cast("c10::DispatchKeySet::iterator::self_type*") @Name("operator ++") iterator increment(int arg0);

    
    
    public native @Name("operator *") DispatchKey multiply();
  }
  // Returns iterator to the first key in the set. If no keys are in the
  // set, then will return the end iterator.
  public native @ByVal iterator begin();

  // We do not need to iterate beyond NumDispatchKeys so we will treat this as
  // the end iterator. NumDispatchKeys will always be strictly less than 64.
  public native @ByVal iterator end();

}