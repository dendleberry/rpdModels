package uk.gov.dvla.osg.rpd.common.processes;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.AbstractGroup;
import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.BatchTypes;
import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.implementations.ClericalGroup;
import uk.gov.dvla.osg.rpd.implementations.MultiGroup;
import uk.gov.dvla.osg.rpd.implementations.SingleGroup;

public class CreateGroups {
	private static final Logger LOGGER = LogManager.getLogger();
	private SessionParameterInterface params;
	
	public CreateGroups(SessionParameterInterface params) {
		this.params=params;
	}
	
	public ArrayList<AbstractGroup> createGroupsFromDocs(ArrayList<Document> docs){
		ArrayList<AbstractGroup> result = new ArrayList<AbstractGroup>();
		for( Document doc : docs){
			AbstractGroup group = null;
			if( isMultiGroup(doc) ){
				if( isClericalGroup(doc) ){
					group = new ClericalGroup();
				}else{
					group = new MultiGroup();
				}
			}else{
				group = new SingleGroup();
			}
			result.add(group);
		}
		return result;
	}

	private boolean isClericalGroup(Document doc) {
		boolean result = false;
		if( BatchTypes.valueOf(doc.getDocProp().getDocDVLABatchType()).equals(BatchTypes.CLERICAL) ||
			BatchTypes.valueOf(doc.getDocProp().getDocDVLABatchType()).equals(BatchTypes.FLEET)){
			result = true;
		}
		return result;
	}

	private boolean isMultiGroup(Document doc) {
		if( doc.getDocProp().getDocDVLAGroupId().isEmpty() ){
			return false;
		}else{
			return true;
		}
	}
	
	
}
