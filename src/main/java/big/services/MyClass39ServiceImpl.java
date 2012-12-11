package big.services;

import java.util.List;
import big.repositories.MyClass39Repository;
import big.repositories.criteria.MyClass39Criteria;
import big.domain.MyClass39;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass39Service")
@Transactional(readOnly = true)
public class MyClass39ServiceImpl implements MyClass39Service
{

	
	@Autowired
	private MyClass39Repository myClass39Repository;
    

	
	public List<MyClass39> findAll () 
	{
		return this.myClass39Repository.findAll();	
	}

	
	public List<MyClass39> findByCriteria (MyClass39Criteria criteria) 
	{
		return this.myClass39Repository.findByCriteria (criteria);	
	}

	
	public MyClass39 findById (Long id) 
	{
		return this.myClass39Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass39 save (MyClass39 myclass39) 
	{
		return this.myClass39Repository.save (myclass39);	
	}


}
