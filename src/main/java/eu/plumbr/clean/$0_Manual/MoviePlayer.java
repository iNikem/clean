package eu.plumbr.clean.$0_Manual;

import eu.plumbr.clean.Movie;

public class MoviePlayer {
  private final Catalog catalog = new Catalog();

  private void play(String movieName, String screen) {
    Movie movie = catalog.find(movieName);
    try {
      movie.fetch();
      movie.play(screen);
    } finally {
      movie.release();
    }
  }

  public static void main(String[] args) {
    new MoviePlayer().play("Specter", "JPoint3");
  }
}
