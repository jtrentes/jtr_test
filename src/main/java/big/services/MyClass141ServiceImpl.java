package big.services;

import big.repositories.criteria.MyClass141Criteria;
import java.util.List;
import big.repositories.MyClass141Repository;
import big.domain.MyClass141;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass141Service")
@Transactional(readOnly = true)
public class MyClass141ServiceImpl implements MyClass141Service
{

	
	@Autowired
	private MyClass141Repository myClass141Repository;
    

	
	public List<MyClass141> findAll () 
	{
		return this.myClass141Repository.findAll();	
	}

	
	public List<MyClass141> findByCriteria (MyClass141Criteria criteria) 
	{
		return this.myClass141Repository.findByCriteria (criteria);	
	}

	
	public MyClass141 findById (Long id) 
	{
		return this.myClass141Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass141 save (MyClass141 myclass141) 
	{
		return this.myClass141Repository.save (myclass141);	
	}


}
