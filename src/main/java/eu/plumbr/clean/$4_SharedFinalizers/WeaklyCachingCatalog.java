package eu.plumbr.clean.$4_SharedFinalizers;

import eu.plumbr.clean.$3_Finalizers.FinalizableMovie;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class WeaklyCachingCatalog {

  private HashMap<String, WeakReference<FinalizableMovie>> movies = new HashMap<>();

  synchronized FinalizableMovie find(String name) {
    WeakReference<FinalizableMovie> movieRef = movies.get(name);
    if (movieRef == null || movieRef.get() == null) {
      movieRef = new WeakReference<>(new FinalizableMovie(name));
      movies.put(name, movieRef);
    }
    return movieRef.get();
  }

  synchronized void remove(String name) {
    movies.remove(name);
  }
}
