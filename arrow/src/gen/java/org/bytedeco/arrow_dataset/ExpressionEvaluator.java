// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


/** Interface for evaluation of expressions against record batches. */
@Namespace("arrow::dataset") @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class ExpressionEvaluator extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ExpressionEvaluator(Pointer p) { super(p); }


  /** Evaluate expr against each row of a RecordBatch.
   *  Returned Datum will be of either SCALAR or ARRAY kind.
   *  A return value of ARRAY kind will have length == batch.num_rows()
   *  An return value of SCALAR kind is equivalent to an array of the same type whose
   *  slots contain a single repeated value.
   * 
   *  expr must be validated against the schema of batch before calling this method. */
  public native @ByVal DatumResult Evaluate(@Const @ByRef Expression expr,
                                            @Const @ByRef RecordBatch batch,
                                            MemoryPool pool);

  public native @ByVal DatumResult Evaluate(@Const @ByRef Expression expr,
                                    @Const @ByRef RecordBatch batch);

  public native @ByVal RecordBatchResult Filter(
        @Const @ByRef Datum selection, @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch batch,
        MemoryPool pool);

  
  ///
  public native @ByVal RecordBatchResult Filter(
        @Const @ByRef Datum selection, @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch batch);

  /** \brief Wrap an iterator of record batches with a filter expression. The resulting
   *  iterator will yield record batches filtered by the given expression.
   * 
   *  \note The ExpressionEvaluator must outlive the returned iterator. */
  public native @ByVal RecordBatchIterator FilterBatches(@ByVal RecordBatchIterator unfiltered,
                                      @SharedPtr @ByVal Expression filter,
                                      MemoryPool pool/*=arrow::default_memory_pool()*/);
  public native @ByVal RecordBatchIterator FilterBatches(@ByVal RecordBatchIterator unfiltered,
                                      @SharedPtr @ByVal Expression filter);

  /** construct an Evaluator which evaluates all expressions to null and does no
   *  filtering */
  public static native @SharedPtr ExpressionEvaluator Null();
}