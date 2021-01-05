package org.csu.javaweb.persistence;

import org.csu.javaweb.domain.Sequence;

public interface SequenceDao {

  Sequence getSequence(Sequence sequence);
  void updateSequence(Sequence sequence);
}
