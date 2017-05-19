package uk.gov.dvla.osg.rpd.common.processes;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.AbstractBatch;
import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.BatchTypes;
import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.common.models.Languages;
import uk.gov.dvla.osg.rpd.implementations.ClericalBatch;
import uk.gov.dvla.osg.rpd.implementations.FleetBatch;
import uk.gov.dvla.osg.rpd.implementations.MultiBatch;
import uk.gov.dvla.osg.rpd.implementations.RejectBatch;
import uk.gov.dvla.osg.rpd.implementations.ReprintBatch;
import uk.gov.dvla.osg.rpd.implementations.SortedBatch;
import uk.gov.dvla.osg.rpd.implementations.SortingBatch;
import uk.gov.dvla.osg.rpd.implementations.UnsortedBatch;

public class BatchEngine {
	private static final Logger LOGGER = LogManager.getLogger();
	private SessionParameterInterface params;
	private ArrayList<AbstractBatch> batches;
	private HashMap<String,Integer> batchTracker;
	
	public BatchEngine(SessionParameterInterface params) {
		this.params=params;
		batches = new ArrayList<AbstractBatch>();
	}
	
	public void run(ArrayList<Document> docs){
		AbstractBatch prevBatch = null;
		for( Document doc : docs ){
			AbstractBatch batch = getBatch(prevBatch, doc);
			batch.addDocument(doc);
			updateCounter(batch);
		}
	}
	

	private void updateCounter(AbstractBatch batch) {
		if( batchTracker.get(batch.getBatchKey()) == null ){
			batchTracker.put(batch.getBatchKey(), 1);
		}else{
			batchTracker.put(batch.getBatchKey(), batchTracker.get(batch.getBatchKey()) + 1);
		}
	}

	private AbstractBatch getBatch(AbstractBatch prevBatch, Document doc) {
		AbstractBatch result = null;
		
		if( isNewBatchRequired(prevBatch, doc) ){
			result = getNewBatch(doc);
		} else {
			result = prevBatch;
		}
		LOGGER.trace("getBatch(Document {}) returned '{}'", doc, result);
		return result;
	}

	
	
	
	private AbstractBatch getNewBatch(Document doc) {
		AbstractBatch result = null;
		String prop = "batchMax." + doc.getLanguage().toString().toLowerCase() + "." + doc.getBatchType().toString().toLowerCase();
		int capacity = Integer.parseInt(params.getProperties().getProperty(prop));
		switch (doc.getBatchType()) {
			case SORTED: result = new SortedBatch(doc.getBatchType(), capacity);
			break;
			case UNSORTED: result = new UnsortedBatch(doc.getBatchType(), capacity);
			break;
			case MULTI: result = new MultiBatch(doc.getBatchType(), capacity);
			break;
			case FLEET: result = new FleetBatch(doc.getBatchType(), capacity);
			break;
			case CLERICAL: result = new ClericalBatch(doc.getBatchType(), capacity);
			break;
			case SORTING: result = new SortingBatch(doc.getBatchType(), capacity);
			break;
			case REJECT: result = new RejectBatch(doc.getBatchType(), capacity);
			break;
			case REPRINT: result = new ReprintBatch(doc.getBatchType(), capacity);
			break;
			default: LOGGER.fatal("getNewBatch({}) unable to get batch.");
			System.exit(1);
		}
		LOGGER.trace("getNewBatch({}) returned '{}' with capacity '{}'", doc, result, capacity);
		return result;
	}

	
	private boolean isNewBatchRequired(AbstractBatch prevBatch, Document doc){
		boolean result = false;
		if( prevBatch == null ){
			result = true;
		}else if( !(prevBatch.isDocSuitableForBatch(doc)) ){
			result = true;
		}
		LOGGER.trace("isNewBatchRequired(AbstractBatch {}, Document {}) returned '{}'",prevBatch, doc, result);
		return result;
	}
}
