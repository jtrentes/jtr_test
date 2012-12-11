package big.domain.factories;

import big.domain.MyClass89;



public class MyClass89Builder
{

	
	
	private MyClass89 myclass89;
    

	
	public MyClass89 build () 
	{
		return myclass89;	
	}

	
	public MyClass89Builder id (Long id) 
	{
		myclass89.setId (id);
		return this;	
	}

	
	public MyClass89Builder initMyClass89 () 
	{
		myclass89 = new MyClass89();
		return this;	
	}


}
