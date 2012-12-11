package big.domain.factories;

import big.domain.MyClass159;



public class MyClass159Builder
{

	
	
	private MyClass159 myclass159;
    

	
	public MyClass159 build () 
	{
		return myclass159;	
	}

	
	public MyClass159Builder id (Long id) 
	{
		myclass159.setId (id);
		return this;	
	}

	
	public MyClass159Builder initMyClass159 () 
	{
		myclass159 = new MyClass159();
		return this;	
	}


}
