package rebound.util.uid;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;


//Not documented :p

//Full retention to runtime! :D   (Important!!! XD )
@Retention(RetentionPolicy.RUNTIME)

//All. targets.!  :>

public @interface UID
{
	/**
	 * If you only want to use UUIDs, just parse this value with {@link UUID#fromString(String)} XD
	 * But if you want to support code using other syntaxes, read below.
	 * 
	 * Generally speaking, this is to be a hexadecimal string in either upper or lower case, and with optional hyphens, spaces and/or colons as delimiters.
	 * The only rule about the contents is that it can't be the same as any other UID!  XD
	 * (the UUID standard is the usual way to come up with them, but that's only one way :3 )
	 * (and thus if they're UUIDs, they'll be interpreted as bytes (pairs of hex chars) as if the colons weren't there)
	 */
	public String value();
}
