package big.services;

import big.domain.MyClass160;
import java.util.List;
import big.repositories.MyClass160Repository;
import big.repositories.criteria.MyClass160Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass160Service")
@Transactional(readOnly = true)
public class MyClass160ServiceImpl implements MyClass160Service
{

	
	@Autowired
	private MyClass160Repository myClass160Repository;
    

	
	public List<MyClass160> findAll () 
	{
		return this.myClass160Repository.findAll();	
	}

	
	public List<MyClass160> findByCriteria (MyClass160Criteria criteria) 
	{
		return this.myClass160Repository.findByCriteria (criteria);	
	}

	
	public MyClass160 findById (Long id) 
	{
		return this.myClass160Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass160 save (MyClass160 myclass160) 
	{
		return this.myClass160Repository.save (myclass160);	
	}


}
