package big.domain.factories;

import big.domain.MyClass105;



public class MyClass105Builder
{

	
	
	private MyClass105 myclass105;
    

	
	public MyClass105 build () 
	{
		return myclass105;	
	}

	
	public MyClass105Builder id (Long id) 
	{
		myclass105.setId (id);
		return this;	
	}

	
	public MyClass105Builder initMyClass105 () 
	{
		myclass105 = new MyClass105();
		return this;	
	}


}
