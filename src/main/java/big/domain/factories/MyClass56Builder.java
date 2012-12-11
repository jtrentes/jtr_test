package big.domain.factories;

import big.domain.MyClass56;



public class MyClass56Builder
{

	
	
	private MyClass56 myclass56;
    

	
	public MyClass56 build () 
	{
		return myclass56;	
	}

	
	public MyClass56Builder id (Long id) 
	{
		myclass56.setId (id);
		return this;	
	}

	
	public MyClass56Builder initMyClass56 () 
	{
		myclass56 = new MyClass56();
		return this;	
	}


}
