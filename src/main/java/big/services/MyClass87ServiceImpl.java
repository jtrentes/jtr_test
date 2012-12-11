package big.services;

import java.util.List;
import big.domain.MyClass87;
import big.repositories.criteria.MyClass87Criteria;
import big.repositories.MyClass87Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass87Service")
@Transactional(readOnly = true)
public class MyClass87ServiceImpl implements MyClass87Service
{

	
	@Autowired
	private MyClass87Repository myClass87Repository;
    

	
	public List<MyClass87> findAll () 
	{
		return this.myClass87Repository.findAll();	
	}

	
	public List<MyClass87> findByCriteria (MyClass87Criteria criteria) 
	{
		return this.myClass87Repository.findByCriteria (criteria);	
	}

	
	public MyClass87 findById (Long id) 
	{
		return this.myClass87Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass87 save (MyClass87 myclass87) 
	{
		return this.myClass87Repository.save (myclass87);	
	}


}
