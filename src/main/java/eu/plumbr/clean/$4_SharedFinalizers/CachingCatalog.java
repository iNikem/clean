package eu.plumbr.clean.$4_SharedFinalizers;

import eu.plumbr.clean.$3_Finalizers.FinalizableMovie;
import java.util.HashMap;

class CachingCatalog {

  private HashMap<String, FinalizableMovie> movies = new HashMap<>();

  synchronized FinalizableMovie find(String name) {
    FinalizableMovie movie = movies.get(name);
    if (movie == null) {
      movie = new FinalizableMovie(name);
      movies.put(name, movie);
    }
    return movie;
  }
}
