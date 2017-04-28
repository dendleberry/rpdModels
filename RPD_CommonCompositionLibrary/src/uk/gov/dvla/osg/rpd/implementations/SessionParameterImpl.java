package uk.gov.dvla.osg.rpd.implementations;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class SessionParameterImpl implements SessionParameterInterface {
	private List<DocumentProperty> docProps;
	private Map<String, Integer> presentationPriority;
	Properties props;
	private String runNo, jobId, outputFilePath, presPath;
	
	@Override
	public void addProperties(Properties prop) {
		if( props == null){
			props = new Properties();
			props.putAll(prop);
		}else{
			props.putAll(prop);
		}
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
	@Override
	public Properties getProperties() {
		return props;
	}
	@Override
	public String toString(){
		return "number of docProps:" + docProps.size() +
				" properties:" + props.size() + 
				" presentation config:" + presPath +
				" output path:" + outputFilePath +
				" runNo:" + runNo +
				" jobId:" + jobId;
	}

}
