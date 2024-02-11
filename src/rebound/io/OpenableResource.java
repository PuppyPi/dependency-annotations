package rebound.io;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Nullable;

import rebound.annotations.semantic.meta.dependencies.DependencyFile;
import rebound.util.res.SimpleOpenableResource;

/**
 * This is useful in many cases for rewriting code to encapsulate resource pathnames into something much more useful and portable :)
 * 
 * You declare public static final {@link OpenableResource}'s instead of {@link String}'s, then use {@link OpenableResource#open()} instead of {@link Class#getResourceAsStream(String)} or {@link ClassLoader#getResourceAsStream(String)} in everything that accepts those constants :)
 * And in the classes that declare the constants, you simply attach a {@link DependencyFile} as appropriate!  And packagers/analyzers/etc. tools can recognize its resource-dependencies just like they recognize its class dependencies!  ^_^
 * 
 * If a resource name is really needed (say for error documentation or autodetermining the file type from the extension!), let the {@link #toString()} of this be called/implemented as in {@link #from(Class, String)}  :)
 */
@FunctionalInterface
public interface OpenableResource
{
	/**
	 * @return null on failure not an {@link IOException}, just like {@link Class#getResourceAsStream(String)}
	 */
	public @Nullable InputStream open();
	
	
	
	
	/**
	 * Anything using someclass.getClassLoader().getResourceAsStream(...) can just use this with <code>someclass</code> and a forward-slash in front of the resource path  :3
	 * @param context Class for context (since Java can support multiple instances of the same class in different sibling ClassLoaders and different resource-lookup paths for different classes among other complexities)
	 * @param pathname The resource path, relative to the class of absolute if it begins with a /
	 */
	public static OpenableResource from(Class context, String pathname)
	{
		return new SimpleOpenableResource(context, pathname);
	}
}
