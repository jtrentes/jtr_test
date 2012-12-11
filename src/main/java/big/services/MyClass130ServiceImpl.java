package big.services;

import big.domain.MyClass130;
import big.repositories.criteria.MyClass130Criteria;
import big.repositories.MyClass130Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass130Service")
@Transactional(readOnly = true)
public class MyClass130ServiceImpl implements MyClass130Service
{

	
	@Autowired
	private MyClass130Repository myClass130Repository;
    

	
	public List<MyClass130> findAll () 
	{
		return this.myClass130Repository.findAll();	
	}

	
	public List<MyClass130> findByCriteria (MyClass130Criteria criteria) 
	{
		return this.myClass130Repository.findByCriteria (criteria);	
	}

	
	public MyClass130 findById (Long id) 
	{
		return this.myClass130Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass130 save (MyClass130 myclass130) 
	{
		return this.myClass130Repository.save (myclass130);	
	}


}
