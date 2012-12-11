package big.services;

import big.repositories.criteria.MyClass42Criteria;
import big.repositories.MyClass42Repository;
import java.util.List;
import big.domain.MyClass42;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass42Service")
@Transactional(readOnly = true)
public class MyClass42ServiceImpl implements MyClass42Service
{

	
	@Autowired
	private MyClass42Repository myClass42Repository;
    

	
	public List<MyClass42> findAll () 
	{
		return this.myClass42Repository.findAll();	
	}

	
	public List<MyClass42> findByCriteria (MyClass42Criteria criteria) 
	{
		return this.myClass42Repository.findByCriteria (criteria);	
	}

	
	public MyClass42 findById (Long id) 
	{
		return this.myClass42Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass42 save (MyClass42 myclass42) 
	{
		return this.myClass42Repository.save (myclass42);	
	}


}
