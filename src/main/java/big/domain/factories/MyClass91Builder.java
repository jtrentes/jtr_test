package big.domain.factories;

import big.domain.MyClass91;



public class MyClass91Builder
{

	
	
	private MyClass91 myclass91;
    

	
	public MyClass91 build () 
	{
		return myclass91;	
	}

	
	public MyClass91Builder id (Long id) 
	{
		myclass91.setId (id);
		return this;	
	}

	
	public MyClass91Builder initMyClass91 () 
	{
		myclass91 = new MyClass91();
		return this;	
	}


}
