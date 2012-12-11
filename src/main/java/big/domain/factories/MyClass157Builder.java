package big.domain.factories;

import big.domain.MyClass157;



public class MyClass157Builder
{

	
	
	private MyClass157 myclass157;
    

	
	public MyClass157 build () 
	{
		return myclass157;	
	}

	
	public MyClass157Builder id (Long id) 
	{
		myclass157.setId (id);
		return this;	
	}

	
	public MyClass157Builder initMyClass157 () 
	{
		myclass157 = new MyClass157();
		return this;	
	}


}
