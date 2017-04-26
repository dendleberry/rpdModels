package uk.gov.dvla.osg.rpd.common.processes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class Sorter {

	SessionParameterInterface params;
	
	public Sorter(SessionParameterInterface params){
		this.params = params;
	}
	
	public void sort(Comparator<DocumentProperty> comparator){
		Collections.sort( params.getDocumentProperties(), comparator);
	}
}
