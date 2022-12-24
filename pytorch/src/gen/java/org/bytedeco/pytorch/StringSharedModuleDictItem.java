// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

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


@Name("torch::OrderedDict<std::string,std::shared_ptr<torch::nn::Module> >::Item") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class StringSharedModuleDictItem extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringSharedModuleDictItem(Pointer p) { super(p); }

  /** Constructs a new item. */
  public StringSharedModuleDictItem(@StdString BytePointer key, @SharedPtr @Cast({"", "std::shared_ptr<torch::nn::Module>"}) Module value) { super((Pointer)null); allocate(key, value); }
  private native void allocate(@StdString BytePointer key, @SharedPtr @Cast({"", "std::shared_ptr<torch::nn::Module>"}) Module value);
  public StringSharedModuleDictItem(@StdString String key, @SharedPtr @Cast({"", "std::shared_ptr<torch::nn::Module>"}) Module value) { super((Pointer)null); allocate(key, value); }
  private native void allocate(@StdString String key, @SharedPtr @Cast({"", "std::shared_ptr<torch::nn::Module>"}) Module value);

// #if defined(__CUDACC__) && (__CUDACC_VER_MAJOR__ < 11) && defined(_MSC_VER)
  /** Related issue: https://github.com/pytorch/pytorch/issues/55266
   *  Needs to define this function for CUDA < 11.0 on Windows,
   *  although it usually won't be used actually. */
  public native @ByRef @Name("operator =") StringSharedModuleDictItem put(@Const @ByRef StringSharedModuleDictItem other);
// #endif

  /** Returns a reference to the value. */
  public native @SharedPtr @ByRef @Name("operator *") Module multiply();

  /** Returns a reference to the value. */

  /** Allows access to the value using the arrow operator. */
  public native @SharedPtr @Name("operator ->") Module access();

  /** Allows access to the value using the arrow operator. */

  /** Returns a reference to the key. */
  public native @StdString @NoException(true) BytePointer key();

  /** Returns a reference to the value. */
  public native @SharedPtr @ByRef @NoException(true) Module value();

  /** Returns a reference to the value. */

  /** Returns a {@code (key, value)} pair. */
  public native @Const @ByRef @NoException(true) StringSharedModulePair pair();
}