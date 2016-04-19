package eu.plumbr.clean.$4_SharedFinalizers;

import eu.plumbr.clean.$3_Finalizers.FinalizableMovie;

public class SharedMoviePlayer {
  private static final CachingCatalog catalog = new CachingCatalog();
//  private static final WeaklyCachingCatalog weakCatalog = new WeaklyCachingCatalog();

  private void play(String movieName, String screen) {
    FinalizableMovie movie = catalog.find(movieName);
    movie.fetch();
    movie.play(screen);
  }

  public static void main(String[] args) throws InterruptedException {
    new SharedMoviePlayer().play("Die Another Day", "JPoint3");
    new SharedMoviePlayer().play("Die Another Day", "JPoint3");
    new SharedMoviePlayer().play("Die Another Day", "JPoint3");
    new SharedMoviePlayer().play("Die Another Day", "JPoint3");
    new SharedMoviePlayer().play("Die Another Day", "JPoint3");
  }
}
