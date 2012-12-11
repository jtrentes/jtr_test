package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class MyClass2
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	
	private String attribute2;
	
	
	private String attribute3;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@OneToOne(optional = true, cascade = javax.persistence.CascadeType.ALL)
	private MyClass myclass;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public String getAttribute2 () 
	{
		return this.attribute2;	
	}

	
	public String getAttribute3 () 
	{
		return this.attribute3;	
	}

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass getMyclass () 
	{
		return this.myclass;	
	}

	
	public void operation () 
	{
		// TODO : to implement
			
	}

	
	public void operation2 () 
	{
		// TODO : to implement
			
	}

	
	public void setAttribute (String myAttribute) 
	{
		this.attribute = myAttribute;	
	}

	
	public void setAttribute2 (String myAttribute2) 
	{
		this.attribute2 = myAttribute2;	
	}

	
	public void setAttribute3 (String myAttribute3) 
	{
		this.attribute3 = myAttribute3;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass (MyClass myMyclass) 
	{
		if (this.myclass != myMyclass) {
			MyClass oldmyclass = this.myclass;
			this.myclass = myMyclass;
			if (oldmyclass != null)
				oldmyclass.unsetMyclass2 ();
			if (myMyclass != null)
				myMyclass.setMyclass2 (this);
		}	
	}

	
	public void unsetAttribute () 
	{
		this.attribute = null;	
	}

	
	public void unsetAttribute2 () 
	{
		this.attribute2 = null;	
	}

	
	public void unsetAttribute3 () 
	{
		this.attribute3 = null;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass () 
	{
		if (this.myclass == null)
			return;
		MyClass oldmyclass = this.myclass;
		this.myclass = null;
		oldmyclass.unsetMyclass2 ();	
	}


}
