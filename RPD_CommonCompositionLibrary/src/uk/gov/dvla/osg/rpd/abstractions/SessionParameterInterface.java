package uk.gov.dvla.osg.rpd.abstractions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public interface SessionParameterInterface {
	
	public void setDocumentProperties(List<DocumentProperty> docProps);
	public void setPostageConfiguration(Properties postageProps);
	public void setProductionConfiguration(Properties productionProps);
	public void setApplicationConfiguration(Properties applicationProps);
	public void setPresentationPriority(Map<String,Integer> presentationPriority);
	public void setRunNo(String runNo);
	public void setOutputFilePath(String filePath);
	public void setJobId(String jobId);
	public void setPostageConfigurationPath(String path);
	public void setProductionConfigurationPath(String path);
	public void setApplicationConfigurationPath(String path);
	public void setPresentationPriorityPath(String path);
	
	
	public List<DocumentProperty> getDocumentProperties();
	public Properties getPostageConfiguration();
	public Properties getProductionConfiguration();
	public Properties getApplicationConfiguration();
	public Map<String,Integer> getPresentationPriority();
	public String getRunNo();
	public String getOutputFilePath();
	public String getJobId();
	public String getPostageConfigurationPath();
	public String getProductionConfigurationPath();
	public String getApplicationConfigurationPath();
	public String getPresentationPriorityPath();
	
}
