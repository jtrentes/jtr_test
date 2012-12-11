package big.domain.factories;

import big.domain.MyClass99;



public class MyClass99Builder
{

	
	
	private MyClass99 myclass99;
    

	
	public MyClass99 build () 
	{
		return myclass99;	
	}

	
	public MyClass99Builder id (Long id) 
	{
		myclass99.setId (id);
		return this;	
	}

	
	public MyClass99Builder initMyClass99 () 
	{
		myclass99 = new MyClass99();
		return this;	
	}


}
