package eu.plumbr.clean.$5_ReferenceQueue;

import eu.plumbr.clean.Movie;

public class SharedMoviePlayer {
  private static final EnqueuingCatalog catalog = new EnqueuingCatalog();

  private void play(String movieName, String screen) {
    Movie movie = catalog.find(movieName);
    movie.play(screen);
  }

  public static void main(String[] args) throws InterruptedException {
    new SharedMoviePlayer().play("The World Is Not Enough", "JPoint3");
    new SharedMoviePlayer().play("The World Is Not Enough", "JPoint3");
    new SharedMoviePlayer().play("The World Is Not Enough", "JPoint3");
    new SharedMoviePlayer().play("The World Is Not Enough", "JPoint3");
    new SharedMoviePlayer().play("The World Is Not Enough", "JPoint3");
  }
}
