package eu.plumbr.clean.$3_Finalizers;

class Catalog {

  FinalizableMovie find(String name) {
    return new FinalizableMovie(name);
  }
}
