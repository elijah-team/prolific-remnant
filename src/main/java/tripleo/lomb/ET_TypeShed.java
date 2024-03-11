package tripleo.lomb;

import tripleo.elijah_prolific_durable.lang.OS_Type;
import tripleo.elijah_prolific_durable.stages.gen_fn.GenType;

/**
 * Everything the system knows about types 
 */
public interface ET_TypeShed {
	OS_Type getOsType(); // what does OS mean?
	
	GenType getGenType();
	
	//DT_
	
	// dont remove getters
	// do add has*
	// do add on*(EventualSuccess) and on*Fail(EventualFailure)
	// do add resolve*
	// maybe add denyResolveAll,*
}
