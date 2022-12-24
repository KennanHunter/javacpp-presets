// Targeted by JavaCPP version 1.5.8: DO NOT EDIT THIS FILE

package org.bytedeco.bullet.BulletSoftBody;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.bullet.LinearMath.*;
import static org.bytedeco.bullet.global.LinearMath.*;
import org.bytedeco.bullet.BulletCollision.*;
import static org.bytedeco.bullet.global.BulletCollision.*;
import org.bytedeco.bullet.BulletDynamics.*;
import static org.bytedeco.bullet.global.BulletDynamics.*;

import static org.bytedeco.bullet.global.BulletSoftBody.*;


@NoOffset @Properties(inherit = org.bytedeco.bullet.presets.BulletSoftBody.class)
public class btCPUVertexBufferDescriptor extends btVertexBufferDescriptor {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public btCPUVertexBufferDescriptor(Pointer p) { super(p); }

	/**
	 * vertexBasePointer is pointer to beginning of the buffer.
	 * vertexOffset is the offset in floats to the first vertex.
	 * vertexStride is the stride in floats between vertices.
	 */
	public btCPUVertexBufferDescriptor(FloatPointer basePointer, int vertexOffset, int vertexStride) { super((Pointer)null); allocate(basePointer, vertexOffset, vertexStride); }
	private native void allocate(FloatPointer basePointer, int vertexOffset, int vertexStride);
	public btCPUVertexBufferDescriptor(FloatBuffer basePointer, int vertexOffset, int vertexStride) { super((Pointer)null); allocate(basePointer, vertexOffset, vertexStride); }
	private native void allocate(FloatBuffer basePointer, int vertexOffset, int vertexStride);
	public btCPUVertexBufferDescriptor(float[] basePointer, int vertexOffset, int vertexStride) { super((Pointer)null); allocate(basePointer, vertexOffset, vertexStride); }
	private native void allocate(float[] basePointer, int vertexOffset, int vertexStride);

	/**
	 * vertexBasePointer is pointer to beginning of the buffer.
	 * vertexOffset is the offset in floats to the first vertex.
	 * vertexStride is the stride in floats between vertices.
	 */
	public btCPUVertexBufferDescriptor(FloatPointer basePointer, int vertexOffset, int vertexStride, int normalOffset, int normalStride) { super((Pointer)null); allocate(basePointer, vertexOffset, vertexStride, normalOffset, normalStride); }
	private native void allocate(FloatPointer basePointer, int vertexOffset, int vertexStride, int normalOffset, int normalStride);
	public btCPUVertexBufferDescriptor(FloatBuffer basePointer, int vertexOffset, int vertexStride, int normalOffset, int normalStride) { super((Pointer)null); allocate(basePointer, vertexOffset, vertexStride, normalOffset, normalStride); }
	private native void allocate(FloatBuffer basePointer, int vertexOffset, int vertexStride, int normalOffset, int normalStride);
	public btCPUVertexBufferDescriptor(float[] basePointer, int vertexOffset, int vertexStride, int normalOffset, int normalStride) { super((Pointer)null); allocate(basePointer, vertexOffset, vertexStride, normalOffset, normalStride); }
	private native void allocate(float[] basePointer, int vertexOffset, int vertexStride, int normalOffset, int normalStride);

	/**
	 * Return the type of the vertex buffer descriptor.
	 */
	public native @ByVal BufferTypes getBufferType();

	/**
	 * Return the base pointer in memory to the first vertex.
	 */
	public native FloatPointer getBasePointer();
}