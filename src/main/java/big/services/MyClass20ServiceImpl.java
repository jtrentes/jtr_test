package big.services;

import java.util.List;
import big.repositories.MyClass20Repository;
import big.repositories.criteria.MyClass20Criteria;
import big.domain.MyClass20;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass20Service")
@Transactional(readOnly = true)
public class MyClass20ServiceImpl implements MyClass20Service
{

	
	@Autowired
	private MyClass20Repository myClass20Repository;
    

	
	public List<MyClass20> findAll () 
	{
		return this.myClass20Repository.findAll();	
	}

	
	public List<MyClass20> findByCriteria (MyClass20Criteria criteria) 
	{
		return this.myClass20Repository.findByCriteria (criteria);	
	}

	
	public MyClass20 findById (Long id) 
	{
		return this.myClass20Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass20 save (MyClass20 myclass20) 
	{
		return this.myClass20Repository.save (myclass20);	
	}


}
