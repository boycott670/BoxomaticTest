package com.training.boxomatic;

final class BoxomaticRange
{
  static BoxomaticRange firstBoxomaticRange(final int size)
  {
    return new BoxomaticRange(0, size, 'A');
  }

  private final int minIndex;
  private final int size;
  private final char label;

  private BoxomaticRange(final int minIndex, final int size, final char label)
  {
    this.minIndex = minIndex;
    this.size = size;
    this.label = label;
  }

  private int maxIndex()
  {
    return minIndex + size - 1;
  }

  BoxomaticRange nextBoxomaticRange(final int size)
  {
    return new BoxomaticRange(maxIndex() + 1, size, (char) (label + 1));
  }

  boolean containsIndex(final int index)
  {
    return index >= minIndex && index <= maxIndex();
  }

  String printLabelForIndex(final int index)
  {
    if (!containsIndex(index))
    {
      throw new IllegalArgumentException();
    }

    return String.format("%c%d", label, index - minIndex + 1);
  }
}
