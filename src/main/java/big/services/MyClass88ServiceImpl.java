package big.services;

import java.util.List;
import big.repositories.criteria.MyClass88Criteria;
import big.domain.MyClass88;
import big.repositories.MyClass88Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass88Service")
@Transactional(readOnly = true)
public class MyClass88ServiceImpl implements MyClass88Service
{

	
	@Autowired
	private MyClass88Repository myClass88Repository;
    

	
	public List<MyClass88> findAll () 
	{
		return this.myClass88Repository.findAll();	
	}

	
	public List<MyClass88> findByCriteria (MyClass88Criteria criteria) 
	{
		return this.myClass88Repository.findByCriteria (criteria);	
	}

	
	public MyClass88 findById (Long id) 
	{
		return this.myClass88Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass88 save (MyClass88 myclass88) 
	{
		return this.myClass88Repository.save (myclass88);	
	}


}
