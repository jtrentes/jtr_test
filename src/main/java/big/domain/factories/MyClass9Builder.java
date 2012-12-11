package big.domain.factories;

import big.domain.MyClass9;



public class MyClass9Builder
{

	
	
	private MyClass9 myclass9;
    

	
	public MyClass9Builder attribute (String attribute) 
	{
		myclass9.setAttribute (attribute);
		return this;	
	}

	
	public MyClass9 build () 
	{
		return myclass9;	
	}

	
	public MyClass9Builder id (Long id) 
	{
		myclass9.setId (id);
		return this;	
	}

	
	public MyClass9Builder initMyClass9 () 
	{
		myclass9 = new MyClass9();
		return this;	
	}


}
