package big.services;

import big.repositories.MyClass119Repository;
import java.util.List;
import big.repositories.criteria.MyClass119Criteria;
import big.domain.MyClass119;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass119Service")
@Transactional(readOnly = true)
public class MyClass119ServiceImpl implements MyClass119Service
{

	
	@Autowired
	private MyClass119Repository myClass119Repository;
    

	
	public List<MyClass119> findAll () 
	{
		return this.myClass119Repository.findAll();	
	}

	
	public List<MyClass119> findByCriteria (MyClass119Criteria criteria) 
	{
		return this.myClass119Repository.findByCriteria (criteria);	
	}

	
	public MyClass119 findById (Long id) 
	{
		return this.myClass119Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass119 save (MyClass119 myclass119) 
	{
		return this.myClass119Repository.save (myclass119);	
	}


}
