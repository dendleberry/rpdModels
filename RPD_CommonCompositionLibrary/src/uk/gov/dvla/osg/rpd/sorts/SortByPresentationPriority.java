package uk.gov.dvla.osg.rpd.sorts;

import java.util.Comparator;

import uk.gov.dvla.osg.rpd.common.models.Document;

public class SortByPresentationPriority implements Comparator<Document>{

	@Override
	public int compare(Document o1, Document o2) {
		/* SORT ORDER IS:
		 * PRESENTATION_ORDER
		 * LANGUAGE
		 */
		
		// Next by PRESENTATION_ORDER - stop if this gives a result.
        int presResult = o1.getPresentationOrder().compareTo(o2.getPresentationOrder());
        if (presResult != 0){
            return presResult;
        }
        return o1.getDocProp().getDocDVLALanguage().compareTo(o2.getDocProp().getDocDVLALanguage());

	}

}
