package big.services;

import big.repositories.MyClass57Repository;
import big.repositories.criteria.MyClass57Criteria;
import big.domain.MyClass57;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass57Service")
@Transactional(readOnly = true)
public class MyClass57ServiceImpl implements MyClass57Service
{

	
	@Autowired
	private MyClass57Repository myClass57Repository;
    

	
	public List<MyClass57> findAll () 
	{
		return this.myClass57Repository.findAll();	
	}

	
	public List<MyClass57> findByCriteria (MyClass57Criteria criteria) 
	{
		return this.myClass57Repository.findByCriteria (criteria);	
	}

	
	public MyClass57 findById (Long id) 
	{
		return this.myClass57Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass57 save (MyClass57 myclass57) 
	{
		return this.myClass57Repository.save (myclass57);	
	}


}
