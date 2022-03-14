package com.example.MySpringApp.ApiResponse;

import lombok.*;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor

public class ApiResponse<T> {
@NonNull private T data;
private List<String> errors;
}


//이렇게 하면 data에는 어떤 모델이든 들어갈수있고, 
//각 리스폰스는 항상 errors라는 에러 리스트를 가지고 있으므로 리스폰마다 List<String> error를 추가하지않아도된다
