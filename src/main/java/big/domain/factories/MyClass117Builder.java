package big.domain.factories;

import big.domain.MyClass117;



public class MyClass117Builder
{

	
	
	private MyClass117 myclass117;
    

	
	public MyClass117 build () 
	{
		return myclass117;	
	}

	
	public MyClass117Builder id (Long id) 
	{
		myclass117.setId (id);
		return this;	
	}

	
	public MyClass117Builder initMyClass117 () 
	{
		myclass117 = new MyClass117();
		return this;	
	}


}
