package uk.gov.dvla.osg.rpd.main;

import java.util.ArrayList;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class Main {

	public static void main(String[] args) {
		String input = "C:/Users/dendlel/Desktop/RPD/TestData/LCR.dpf";
		ArrayList<DocumentProperty> docProps = DocumentProperty.getDocumentPropertiesFromTabDelimittedFile(input);
		
	}
}