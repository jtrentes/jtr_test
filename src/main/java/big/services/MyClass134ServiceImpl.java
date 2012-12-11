package big.services;

import big.domain.MyClass134;
import big.repositories.MyClass134Repository;
import java.util.List;
import big.repositories.criteria.MyClass134Criteria;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass134Service")
@Transactional(readOnly = true)
public class MyClass134ServiceImpl implements MyClass134Service
{

	
	@Autowired
	private MyClass134Repository myClass134Repository;
    

	
	public List<MyClass134> findAll () 
	{
		return this.myClass134Repository.findAll();	
	}

	
	public List<MyClass134> findByCriteria (MyClass134Criteria criteria) 
	{
		return this.myClass134Repository.findByCriteria (criteria);	
	}

	
	public MyClass134 findById (Long id) 
	{
		return this.myClass134Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass134 save (MyClass134 myclass134) 
	{
		return this.myClass134Repository.save (myclass134);	
	}


}
