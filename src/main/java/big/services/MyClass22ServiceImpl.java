package big.services;

import big.domain.MyClass22;
import big.repositories.criteria.MyClass22Criteria;
import java.util.List;
import big.repositories.MyClass22Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass22Service")
@Transactional(readOnly = true)
public class MyClass22ServiceImpl implements MyClass22Service
{

	
	@Autowired
	private MyClass22Repository myClass22Repository;
    

	
	public List<MyClass22> findAll () 
	{
		return this.myClass22Repository.findAll();	
	}

	
	public List<MyClass22> findByCriteria (MyClass22Criteria criteria) 
	{
		return this.myClass22Repository.findByCriteria (criteria);	
	}

	
	public MyClass22 findById (Long id) 
	{
		return this.myClass22Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass22 save (MyClass22 myclass22) 
	{
		return this.myClass22Repository.save (myclass22);	
	}


}
