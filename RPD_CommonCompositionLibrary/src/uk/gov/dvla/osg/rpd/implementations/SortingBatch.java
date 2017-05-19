package uk.gov.dvla.osg.rpd.implementations;

import uk.gov.dvla.osg.rpd.abstractions.AbstractBatch;
import uk.gov.dvla.osg.rpd.common.models.BatchTypes;

public class SortingBatch extends AbstractBatch {

	public SortingBatch(BatchTypes bt, int batchCapacity) {
		super(bt, batchCapacity);
	}

	@Override
	public void batch() {
		//Code to batch this type of group
	}
	
}
