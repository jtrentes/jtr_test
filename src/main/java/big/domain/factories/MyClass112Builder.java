package big.domain.factories;

import big.domain.MyClass112;



public class MyClass112Builder
{

	
	
	private MyClass112 myclass112;
    

	
	public MyClass112 build () 
	{
		return myclass112;	
	}

	
	public MyClass112Builder id (Long id) 
	{
		myclass112.setId (id);
		return this;	
	}

	
	public MyClass112Builder initMyClass112 () 
	{
		myclass112 = new MyClass112();
		return this;	
	}


}
