package eu.plumbr.clean.$5_ReferenceQueue;

import eu.plumbr.clean.DiskBuffer;
import eu.plumbr.clean.Movie;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class EnqueuingCatalog {

  private static Set<MovieReference> refs = new HashSet<>();
  private static ReferenceQueue<Movie> queue = new ReferenceQueue<>();
  private HashMap<String, WeakReference<Movie>> movies = new HashMap<>();

  EnqueuingCatalog() {
    Thread thread = new Thread(() -> {
      while (true) {
        try {
          MovieReference reference = (MovieReference) queue.remove();
          DiskBuffer.releaseBuffer(reference.bufferRef);
          refs.remove(reference);
          remove(reference.name);
          reference.clear();
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    });
    thread.setDaemon(true);
    thread.start();
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
