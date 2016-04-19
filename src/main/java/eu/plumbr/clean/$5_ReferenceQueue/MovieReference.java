package eu.plumbr.clean.$5_ReferenceQueue;

import eu.plumbr.clean.Movie;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class MovieReference extends PhantomReference<Movie> {

  final int bufferRef;
  final String name;

  MovieReference(Movie referent, int bufferRef, ReferenceQueue<Movie> queue) {
    super(referent, queue);
    this.bufferRef = bufferRef;
    this.name = referent.name;
  }

}
