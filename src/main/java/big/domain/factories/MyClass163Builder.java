package big.domain.factories;

import big.domain.MyClass163;



public class MyClass163Builder
{

	
	
	private MyClass163 myclass163;
    

	
	public MyClass163Builder attribute (String attribute) 
	{
		myclass163.setAttribute (attribute);
		return this;	
	}

	
	public MyClass163 build () 
	{
		return myclass163;	
	}

	
	public MyClass163Builder id (Long id) 
	{
		myclass163.setId (id);
		return this;	
	}

	
	public MyClass163Builder initMyClass163 () 
	{
		myclass163 = new MyClass163();
		return this;	
	}


}
