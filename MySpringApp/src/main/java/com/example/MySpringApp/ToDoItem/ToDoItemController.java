package com.example.MySpringApp.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoItemController {
    @Autowired
    private ToDoItemService toDoItemService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody ToDoItemResponse get(@PathVariable(value="id") String id) {
        List<String> errors = new ArrayList<>();
        ToDoItem toDoItem = null;
        try {
            toDoItem = toDoItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }

}

//@RestController - "이 클래스틑 RESTful API를 위한 컨트롤러 클래스이다"라고 스프링에게 알려줌.
//@RequestMapping - 구체적으로 어떤 경로인지 지정 해 준다.
//@RequestMapping - 어떤 REST 메서를 사용 할 것인지, 어떤 경로인지, 또는 path variable을 받는 경우 path variable의 이름을 지정 해 줄 수 있다.
//@PathVariable - 어떤 Path Variable이 어느 변수에 맵핑되어야 하는지 알려준다. "/{id}" -> value="id" 얘가 Integer id에 맵핑된다.
//@ResponseBody - 이 메서드는 HTTP Response Body 부분을 JSON의 형태로 리턴 할 것임을 알려준다.
//@Getter, @Setter - Lombok 어노테이션
//우리는 RESTful API를 만들 것이므로 @RestController 어노테이션을 이용해 이 컨트롤러가 RESTful API임 스프링 부트에게 알려주도록 한다. 
//또한 @RequestMapping 어노테이션을 이용해 이 컨트롤러의 URL을 정해준다. 
//RequestMapping은 위 처럼 클래스 위에 하나, 메서드 위에 하나 정의 할 수 있는데 이 클래스 안의 모든 메서드들은 클래스의 RequestMapping을 공유한다. 
//따라서 http://localhost:8080/todo/{id}/ 를 보면 '/todo'는 클래스위에 '/{id}'는 메서드레벨에 정의 된 것을 확인 할 수 있다.

//이 컨트롤러는 ToDoItemService를 사용하므로 이를 추가해 줬다. @Getter, @Setter가 알아서 getter, setter를 만들어 준다.
//@RequestMapping에 method = RequestMethod.GET이 보이는가? 
//바로 이 부분에서 우리는 RESTful API의 네 가지 Method중 어떤 것을 이용 할 지 선택하는 것이다. 
//우리는 GET을 이용 할 것이므로 GET으로 선택하고 value에는 /{id}를 넣었다. 이 id는 아래의 @PathVariable의 value 값과 같은 값이어야 한다.
