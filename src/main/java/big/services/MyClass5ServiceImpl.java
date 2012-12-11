package big.services;

import java.util.List;
import big.repositories.MyClass5Repository;
import big.repositories.criteria.MyClass5Criteria;
import big.domain.MyClass5;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass5Service")
@Transactional(readOnly = true)
public class MyClass5ServiceImpl implements MyClass5Service
{

	
	@Autowired
	private MyClass5Repository myClass5Repository;
    

	
	public List<MyClass5> findAll () 
	{
		return this.myClass5Repository.findAll();	
	}

	
	public List<MyClass5> findByCriteria (MyClass5Criteria criteria) 
	{
		return this.myClass5Repository.findByCriteria (criteria);	
	}

	
	public MyClass5 findById (Long id) 
	{
		return this.myClass5Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass5 save (MyClass5 myclass5) 
	{
		return this.myClass5Repository.save (myclass5);	
	}


}
