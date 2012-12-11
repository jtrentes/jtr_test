package big.services;

import java.util.List;
import big.repositories.criteria.MyClass146Criteria;
import big.repositories.MyClass146Repository;
import big.domain.MyClass146;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass146Service")
@Transactional(readOnly = true)
public class MyClass146ServiceImpl implements MyClass146Service
{

	
	@Autowired
	private MyClass146Repository myClass146Repository;
    

	
	public List<MyClass146> findAll () 
	{
		return this.myClass146Repository.findAll();	
	}

	
	public List<MyClass146> findByCriteria (MyClass146Criteria criteria) 
	{
		return this.myClass146Repository.findByCriteria (criteria);	
	}

	
	public MyClass146 findById (Long id) 
	{
		return this.myClass146Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass146 save (MyClass146 myclass146) 
	{
		return this.myClass146Repository.save (myclass146);	
	}


}
