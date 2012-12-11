package big.services;

import java.util.List;
import big.domain.MyClass155;
import big.repositories.MyClass155Repository;
import big.repositories.criteria.MyClass155Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass155Service")
@Transactional(readOnly = true)
public class MyClass155ServiceImpl implements MyClass155Service
{

	
	@Autowired
	private MyClass155Repository myClass155Repository;
    

	
	public List<MyClass155> findAll () 
	{
		return this.myClass155Repository.findAll();	
	}

	
	public List<MyClass155> findByCriteria (MyClass155Criteria criteria) 
	{
		return this.myClass155Repository.findByCriteria (criteria);	
	}

	
	public MyClass155 findById (Long id) 
	{
		return this.myClass155Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass155 save (MyClass155 myclass155) 
	{
		return this.myClass155Repository.save (myclass155);	
	}


}
