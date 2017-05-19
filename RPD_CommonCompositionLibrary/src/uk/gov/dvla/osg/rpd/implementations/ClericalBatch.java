package uk.gov.dvla.osg.rpd.implementations;

import uk.gov.dvla.osg.rpd.abstractions.AbstractBatch;
import uk.gov.dvla.osg.rpd.common.models.BatchTypes;

public class ClericalBatch extends AbstractBatch {

	public ClericalBatch(BatchTypes bt, int batchCapacity) {
		super(bt, batchCapacity);
	}

	@Override
	public void batch() {
		//Code to batch this type of group
	}
	
}
