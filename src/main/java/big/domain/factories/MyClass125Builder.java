package big.domain.factories;

import big.domain.MyClass125;



public class MyClass125Builder
{

	
	
	private MyClass125 myclass125;
    

	
	public MyClass125 build () 
	{
		return myclass125;	
	}

	
	public MyClass125Builder id (Long id) 
	{
		myclass125.setId (id);
		return this;	
	}

	
	public MyClass125Builder initMyClass125 () 
	{
		myclass125 = new MyClass125();
		return this;	
	}


}
