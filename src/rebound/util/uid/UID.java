package rebound.util.uid;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


//Not documented :p

//Full retention to runtime! :D   (Important!!! XD )
@Retention(RetentionPolicy.RUNTIME)

//All. targets.!  :>

public @interface UID
{
	/**
	 * This is to be a hexadecimal string in either upper or lower case, and with no delimiters!
	 * The only rule about the contents is that it can't be the same as any other UID! Otherwise it's not a *unique* ID!! XD
	 * 
	 * (the UUID standard is the usual way to come up with then, but that's only one way :3 )
	 */
	public String value();
}
