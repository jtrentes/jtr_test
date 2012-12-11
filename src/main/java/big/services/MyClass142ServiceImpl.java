package big.services;

import java.util.List;
import big.repositories.MyClass142Repository;
import big.repositories.criteria.MyClass142Criteria;
import big.domain.MyClass142;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass142Service")
@Transactional(readOnly = true)
public class MyClass142ServiceImpl implements MyClass142Service
{

	
	@Autowired
	private MyClass142Repository myClass142Repository;
    

	
	public List<MyClass142> findAll () 
	{
		return this.myClass142Repository.findAll();	
	}

	
	public List<MyClass142> findByCriteria (MyClass142Criteria criteria) 
	{
		return this.myClass142Repository.findByCriteria (criteria);	
	}

	
	public MyClass142 findById (Long id) 
	{
		return this.myClass142Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass142 save (MyClass142 myclass142) 
	{
		return this.myClass142Repository.save (myclass142);	
	}


}
