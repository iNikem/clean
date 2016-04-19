package eu.plumbr.clean.$5_ReferenceQueue;

import eu.plumbr.clean.DiskBuffer;
import eu.plumbr.clean.Movie;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class EnqueuingCatalog {

  private static final List<MovieReference> refs = new ArrayList<>();
  private static ReferenceQueue<Movie> queue = new ReferenceQueue<>();
  private HashMap<String, WeakReference<Movie>> movies = new HashMap<>();

  EnqueuingCatalog() {
    Thread t = new Thread(() -> {
      while (true) {
        MovieReference reference = (MovieReference) queue.poll();
        if (reference != null) {
          DiskBuffer.releaseBuffer(reference.bufferRef);
          remove(reference.name);
          reference.clear();

          synchronized (refs) {
            refs.remove(reference);
          }
        }
      }
    });
    t.setDaemon(true);
    t.start();
  }

  synchronized Movie find(String name) {
    WeakReference<Movie> movieRef = movies.get(name);
    if (movieRef == null || movieRef.get() == null) {
      Movie movie = new Movie(name);
      movies.put(name, new WeakReference<>(movie));

      int bufferRef = movie.fetch();
      synchronized (refs) {
        refs.add(new MovieReference(movie, bufferRef, queue));
      }

      return movie;
    } else {
      return movieRef.get();
    }
  }

  synchronized void remove(String name) {
    movies.remove(name);
  }
}
