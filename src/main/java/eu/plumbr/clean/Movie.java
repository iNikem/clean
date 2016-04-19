package eu.plumbr.clean;

public class Movie {
  public final String name;
  private int bufferRef = -1;

  public Movie(String name) {
    this.name = name;
  }

  public int fetch() {
    if (bufferRef >= 0) {
      System.out.printf("Reusing local buffer %d.%n", bufferRef);
    } else {
      bufferRef = DiskBuffer.fetchToLocalBuffer(name);
    }
    return bufferRef;
  }

  public void play(String screen) {
    System.out.printf("Playing %s from buffer %d.%n", name, bufferRef);
  }

  public void release() {
    DiskBuffer.releaseBuffer(bufferRef);
  }
}
