package big.services;

import big.domain.MyClass35;
import big.repositories.MyClass35Repository;
import java.util.List;
import big.repositories.criteria.MyClass35Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass35Service")
@Transactional(readOnly = true)
public class MyClass35ServiceImpl implements MyClass35Service
{

	
	@Autowired
	private MyClass35Repository myClass35Repository;
    

	
	public List<MyClass35> findAll () 
	{
		return this.myClass35Repository.findAll();	
	}

	
	public List<MyClass35> findByCriteria (MyClass35Criteria criteria) 
	{
		return this.myClass35Repository.findByCriteria (criteria);	
	}

	
	public MyClass35 findById (Long id) 
	{
		return this.myClass35Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass35 save (MyClass35 myclass35) 
	{
		return this.myClass35Repository.save (myclass35);	
	}


}
