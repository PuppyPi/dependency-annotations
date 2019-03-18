package rebound.annotations.semantic.meta.dependencies;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Note that this is exactly equivalent to specifying {@link DependencyFile} on the same class for all the files that happen to be in the folder at packaging-time, all with the same value of {@link DependencyFile#shallow()} as given here!
 */
//Undocumented, definitely!!
@Retention(RetentionPolicy.RUNTIME)  //DON'T FORGET THAT X'DD
@Target(ElementType.TYPE)
@Repeatable(DependencyDirectoryRepetitionContainer.class)
public @interface DependencyDirectory
{
	/**
	 * This is the relative pathname in the source/build virtual filesystem!
	 * 
	 * Eg, "com/example/app/res/"
	 * Or, "com/example/app/res"
	 * 
	 * With or without the trailing slash, it doesn't matter :3
	 * 
	 * Tricks:
	 * 		+ Using the prefix "./" will replace the "./" with the package name path of the java class that is defining the annotation! :D
	 */
	String value();
	
	
	/**
	 * If this is true, these dependencies are treated just like if there were a direct reference in the Java Bytecode! ^w~
	 * If this is false, then if only shallow connections to each target are present in the code to be packaged, that target *itself* will NOT be scanned for dependencies!!
	 */
	boolean deep() default true;
}
