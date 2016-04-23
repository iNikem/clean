package eu.plumbr.clean.$3_Finalizers;

import eu.plumbr.clean.Movie;

public class FinalizableMovie extends Movie {

  public FinalizableMovie(String name) {
    super(name);
  }

  public void finalize() throws Throwable {
    try {
      release();
    } finally {
      super.finalize();
    }
  }
}
