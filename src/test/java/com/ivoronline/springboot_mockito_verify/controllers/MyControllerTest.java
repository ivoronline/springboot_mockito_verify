package com.ivoronline.springboot_mockito_verify.controllers;

import com.ivoronline.springboot_mockito_verify.entities.Person;
import com.ivoronline.springboot_mockito_verify.respositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyControllerTest {

  //MOCK DEPENDENCY CLASS
  @Mock PersonRepository personRepositoryMock;

  //INJECT MOCKS (where @autowired is used)
  @InjectMocks MyController myController;

  //ENDPOINT
  @Test
  void getPerson() {

    //MOCK REPOSITORY METHOD
    when(personRepositoryMock.getPersonById(1)).thenReturn(new Person(1, "Susan", 50));

    //CALL REPOSITORY METHOD 2 TIMES
    myController.getPerson(1);
    myController.getPerson(1);

    //VERIFY THAT METHOD getPersonById() WAS CALLED EXACTLY 2 TIMES WITH PARAMETER 1
    verify(personRepositoryMock, times(2)).getPersonById(1);

  }

}
