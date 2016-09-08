package eu.plumbr.clean.$6_Cleaner;

import eu.plumbr.clean.DiskBuffer;
import eu.plumbr.clean.Movie;
import java.lang.ref.Cleaner;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Catalog {

  private Map<String, WeakReference<Movie>> movies = new ConcurrentHashMap<>();

  private static final Cleaner cleaner = Cleaner.create();

  Movie find(String name) {
    WeakReference<Movie> movieRef = movies.get(name);
    if (movieRef == null || movieRef.get() == null) {
      Movie movie = new Movie(name);
      movies.put(name, new WeakReference<>(movie));

      int bufferRef = movie.fetch();

      cleaner.register(movie, new MovieCleaningAction(bufferRef, name));

      return movie;
    } else {
      return movieRef.get();
    }
  }

  private class MovieCleaningAction implements Runnable {

    private final int bufferRef;
    private final String movieName;

    MovieCleaningAction(int bufferRef, String movieName) {
      this.bufferRef = bufferRef;
      this.movieName = movieName;
    }

    @Override
    public void run() {
      DiskBuffer.releaseBuffer(bufferRef);
      movies.remove(movieName);
    }
  }
}
