package big.domain.factories;

import big.domain.MyClass8;



public class MyClass8Builder
{

	
	
	private MyClass8 myclass8;
    

	
	public MyClass8 build () 
	{
		return myclass8;	
	}

	
	public MyClass8Builder id (Long id) 
	{
		myclass8.setId (id);
		return this;	
	}

	
	public MyClass8Builder initMyClass8 () 
	{
		myclass8 = new MyClass8();
		return this;	
	}


}
