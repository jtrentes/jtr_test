package big.domain.factories;

import big.domain.MyClass49;



public class MyClass49Builder
{

	
	
	private MyClass49 myclass49;
    

	
	public MyClass49 build () 
	{
		return myclass49;	
	}

	
	public MyClass49Builder id (Long id) 
	{
		myclass49.setId (id);
		return this;	
	}

	
	public MyClass49Builder initMyClass49 () 
	{
		myclass49 = new MyClass49();
		return this;	
	}


}
