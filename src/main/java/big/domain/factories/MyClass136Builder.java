package big.domain.factories;

import big.domain.MyClass136;



public class MyClass136Builder
{

	
	
	private MyClass136 myclass136;
    

	
	public MyClass136 build () 
	{
		return myclass136;	
	}

	
	public MyClass136Builder id (Long id) 
	{
		myclass136.setId (id);
		return this;	
	}

	
	public MyClass136Builder initMyClass136 () 
	{
		myclass136 = new MyClass136();
		return this;	
	}


}
