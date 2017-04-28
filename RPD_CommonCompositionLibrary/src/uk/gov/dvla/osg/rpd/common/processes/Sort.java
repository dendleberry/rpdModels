package uk.gov.dvla.osg.rpd.common.processes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;
import uk.gov.dvla.osg.rpd.sorts.SortByPresentationPriority;

public class Sort {
	private static final Logger LOGGER = LogManager.getLogger();
	SessionParameterInterface params;
	
	public Sort(SessionParameterInterface params){
		this.params = params;
	}
	
	public void sort(ArrayList<Document> docs, Comparator<Document> comparator){
		LOGGER.debug("sort running");
		Collections.sort( docs, comparator);
	}


}
