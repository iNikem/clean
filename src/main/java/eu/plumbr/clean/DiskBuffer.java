package eu.plumbr.clean;

import java.util.concurrent.ThreadLocalRandom;

public class DiskBuffer {
  static int fetchToLocalBuffer(String resourceName) {
    System.out.printf("Fetching %s to local buffer.%n", resourceName);
    return ThreadLocalRandom.current().nextInt(1_000);
  }

  public static void releaseBuffer(int bufferRef){
    System.out.printf("Removing local buffer for %d.%n", bufferRef);
  }
}
