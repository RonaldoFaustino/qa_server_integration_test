package com.sitture.definitions;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.sitture.models.Enderecos;
import com.sitture.models.Pessoa;
import com.sitture.models.Telefone;
import com.sitture.utils.CpfUtil;
import com.sitture.utils.RestInstance;
import com.sitture.utils.TelefoneUtil;
import cucumber.api.java.en.And;

public class CadastrarPessoas {

	private Pessoa pessoa;
	private List<Telefone> Telefonelist ; 
	private List<Enderecos> Enderecoslist ;
 
	private static final String BASE_PATH = "/pessoas";
	private static final String INCORRECT_BASE_PATH = "/usuario";
	
	
	@And("^I create a new pessoa$")
	public void iCreateANewPessoa() throws Exception {
		this.Telefonelist = new ArrayList<Telefone>();
		this.Enderecoslist = new ArrayList<Enderecos>(); 
		this.pessoa = new Pessoa(1,"Gabriel Gomes Ferreira da Silva",CpfUtil.geraCPF());
	    this.Enderecoslist.add(new Enderecos("Rua domingues",222,"Casa","Sao miguel","São Paulo","SP"));
        this.Telefonelist.add(new Telefone(TelefoneUtil.geraPrefixo(),TelefoneUtil.geraNumeroTelefonico()));
   	    this.pessoa.setEnderecos(this.Enderecoslist);
   	    this.pessoa.setTelefones(this.Telefonelist);
	}
	
	@And("^I get last created pessoa$")
	public Pessoa iGetLastCreatedPessoar() throws Exception {
	    return this.pessoa;
	}
	
	
	@And("^I update \"([^\"]*)\" of last pessoa$")
	public void iUpdateOfLastPessoa(String arg1) throws Exception {
		  switch(arg1){
          case "telefone":
        	  	Telefonelist = new ArrayList<Telefone>();
       	   		this.Telefonelist.add(new Telefone(TelefoneUtil.geraPrefixo(),TelefoneUtil.geraNumeroTelefonico()));
       	   this.pessoa.setTelefones(this.Telefonelist);
              break;
          case "cpf":
        	   	   this.pessoa.setCpf(CpfUtil.geraCPF());
          break;
      }
	}
	
	@And("^I set pessoa on body$")
	public void iSetPessoaOnBody() throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(pessoa);
		RestInstance.request().body(json);
	}

	@And("^I post pessoa on valid BasePath$")
	public void iPostPessoaOnValidBasePath() throws Exception {
		  RestInstance.request().basePath(BASE_PATH);
		  RestInstance.response = RestInstance.request().post();
		  RestInstance.response.then().log().all();
		 
	}
	
	@And("^I post pessoa on invalid BasePath$")
	public void iPostPessoaOnInvalidBasePath() throws Exception {
		  RestInstance.request().basePath(INCORRECT_BASE_PATH);
		  RestInstance.response = RestInstance.request().post();
		  RestInstance.response.then().log().all();
	}
	
	

}
