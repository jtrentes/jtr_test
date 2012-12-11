package big.services;

import big.domain.MyClass8;
import big.repositories.criteria.MyClass8Criteria;
import big.repositories.MyClass8Repository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass8Service")
@Transactional(readOnly = true)
public class MyClass8ServiceImpl implements MyClass8Service
{

	
	@Autowired
	private MyClass8Repository myClass8Repository;
    

	
	public List<MyClass8> findAll () 
	{
		return this.myClass8Repository.findAll();	
	}

	
	public List<MyClass8> findByCriteria (MyClass8Criteria criteria) 
	{
		return this.myClass8Repository.findByCriteria (criteria);	
	}

	
	public MyClass8 findById (Long id) 
	{
		return this.myClass8Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass8 save (MyClass8 myclass8) 
	{
		return this.myClass8Repository.save (myclass8);	
	}


}
