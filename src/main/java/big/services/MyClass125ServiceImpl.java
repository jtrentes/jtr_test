package big.services;

import big.repositories.criteria.MyClass125Criteria;
import big.domain.MyClass125;
import java.util.List;
import big.repositories.MyClass125Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass125Service")
@Transactional(readOnly = true)
public class MyClass125ServiceImpl implements MyClass125Service
{

	
	@Autowired
	private MyClass125Repository myClass125Repository;
    

	
	public List<MyClass125> findAll () 
	{
		return this.myClass125Repository.findAll();	
	}

	
	public List<MyClass125> findByCriteria (MyClass125Criteria criteria) 
	{
		return this.myClass125Repository.findByCriteria (criteria);	
	}

	
	public MyClass125 findById (Long id) 
	{
		return this.myClass125Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass125 save (MyClass125 myclass125) 
	{
		return this.myClass125Repository.save (myclass125);	
	}


}
