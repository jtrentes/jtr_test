package big.domain.factories;

import big.domain.MyClass153;



public class MyClass153Builder
{

	
	
	private MyClass153 myclass153;
    

	
	public MyClass153 build () 
	{
		return myclass153;	
	}

	
	public MyClass153Builder id (Long id) 
	{
		myclass153.setId (id);
		return this;	
	}

	
	public MyClass153Builder initMyClass153 () 
	{
		myclass153 = new MyClass153();
		return this;	
	}


}
