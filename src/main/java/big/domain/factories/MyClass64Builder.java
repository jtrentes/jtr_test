package big.domain.factories;

import big.domain.MyClass64;



public class MyClass64Builder
{

	
	
	private MyClass64 myclass64;
    

	
	public MyClass64 build () 
	{
		return myclass64;	
	}

	
	public MyClass64Builder id (Long id) 
	{
		myclass64.setId (id);
		return this;	
	}

	
	public MyClass64Builder initMyClass64 () 
	{
		myclass64 = new MyClass64();
		return this;	
	}


}
