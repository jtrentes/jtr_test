package big.services;

import big.repositories.criteria.MyClass126Criteria;
import big.domain.MyClass126;
import java.util.List;
import big.repositories.MyClass126Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass126Service")
@Transactional(readOnly = true)
public class MyClass126ServiceImpl implements MyClass126Service
{

	
	@Autowired
	private MyClass126Repository myClass126Repository;
    

	
	public List<MyClass126> findAll () 
	{
		return this.myClass126Repository.findAll();	
	}

	
	public List<MyClass126> findByCriteria (MyClass126Criteria criteria) 
	{
		return this.myClass126Repository.findByCriteria (criteria);	
	}

	
	public MyClass126 findById (Long id) 
	{
		return this.myClass126Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass126 save (MyClass126 myclass126) 
	{
		return this.myClass126Repository.save (myclass126);	
	}


}
