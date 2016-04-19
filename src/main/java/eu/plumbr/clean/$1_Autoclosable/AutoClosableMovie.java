package eu.plumbr.clean.$1_Autoclosable;

import eu.plumbr.clean.Movie;

class AutoClosableMovie extends Movie implements AutoCloseable {
  AutoClosableMovie(String name) {
    super(name);
  }

  @Override
  public void close() {
    release();
  }
}
