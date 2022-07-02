package rebound.annotations.semantic.meta.dependencies;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Explicit class dependency!
 * Eg, for making sure classes that are dynamically accessed are included!
 * 
 * (Note that this will cause a reference to the depended-upon class to be present in the source/imports, and bytecode constant pool, so there you go!  Whatever mechanisms are used to find implicit class dependencies will probably pick this up as well without any changes!  \:DD/  )
 * (That is also why there is no "shallow" property here)
 */
//Undocumented, definitely!!
@Retention(RetentionPolicy.RUNTIME)  //DON'T FORGET THAT X'DD
@Target(ElementType.TYPE)
@Repeatable(DependencyClassRepetitionContainer.class)
public @interface DependencyClass
{
	Class value();
}
