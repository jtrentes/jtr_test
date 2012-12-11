package big.services;

import big.repositories.MyClass26Repository;
import big.domain.MyClass26;
import big.repositories.criteria.MyClass26Criteria;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass26Service")
@Transactional(readOnly = true)
public class MyClass26ServiceImpl implements MyClass26Service
{

	
	@Autowired
	private MyClass26Repository myClass26Repository;
    

	
	public List<MyClass26> findAll () 
	{
		return this.myClass26Repository.findAll();	
	}

	
	public List<MyClass26> findByCriteria (MyClass26Criteria criteria) 
	{
		return this.myClass26Repository.findByCriteria (criteria);	
	}

	
	public MyClass26 findById (Long id) 
	{
		return this.myClass26Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass26 save (MyClass26 myclass26) 
	{
		return this.myClass26Repository.save (myclass26);	
	}


}
