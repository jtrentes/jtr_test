package big.domain.factories;

import big.domain.MyClass80;



public class MyClass80Builder
{

	
	
	private MyClass80 myclass80;
    

	
	public MyClass80 build () 
	{
		return myclass80;	
	}

	
	public MyClass80Builder id (Long id) 
	{
		myclass80.setId (id);
		return this;	
	}

	
	public MyClass80Builder initMyClass80 () 
	{
		myclass80 = new MyClass80();
		return this;	
	}


}
