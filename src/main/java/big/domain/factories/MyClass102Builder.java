package big.domain.factories;

import big.domain.MyClass102;



public class MyClass102Builder
{

	
	
	private MyClass102 myclass102;
    

	
	public MyClass102 build () 
	{
		return myclass102;	
	}

	
	public MyClass102Builder id (Long id) 
	{
		myclass102.setId (id);
		return this;	
	}

	
	public MyClass102Builder initMyClass102 () 
	{
		myclass102 = new MyClass102();
		return this;	
	}


}
