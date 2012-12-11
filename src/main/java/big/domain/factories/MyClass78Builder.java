package big.domain.factories;

import big.domain.MyClass78;



public class MyClass78Builder
{

	
	
	private MyClass78 myclass78;
    

	
	public MyClass78 build () 
	{
		return myclass78;	
	}

	
	public MyClass78Builder id (Long id) 
	{
		myclass78.setId (id);
		return this;	
	}

	
	public MyClass78Builder initMyClass78 () 
	{
		myclass78 = new MyClass78();
		return this;	
	}


}
