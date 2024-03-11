package tripleo.lomb;

import tripleo.elijah_prolific_durable.lang.ElObjectType;
import tripleo.elijah_prolific_durable.lang.OS_Element;

public interface ILToken {
	ElObjectType getObjectType();
	
	ILElement getContainer();
	OS_Element getSource();
	
	EN_Name getEnName();
	
	ET_TypeShed getTypeShed();
}
