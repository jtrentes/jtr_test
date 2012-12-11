package com.genmymodel.petshop.domain;




public class MyClass
{

	
	
	private String attribute;
	
	
	private Long id;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public void setAttribute (String myAttribute) 
	{
		this.attribute = myAttribute;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void unsetAttribute () 
	{
		this.attribute = null;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}


}
