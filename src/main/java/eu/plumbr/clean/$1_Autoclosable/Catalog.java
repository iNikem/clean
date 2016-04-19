package eu.plumbr.clean.$1_Autoclosable;

class Catalog {

  AutoClosableMovie find(String name) {
    return new AutoClosableMovie(name);
  }
}
