package big.services;

import big.repositories.criteria.MyClass96Criteria;
import java.util.List;
import big.repositories.MyClass96Repository;
import big.domain.MyClass96;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass96Service")
@Transactional(readOnly = true)
public class MyClass96ServiceImpl implements MyClass96Service
{

	
	@Autowired
	private MyClass96Repository myClass96Repository;
    

	
	public List<MyClass96> findAll () 
	{
		return this.myClass96Repository.findAll();	
	}

	
	public List<MyClass96> findByCriteria (MyClass96Criteria criteria) 
	{
		return this.myClass96Repository.findByCriteria (criteria);	
	}

	
	public MyClass96 findById (Long id) 
	{
		return this.myClass96Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass96 save (MyClass96 myclass96) 
	{
		return this.myClass96Repository.save (myclass96);	
	}


}
