package big.services;

import big.domain.MyClass147;
import big.repositories.MyClass147Repository;
import java.util.List;
import big.repositories.criteria.MyClass147Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass147Service")
@Transactional(readOnly = true)
public class MyClass147ServiceImpl implements MyClass147Service
{

	
	@Autowired
	private MyClass147Repository myClass147Repository;
    

	
	public List<MyClass147> findAll () 
	{
		return this.myClass147Repository.findAll();	
	}

	
	public List<MyClass147> findByCriteria (MyClass147Criteria criteria) 
	{
		return this.myClass147Repository.findByCriteria (criteria);	
	}

	
	public MyClass147 findById (Long id) 
	{
		return this.myClass147Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass147 save (MyClass147 myclass147) 
	{
		return this.myClass147Repository.save (myclass147);	
	}


}
