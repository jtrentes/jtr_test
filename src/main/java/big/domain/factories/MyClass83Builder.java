package big.domain.factories;

import big.domain.MyClass83;



public class MyClass83Builder
{

	
	
	private MyClass83 myclass83;
    

	
	public MyClass83 build () 
	{
		return myclass83;	
	}

	
	public MyClass83Builder id (Long id) 
	{
		myclass83.setId (id);
		return this;	
	}

	
	public MyClass83Builder initMyClass83 () 
	{
		myclass83 = new MyClass83();
		return this;	
	}


}
