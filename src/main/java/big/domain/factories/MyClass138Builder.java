package big.domain.factories;

import big.domain.MyClass138;



public class MyClass138Builder
{

	
	
	private MyClass138 myclass138;
    

	
	public MyClass138 build () 
	{
		return myclass138;	
	}

	
	public MyClass138Builder id (Long id) 
	{
		myclass138.setId (id);
		return this;	
	}

	
	public MyClass138Builder initMyClass138 () 
	{
		myclass138 = new MyClass138();
		return this;	
	}


}
