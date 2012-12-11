package big.domain.factories;

import big.domain.MyClass16;



public class MyClass16Builder
{

	
	
	private MyClass16 myclass16;
    

	
	public MyClass16 build () 
	{
		return myclass16;	
	}

	
	public MyClass16Builder id (Long id) 
	{
		myclass16.setId (id);
		return this;	
	}

	
	public MyClass16Builder initMyClass16 () 
	{
		myclass16 = new MyClass16();
		return this;	
	}


}
