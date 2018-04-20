package com.training.boxomatic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

final class Boxomatic
{
  private final Collection<BoxomaticRange> ranges;
  
  Boxomatic(final Integer... sizes)
  {
    ranges = Stream.of(sizes)
      .<List<BoxomaticRange>>collect(
          ArrayList::new,
          (boxes, size) ->
          {
            if (boxes.isEmpty())
            {
              boxes.add(BoxomaticRange.firstBoxomaticRange(size));
            }
            else
            {
              boxes.add(boxes.get(boxes.size() - 1).nextBoxomaticRange(size));
            }
          },
          Collection::addAll);
  }
  
  String printLabelForIndex(final int index)
  {
    return ranges.stream()
      .filter(range -> range.containsIndex(index))
      .findFirst()
      .map(range -> range.printLabelForIndex(index))
      .orElse("");
  }
}
