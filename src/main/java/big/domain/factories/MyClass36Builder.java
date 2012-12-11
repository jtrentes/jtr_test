package big.domain.factories;

import big.domain.MyClass36;



public class MyClass36Builder
{

	
	
	private MyClass36 myclass36;
    

	
	public MyClass36 build () 
	{
		return myclass36;	
	}

	
	public MyClass36Builder id (Long id) 
	{
		myclass36.setId (id);
		return this;	
	}

	
	public MyClass36Builder initMyClass36 () 
	{
		myclass36 = new MyClass36();
		return this;	
	}


}
