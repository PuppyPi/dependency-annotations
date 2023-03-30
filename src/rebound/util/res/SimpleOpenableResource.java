package rebound.util.res;

import java.io.InputStream;
import rebound.io.OpenableResource;

public class SimpleOpenableResource
extends AbstractResourceHandle
implements OpenableResource
{
	public SimpleOpenableResource(Class context, String pathname)
	{
		super(context, pathname);
	}
	
	@Override
	public InputStream open()
	{
		return getContext().getResourceAsStream(getPathname());
	}
}
