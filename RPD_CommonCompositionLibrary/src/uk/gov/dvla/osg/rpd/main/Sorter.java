package uk.gov.dvla.osg.rpd.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;

public class Sorter {

	SessionParameterInterface params;
	
	public Sorter(SessionParameterInterface params){
		this.params = params;
	}
	
	public void sort(Comparator comparator){
		Collections.sort( params.getDocumentProperties(), comparator);
	}
}
