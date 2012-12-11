package big.domain.factories;

import big.domain.MyClass118;



public class MyClass118Builder
{

	
	
	private MyClass118 myclass118;
    

	
	public MyClass118 build () 
	{
		return myclass118;	
	}

	
	public MyClass118Builder id (Long id) 
	{
		myclass118.setId (id);
		return this;	
	}

	
	public MyClass118Builder initMyClass118 () 
	{
		myclass118 = new MyClass118();
		return this;	
	}


}
