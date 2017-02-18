package domain;

/**
 * @author Alexei Vinogradov.
 */
public class Film {
  public String title,
          year,
          type;

  @Override
  public String toString() {
    return "title=" + title + ",year=" + year + ",type=" + type;
  }
}
