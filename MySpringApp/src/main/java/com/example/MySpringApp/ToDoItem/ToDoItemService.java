package com.example.MySpringApp.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {

	public ToDoItem get(final String id) {
		// do id validation
		return ToDoItem.builder()
				.title("Add an id validation")
				.build();
	}
	
}

//서비스는 스프링에서 @Service 어노테이션으로 지정 해 줄 수 있다.
//이 서비스는 원래대로라면 id를 받아 JPA Repository 클래스를 이용해 데이터베이스에서 이 id를 검색해야한다. 
//하지만 우리는 지금 데이터베이스가 없다. 그래서 일단 임의로 ToDoItem를 만들어 ToDoItemResponse에 넣어 리턴 하려 한다. 

