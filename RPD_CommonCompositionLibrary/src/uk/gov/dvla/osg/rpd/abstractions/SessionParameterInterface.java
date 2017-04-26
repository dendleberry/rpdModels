package uk.gov.dvla.osg.rpd.abstractions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public interface SessionParameterInterface {
	
	public void setDocumentProperties(List<DocumentProperty> docProps);
	public void addProperties(Properties prop);
	public void setPresentationPriority(Map<String,Integer> presentationPriority);
	public void setRunNo(String runNo);
	public void setOutputFilePath(String filePath);
	public void setJobId(String jobId);

	
	
	public List<DocumentProperty> getDocumentProperties();
	public Properties getProperties();
	public Map<String,Integer> getPresentationPriority();
	public String getRunNo();
	public String getOutputFilePath();
	public String getJobId();

	
}
