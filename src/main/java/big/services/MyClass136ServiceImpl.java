package big.services;

import big.repositories.criteria.MyClass136Criteria;
import big.domain.MyClass136;
import java.util.List;
import big.repositories.MyClass136Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass136Service")
@Transactional(readOnly = true)
public class MyClass136ServiceImpl implements MyClass136Service
{

	
	@Autowired
	private MyClass136Repository myClass136Repository;
    

	
	public List<MyClass136> findAll () 
	{
		return this.myClass136Repository.findAll();	
	}

	
	public List<MyClass136> findByCriteria (MyClass136Criteria criteria) 
	{
		return this.myClass136Repository.findByCriteria (criteria);	
	}

	
	public MyClass136 findById (Long id) 
	{
		return this.myClass136Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass136 save (MyClass136 myclass136) 
	{
		return this.myClass136Repository.save (myclass136);	
	}


}
