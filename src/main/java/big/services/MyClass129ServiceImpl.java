package big.services;

import big.repositories.MyClass129Repository;
import java.util.List;
import big.repositories.criteria.MyClass129Criteria;
import big.domain.MyClass129;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass129Service")
@Transactional(readOnly = true)
public class MyClass129ServiceImpl implements MyClass129Service
{

	
	@Autowired
	private MyClass129Repository myClass129Repository;
    

	
	public List<MyClass129> findAll () 
	{
		return this.myClass129Repository.findAll();	
	}

	
	public List<MyClass129> findByCriteria (MyClass129Criteria criteria) 
	{
		return this.myClass129Repository.findByCriteria (criteria);	
	}

	
	public MyClass129 findById (Long id) 
	{
		return this.myClass129Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass129 save (MyClass129 myclass129) 
	{
		return this.myClass129Repository.save (myclass129);	
	}


}
