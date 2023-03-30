package rebound.util.res;

public class AbstractResourceHandle
{
	protected final Class context;
	protected final String pathname;
	
	public AbstractResourceHandle(Class context, String pathname)
	{
		this.context = context;
		this.pathname = pathname;
	}
	
	public Class getContext()
	{
		return context;
	}
	
	public String getPathname()
	{
		return pathname;
	}
	
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((pathname == null) ? 0 : pathname.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractResourceHandle other = (AbstractResourceHandle) obj;
		if (context == null)
		{
			if (other.context != null)
				return false;
		}
		else if (!context.equals(other.context))
			return false;
		if (pathname == null)
		{
			if (other.pathname != null)
				return false;
		}
		else if (!pathname.equals(other.pathname))
			return false;
		return true;
	}
	
	
	@Override
	public String toString()
	{
		return pathname.startsWith("/") ? pathname : '/'+context.getPackage().getName().replace('.', '/')+'/'+pathname;
	}
}
