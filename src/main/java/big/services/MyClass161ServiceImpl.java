package big.services;

import big.domain.MyClass161;
import java.util.List;
import big.repositories.MyClass161Repository;
import big.repositories.criteria.MyClass161Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass161Service")
@Transactional(readOnly = true)
public class MyClass161ServiceImpl implements MyClass161Service
{

	
	@Autowired
	private MyClass161Repository myClass161Repository;
    

	
	public List<MyClass161> findAll () 
	{
		return this.myClass161Repository.findAll();	
	}

	
	public List<MyClass161> findByCriteria (MyClass161Criteria criteria) 
	{
		return this.myClass161Repository.findByCriteria (criteria);	
	}

	
	public MyClass161 findById (Long id) 
	{
		return this.myClass161Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass161 save (MyClass161 myclass161) 
	{
		return this.myClass161Repository.save (myclass161);	
	}


}
