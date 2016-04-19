package eu.plumbr.clean.$6_Cleaner;

import eu.plumbr.clean.Movie;

public class MoviePlayer {
  private final static Catalog catalog = new Catalog();

  private void play(String movieName, String screen) {
    Movie movie = catalog.find(movieName);
    movie.fetch();
    movie.play(screen);
  }

  public static void main(String[] args) {
    new MoviePlayer().play("Tomorrow Never Dies", "JPoint3");
    new MoviePlayer().play("Tomorrow Never Dies", "JPoint3");
    new MoviePlayer().play("Tomorrow Never Dies", "JPoint3");
    new MoviePlayer().play("Tomorrow Never Dies", "JPoint3");
    new MoviePlayer().play("Tomorrow Never Dies", "JPoint3");
    new MoviePlayer().play("Tomorrow Never Dies", "JPoint3");
  }
}
