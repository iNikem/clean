package eu.plumbr.clean.$2_Command;

public class LambdaMoviePlayer {
  private final Catalog catalog = new Catalog();

  private void play(String movieName, String screen) {
    catalog.withMovie(movieName, movie -> movie.play(screen));
  }

  public static void main(String[] args) {
    new LambdaMoviePlayer().play("Quantum of Solace", "JPoint3");
  }
}
