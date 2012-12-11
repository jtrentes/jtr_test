package big.domain.factories;

import big.domain.MyClass126;



public class MyClass126Builder
{

	
	
	private MyClass126 myclass126;
    

	
	public MyClass126 build () 
	{
		return myclass126;	
	}

	
	public MyClass126Builder id (Long id) 
	{
		myclass126.setId (id);
		return this;	
	}

	
	public MyClass126Builder initMyClass126 () 
	{
		myclass126 = new MyClass126();
		return this;	
	}


}
