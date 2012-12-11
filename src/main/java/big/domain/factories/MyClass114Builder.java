package big.domain.factories;

import big.domain.MyClass114;



public class MyClass114Builder
{

	
	
	private MyClass114 myclass114;
    

	
	public MyClass114 build () 
	{
		return myclass114;	
	}

	
	public MyClass114Builder id (Long id) 
	{
		myclass114.setId (id);
		return this;	
	}

	
	public MyClass114Builder initMyClass114 () 
	{
		myclass114 = new MyClass114();
		return this;	
	}


}
