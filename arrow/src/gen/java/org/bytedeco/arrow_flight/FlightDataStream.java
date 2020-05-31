// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief Interface that produces a sequence of IPC payloads to be sent in
 *  FlightData protobuf messages */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class FlightDataStream extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FlightDataStream(Pointer p) { super(p); }


  public native @SharedPtr @ByVal Schema schema();

  /** \brief Compute FlightPayload containing serialized RecordBatch schema */
  public native @ByVal Status GetSchemaPayload(FlightPayload payload);

  // When the stream is completed, the last payload written will have null
  // metadata
  public native @ByVal Status Next(FlightPayload payload);
}