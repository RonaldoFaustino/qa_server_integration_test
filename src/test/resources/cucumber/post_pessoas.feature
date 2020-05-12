
Feature: Cadastro de Pessoas
		 Deve salvar nova pessoa no sistema
		 Testar salvar nova pessoa no sistema em basePath invalido
		 Nao deve ser possivel salvar duas pessoas com o mesmo CPF
     Nao deve ser possivel salvar duas pessoas com o mesmo telefone
     
  @positivo
  Scenario: Deve salvar nova pessoa no sistema
    Given I set baseURI
    Then  The endpoint is already configured
    And   I create a new pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    Then  I should have the status code "201"
    
    

  @negativo
  Scenario: Criação de usuário sem body
    Given I set baseURI
    Then  The endpoint is already configured
    And   I post pessoa on valid BasePath  
    Then  I should have the status code "400"
    

  @negativo
  Scenario:  Testar salvar nova pessoa no sistema em basePath invalido
    Given  I set baseURI
    Then The endpoint is already configured
    And   I create a new pessoa
    And   I set pessoa on body 
    And   I post pessoa on invalid BasePath  
    Then  I should have the status code "404"
    

   @negativo
   Scenario:   Nao deve ser possivel salvar duas pessoas com o mesmo CPF e Telefone
    Given  I set baseURI
    Then The endpoint is already configured
    And   I create a new pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    And   I should have the status code "201"
    And   I get last created pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    Then  I should have the status code "400"
    
    

   @negativo
   Scenario:   Nao deve ser possivel salvar duas pessoas com o mesmo CPF
    Given  I set baseURI
    Then The endpoint is already configured
    And   I create a new pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    And   I should have the status code "201"
    And   I get last created pessoa
    And   I update "telefone" of last pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    Then  I should have the status code "400"
    

   @negativo
  Scenario:   Nao deve ser possivel salvar duas pessoas com o mesmo Telefone
    Given  I set baseURI
    Then The endpoint is already configured
    And   I create a new pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    And   I should have the status code "201"
    And   I get last created pessoa
    And   I update "cpf" of last pessoa
    And   I set pessoa on body 
    And   I post pessoa on valid BasePath  
    Then  I should have the status code "400"
    
    
    
    
    
    
    
    
    
    
    
    

