package eu.plumbr.clean.$3_Finalizers;

public class MoviePlayer {
  private final Catalog catalog = new Catalog();

  private void play(String movieName, String screen) {
    FinalizableMovie movie = catalog.find(movieName);
    movie.fetch();
    movie.play(screen);
  }

  public static void main(String[] args) throws InterruptedException {
    new MoviePlayer().play("Casino Royale", "JPoint3");
  }
}
