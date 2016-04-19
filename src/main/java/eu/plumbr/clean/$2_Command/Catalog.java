package eu.plumbr.clean.$2_Command;

import eu.plumbr.clean.Movie;

class Catalog {

  private Movie find(String name) {
    return new Movie(name);
  }

  void withMovie(String movieName, MovieCommand action) {
    Movie movie = find(movieName);
    try {
      movie.fetch();
      action.execute(movie);
    } finally {
      movie.release();
    }
  }
}
