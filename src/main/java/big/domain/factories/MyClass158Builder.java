package big.domain.factories;

import big.domain.MyClass158;



public class MyClass158Builder
{

	
	
	private MyClass158 myclass158;
    

	
	public MyClass158 build () 
	{
		return myclass158;	
	}

	
	public MyClass158Builder id (Long id) 
	{
		myclass158.setId (id);
		return this;	
	}

	
	public MyClass158Builder initMyClass158 () 
	{
		myclass158 = new MyClass158();
		return this;	
	}


}
