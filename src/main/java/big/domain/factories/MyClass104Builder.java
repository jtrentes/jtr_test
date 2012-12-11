package big.domain.factories;

import big.domain.MyClass104;



public class MyClass104Builder
{

	
	
	private MyClass104 myclass104;
    

	
	public MyClass104 build () 
	{
		return myclass104;	
	}

	
	public MyClass104Builder id (Long id) 
	{
		myclass104.setId (id);
		return this;	
	}

	
	public MyClass104Builder initMyClass104 () 
	{
		myclass104 = new MyClass104();
		return this;	
	}


}
