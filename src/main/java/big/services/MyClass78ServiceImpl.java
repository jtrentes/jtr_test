package big.services;

import big.domain.MyClass78;
import java.util.List;
import big.repositories.MyClass78Repository;
import big.repositories.criteria.MyClass78Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass78Service")
@Transactional(readOnly = true)
public class MyClass78ServiceImpl implements MyClass78Service
{

	
	@Autowired
	private MyClass78Repository myClass78Repository;
    

	
	public List<MyClass78> findAll () 
	{
		return this.myClass78Repository.findAll();	
	}

	
	public List<MyClass78> findByCriteria (MyClass78Criteria criteria) 
	{
		return this.myClass78Repository.findByCriteria (criteria);	
	}

	
	public MyClass78 findById (Long id) 
	{
		return this.myClass78Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass78 save (MyClass78 myclass78) 
	{
		return this.myClass78Repository.save (myclass78);	
	}


}
