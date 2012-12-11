package big.services;

import big.repositories.criteria.MyClass71Criteria;
import big.repositories.MyClass71Repository;
import big.domain.MyClass71;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass71Service")
@Transactional(readOnly = true)
public class MyClass71ServiceImpl implements MyClass71Service
{

	
	@Autowired
	private MyClass71Repository myClass71Repository;
    

	
	public List<MyClass71> findAll () 
	{
		return this.myClass71Repository.findAll();	
	}

	
	public List<MyClass71> findByCriteria (MyClass71Criteria criteria) 
	{
		return this.myClass71Repository.findByCriteria (criteria);	
	}

	
	public MyClass71 findById (Long id) 
	{
		return this.myClass71Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass71 save (MyClass71 myclass71) 
	{
		return this.myClass71Repository.save (myclass71);	
	}


}
