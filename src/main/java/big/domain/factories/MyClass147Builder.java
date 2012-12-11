package big.domain.factories;

import big.domain.MyClass147;



public class MyClass147Builder
{

	
	
	private MyClass147 myclass147;
    

	
	public MyClass147 build () 
	{
		return myclass147;	
	}

	
	public MyClass147Builder id (Long id) 
	{
		myclass147.setId (id);
		return this;	
	}

	
	public MyClass147Builder initMyClass147 () 
	{
		myclass147 = new MyClass147();
		return this;	
	}


}
