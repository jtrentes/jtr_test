package big.domain.factories;

import big.domain.MyClass70;



public class MyClass70Builder
{

	
	
	private MyClass70 myclass70;
    

	
	public MyClass70 build () 
	{
		return myclass70;	
	}

	
	public MyClass70Builder id (Long id) 
	{
		myclass70.setId (id);
		return this;	
	}

	
	public MyClass70Builder initMyClass70 () 
	{
		myclass70 = new MyClass70();
		return this;	
	}


}
