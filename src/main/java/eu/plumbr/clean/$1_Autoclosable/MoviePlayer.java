package eu.plumbr.clean.$1_Autoclosable;

public class MoviePlayer {
  private final Catalog catalog = new Catalog();

  private void play(String movieName, String screen) {
    try (AutoClosableMovie movie = catalog.find(movieName)) {
      movie.fetch();
      movie.play(screen);
    }
  }

  public static void main(String[] args) {
    new MoviePlayer().play("Skyfall", "JPoint3");
  }

}
