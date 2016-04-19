package eu.plumbr.clean.$2_Command;

import eu.plumbr.clean.Movie;

public class MoviePlayer {
  private final Catalog catalog = new Catalog();

  private void play(String movieName, String screen) {
    catalog.withMovie(movieName, new MovieCommand() {
      @Override
      public void execute(Movie movie) {
        movie.play(screen);
      }
    });
  }

  public static void main(String[] args) {
    new MoviePlayer().play("Quantum of Solace", "JPoint3");
  }
}
