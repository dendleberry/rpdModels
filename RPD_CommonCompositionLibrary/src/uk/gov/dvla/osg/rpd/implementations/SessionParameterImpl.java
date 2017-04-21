package uk.gov.dvla.osg.rpd.implementations;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class SessionParameterImpl implements SessionParameterInterface {
	private List<DocumentProperty> docProps;
	private Map<String, Integer> presentationPriority;
	Properties postageProps, productionProps;
	private String runNo, jobId, outputFilePath;
	
	@Override
	public void setDocumentProperties(List<DocumentProperty> docProps) {
		this.docProps=docProps;
	}
	@Override
	public void setPostageConfiguration(Properties postageProps) {
		this.postageProps=postageProps;
	}
	@Override
	public void setProductionConfiguration(Properties productionProps) {
		this.productionProps=productionProps;
	}
	@Override
	public void setPresentationPriority(Map<String, Integer> presentationPriority) {
		this.presentationPriority=presentationPriority;
	}
	@Override
	public void setRunNo(String runNo) {
		this.runNo=runNo;
	}
	@Override
	public void setOutputFilePath(String filePath) {
		this.outputFilePath=filePath;
	}
	@Override
	public void setJobId(String jobId) {
		this.jobId=jobId;
	}
	
	
	
	
	
	
	
	@Override
	public List<DocumentProperty> getDocumentProperties() {
		return docProps;
	}
	@Override
	public Properties getPostageConfiguration() {
		return postageProps;
	}
	@Override
	public Properties getProductionConfiguration() {
		return productionProps;
	}
	@Override
	public Map<String, Integer> getPresentationPriority() {
		return presentationPriority;
	}
	@Override
	public String getRunNo() {
		return runNo;
	}
	@Override
	public String getOutputFilePath() {
		return outputFilePath;
	}
	@Override
	public String getJobId() {
		return jobId;
	}
}
