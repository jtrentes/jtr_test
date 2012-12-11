package big.domain.factories;

import big.domain.MyClass45;



public class MyClass45Builder
{

	
	
	private MyClass45 myclass45;
    

	
	public MyClass45 build () 
	{
		return myclass45;	
	}

	
	public MyClass45Builder id (Long id) 
	{
		myclass45.setId (id);
		return this;	
	}

	
	public MyClass45Builder initMyClass45 () 
	{
		myclass45 = new MyClass45();
		return this;	
	}


}
