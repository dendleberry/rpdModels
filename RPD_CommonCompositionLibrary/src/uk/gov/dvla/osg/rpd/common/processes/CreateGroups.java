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
import uk.gov.dvla.osg.rpd.sorts.SortByPresentationPriority;

public class CreateGroups {
	private static final Logger LOGGER = LogManager.getLogger();
	private SessionParameterInterface params;
	
	public CreateGroups(SessionParameterInterface params) {
		this.params=params;
	}
	
	public ArrayList<AbstractGroup> createGroupsFromDocs(ArrayList<Document> docs){
		ArrayList<AbstractGroup> result = new ArrayList<AbstractGroup>();
		Sort.sort(docs, new SortByPresentationPriority());
		AbstractGroup group = null;
		for( Document doc : docs ){
			if( isNewGroup(group, doc) ){
				setEndOfGroup(group);
				addGroupToResults(group, result);
				group = getNewGroup(doc);
			}
			group.addDocument(doc);
		}
		result.add(group);
		LOGGER.info("createGroupsFromDocs({} docs) created {} groups", docs.size(), result.size());
		return result;
	}
	
	private void setEndOfGroup(AbstractGroup group){
		if( group != null  ){
			group.getDocuments().get(group.getDocuments().size() - 1 ).setEndOfGroup(true);
		}
	}
	
	private void addGroupToResults(AbstractGroup group, ArrayList<AbstractGroup> result){
		if( group != null  ){
			result.add(group);
		}
	}
	
	private boolean isNewGroup(AbstractGroup group, Document doc){
		boolean result = false;
		if( group== null ){
			result = true;
		}else if( isSameGroupId(group, doc) ){
			result = false;
		}else if( isGroupMaxReached(group, doc) ){
			result = true;
		}
		return result;
	}
	
	private boolean isGroupMaxReached(AbstractGroup group, Document doc) {
		boolean result = false;
		//TODO
		return result;
	}

	private boolean isSameGroupId(AbstractGroup group, Document doc){
		boolean result = false;
		if( group.getGroupId().equalsIgnoreCase(doc.getGroupId()) ){
			result = true;
		}
		LOGGER.trace("isSameGroupId({}, {}) returned '{}", group.getClass(), doc, result);
		return result;
	}
	
	private AbstractGroup getNewGroup(Document doc){
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
		group.setGroupId(doc.getGroupId());
		return group;
	}

	private boolean isClericalGroup(Document doc) {
		boolean result = false;
		if( BatchTypes.valueOf(doc.getBatchType()).equals(BatchTypes.CLERICAL) ||
			BatchTypes.valueOf(doc.getBatchType()).equals(BatchTypes.FLEET)){
			result = true;
		}
		return result;
	}

	private boolean isMultiGroup(Document doc) {
		if( doc.getGroupId().isEmpty() ){
			return false;
		}else{
			return true;
		}
	}
}
