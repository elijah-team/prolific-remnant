package tripleo.elijah.nextgen.output

import tripleo.elijah.lang.i.OS_Module
import tripleo.elijah.nextgen.comp_model.CM_Module

data class NG_OutDep(
		/*@get:@JvmName("getModule")*/
		val module_: OS_Module
) : CM_Module {

	val filename_: String by lazy { module_.fileName.string }

	override fun getFilename(): String = filename_
	override fun getModule(): OS_Module = module_
}
