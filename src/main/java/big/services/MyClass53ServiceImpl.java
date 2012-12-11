package big.services;

import big.repositories.MyClass53Repository;
import java.util.List;
import big.domain.MyClass53;
import big.repositories.criteria.MyClass53Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass53Service")
@Transactional(readOnly = true)
public class MyClass53ServiceImpl implements MyClass53Service
{

	
	@Autowired
	private MyClass53Repository myClass53Repository;
    

	
	public List<MyClass53> findAll () 
	{
		return this.myClass53Repository.findAll();	
	}

	
	public List<MyClass53> findByCriteria (MyClass53Criteria criteria) 
	{
		return this.myClass53Repository.findByCriteria (criteria);	
	}

	
	public MyClass53 findById (Long id) 
	{
		return this.myClass53Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass53 save (MyClass53 myclass53) 
	{
		return this.myClass53Repository.save (myclass53);	
	}


}
