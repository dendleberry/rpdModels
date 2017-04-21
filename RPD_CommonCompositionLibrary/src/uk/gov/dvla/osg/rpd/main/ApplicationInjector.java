package uk.gov.dvla.osg.rpd.main;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.implementations.SessionParameterImpl;

import com.google.inject.AbstractModule;

public class ApplicationInjector extends AbstractModule{

	@Override
	protected void configure() {
		bind(SessionParameterInterface.class).to(SessionParameterImpl.class);
	}

}
