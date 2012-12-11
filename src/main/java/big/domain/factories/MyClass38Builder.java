package big.domain.factories;

import big.domain.MyClass38;



public class MyClass38Builder
{

	
	
	private MyClass38 myclass38;
    

	
	public MyClass38 build () 
	{
		return myclass38;	
	}

	
	public MyClass38Builder id (Long id) 
	{
		myclass38.setId (id);
		return this;	
	}

	
	public MyClass38Builder initMyClass38 () 
	{
		myclass38 = new MyClass38();
		return this;	
	}


}
