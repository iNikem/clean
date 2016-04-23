package eu.plumbr.clean;

import eu.plumbr.clean.$3_Finalizers.FinalizableMovie;
import java.lang.ref.WeakReference;
import org.openjdk.jmh.annotations.Benchmark;

public class FinalizerBenchmark {

  @Benchmark
  public Movie plainMovie() {
    return new Movie("Dr. No");
  }

  @Benchmark
  public FinalizableMovie finalizableMovie() {
    return new FinalizableMovie("From Russia with Love");
  }

  @Benchmark
  public WeakReference<Movie> referenceMovie() {
    return new WeakReference<>(new Movie("Goldfinger"));
  }
}
