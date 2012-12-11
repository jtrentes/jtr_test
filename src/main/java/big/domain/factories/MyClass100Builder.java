package big.domain.factories;

import big.domain.MyClass100;



public class MyClass100Builder
{

	
	
	private MyClass100 myclass100;
    

	
	public MyClass100 build () 
	{
		return myclass100;	
	}

	
	public MyClass100Builder id (Long id) 
	{
		myclass100.setId (id);
		return this;	
	}

	
	public MyClass100Builder initMyClass100 () 
	{
		myclass100 = new MyClass100();
		return this;	
	}


}
