package eu.plumbr.clean.$6_Cleaner;

import eu.plumbr.clean.Movie;
import java.lang.ref.Cleaner;

class Catalog {

  private static final Cleaner cleaner = Cleaner.create();

  Movie find(String name) {
    Movie result = new Movie(name);
    cleaner.register(result, new MovieCleaningAction(name));
    return result;
  }

  private static class MovieCleaningAction implements Runnable {

    private String cacheReference;

    MovieCleaningAction(String cacheReference) {
      this.cacheReference = cacheReference;
    }

    @Override
    public void run() {
      System.out.printf("Deleting cache for %s via Cleaner.%n", cacheReference);
    }
  }
}
