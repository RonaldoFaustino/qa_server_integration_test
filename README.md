## Pré condições 
- Maven / Java 8

## Usage

```
     mvn clean install 
```

## Relatório de testes
   .\output\extent-report\index.html
   
## bugs

1. EndPoint GET PESSOA incorreto na descrição da documentação do desafio 
	*  documentação   > localhost:8080/{ddd}/{numero}
	*  api            > localhost:8080/pessoas/{ddd}/{numero}
2. não validando cpf 
3. aceitando string  no  cpf
4. cpf  aceitando valor  com menos de 11 caracteres ou nulo
5. telefone  aceitando string no  número do telefone 
6. telefone  aceitando valor com menos de 8 caracteres ou nulo
7. ddd  aceitando string ANSI no ddd 
8. ddd   aceitando valor com menos de 8 caracteres
9. ddd   aceitando valor  nulo ou menor que dois caracteres 


