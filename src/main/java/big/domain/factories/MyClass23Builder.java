package big.domain.factories;

import big.domain.MyClass23;



public class MyClass23Builder
{

	
	
	private MyClass23 myclass23;
    

	
	public MyClass23Builder attribute (String attribute) 
	{
		myclass23.setAttribute (attribute);
		return this;	
	}

	
	public MyClass23Builder attribute2 (String attribute2) 
	{
		myclass23.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass23 build () 
	{
		return myclass23;	
	}

	
	public MyClass23Builder id (Long id) 
	{
		myclass23.setId (id);
		return this;	
	}

	
	public MyClass23Builder initMyClass23 () 
	{
		myclass23 = new MyClass23();
		return this;	
	}


}
