package rebound.annotations.semantic.meta.dependencies;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Undocumented, definitely!!
@Retention(RetentionPolicy.RUNTIME)  //DON'T FORGET THAT X'DD
@Target(ElementType.TYPE)
@Repeatable(DependencyFileRepetitionContainer.class)
public @interface DependencyFile
{
	/**
	 * This is the relative pathname in the source/build virtual filesystem!
	 * 
	 * Eg, "com/example/app/res/ErrorIcon.png"
	 * Or, "com/example/app/dyn/DynamicallyAccessed$1.class"
	 * 
	 * Tricks:
	 * 		+ Using the prefix "./" will replace the "./" with the package name path of the java class that is defining the annotation! :D
	 */
	String value();
	
	
	/**
	 * If this is true, this dependency is treated just like if there were a direct reference in the Java Bytecode! ^w~
	 * If this is false, then if only shallow connections to this target are present in the code to be packaged, the target *itself* will NOT be scanned for dependencies!!
	 */
	boolean shallow() default false;
}
