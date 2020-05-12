
Feature: Pesquisar Pessoas

  Quero pesquisar pessoas por ddd e telefone retornar codigo 200
  	pesquisar se ddd e telefone de pessoa nao cadastrada na api retorna erro 404
  			
  @positivo		 
  Scenario: pesquisar pessoas por ddd e telefone retornar codigo 200
        When I set baseURI
        When I input a valid userId "11" and phone "991288341"
    	  Then I should have the status code "200"
    	  And the body response content should be matched
   	       | key        | value                  |
      	   | codigo     | 1                      |
           | nome       | Rafael Teixeira        |
        Then content type should be in "JSON"
           
    @negativo      
    Scenario: Tentativa de buscar pessoa nao cadastrada por ddd e telefone retornar codigo 404
        When I set baseURI
        When I input a invalid userId "11" and phone "999999999"
    	  Then I should have the status code "404"
    	  
    @negativo	  
    Scenario: Tentativa de buscar pessoa nao cadastrada por ddd e telefone e basePath invalido retornar codigo 404
        When I set baseURI
        When I input a invalid userId "11" and phone "999999999" and invalid basePath
    	  Then I should have the status code "404"
    	  And the body response content should be matched
   	       | key        | value                  |
           | message    | No message available   |
           | error      | Not Found              |
           
      @negativo     
      Scenario: Tentativa de buscar pessoa cadastrada por ddd e telefone e basePath invalido retornar codigo 404
        Given I set baseURI
        When I input a invalid userId "11" and phone "991288341" and invalid basePath
    	  Then I should have the status code "404"
    	  And  the body response content should be matched
   	       | key        | value                  |
           | message    | No message available   |
           | error      | Not Found              |




