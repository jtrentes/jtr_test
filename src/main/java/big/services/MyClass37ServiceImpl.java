package big.services;

import big.repositories.MyClass37Repository;
import big.repositories.criteria.MyClass37Criteria;
import big.domain.MyClass37;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass37Service")
@Transactional(readOnly = true)
public class MyClass37ServiceImpl implements MyClass37Service
{

	
	@Autowired
	private MyClass37Repository myClass37Repository;
    

	
	public List<MyClass37> findAll () 
	{
		return this.myClass37Repository.findAll();	
	}

	
	public List<MyClass37> findByCriteria (MyClass37Criteria criteria) 
	{
		return this.myClass37Repository.findByCriteria (criteria);	
	}

	
	public MyClass37 findById (Long id) 
	{
		return this.myClass37Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass37 save (MyClass37 myclass37) 
	{
		return this.myClass37Repository.save (myclass37);	
	}


}
