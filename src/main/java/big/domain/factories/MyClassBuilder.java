package big.domain.factories;

import big.domain.MyClass;



public class MyClassBuilder
{

	
	
	private MyClass myclass;
    

	
	public MyClassBuilder attribute (String attribute) 
	{
		myclass.setAttribute (attribute);
		return this;	
	}

	
	public MyClassBuilder attribute2 (String attribute2) 
	{
		myclass.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass build () 
	{
		return myclass;	
	}

	
	public MyClassBuilder id (Long id) 
	{
		myclass.setId (id);
		return this;	
	}

	
	public MyClassBuilder initMyClass () 
	{
		myclass = new MyClass();
		return this;	
	}


}
