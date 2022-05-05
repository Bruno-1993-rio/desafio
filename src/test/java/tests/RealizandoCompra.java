package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.browserPhactory;

public class RealizandoCompra extends browserPhactory {

	@Test
	public void realizaCompraSucesso() throws InterruptedException {

		// ACEITANDO COOKIES
		getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
		System.out.println("[INFO] - ACEITANDO COOKIES");

		// INSERIR EMAIL PARA LOGIN
		String email = "desafiozup@outlook.com";
		String senha = "desafio1993";
		Thread.sleep(1000);
		getDriver().findElement(By.id("inputUsuarioLogin")).click();
		getDriver().findElement(By.id("inputUsuarioLogin")).sendKeys(email);
		System.out.println("[INFO] - INSERINDO USUÁRIO - LOGIN");

		// INSERIR SENHA PARA LOGIN
		getDriver().findElement(By.id("inputSenhaLogin")).click();
		getDriver().findElement(By.id("inputSenhaLogin")).sendKeys(senha);
		System.out.println("[INFO] - INSERINDO SENHA - LOGIN");

		// REALIZAR LOGIN
		Thread.sleep(1000);
		getDriver().findElement(By.id("botaoLogin")).click();
		System.out.println("[INFO] - REALIZANDO LOGIN");
		Thread.sleep(5000);

		// POPUP NÃO TENHO INTERESSE
		getDriver().findElement(By.id("buttonNaoTenhoInteresse")).click();
		System.out.println("[INFO] - REALIZANDO LOGIN");

		// BUSCANDO PRODUTO
		String busca = "Mouse Gamer Razer Deathadder V2 Chroma";
		getDriver().findElement(By.id("input-busca")).click();
		getDriver().findElement(By.id("input-busca")).sendKeys(busca);
		getDriver().findElement(By.id("input-busca")).sendKeys(Keys.ENTER);
		System.out.println("[INFO] - BUSCANDO PRODUTO");
		Thread.sleep(5000);

		// VERIFICA RESULTADO DA BUSCA
		if (getDriver().getPageSource().contains(busca)) {
			System.out.println("[INFO] - BUSCA REALIZADA COM SUCESSO - PRODUTO VERIFICADO");
		} else {
			System.out.println("[INFO] - FALHA AO BUSCAR PRODUTO - PRODUTO NÃO ENCONTRADO");
		}

		// ESCOLHA DO PRODUTO
		getDriver().findElement(By.xpath("//*[@id='listing']/article/section/div[2]/div/main/div[1]/a")).click();
		System.out.println("[INFO] - SELECIONANDO PRODUTO ");
		Thread.sleep(5000);

		// ADICIONA PRODUTO AO CARRINHO
		getDriver().findElement(By.xpath("//*[@id='blocoValores']/div[contains(.,'COMPRAR')]/button")).click();
		System.out.println("[INFO] - ADICIONANDO PRODUTO AO CARRINHO");
		Thread.sleep(5000);

		// VERIFICA CARRINHO
		String meuCarrinho = "Mouse Gamer Razer Deathadder V2 Chroma";
		if (getDriver().getPageSource().contains(meuCarrinho)) {
			System.out.println("[INFO] - BUSCA REALIZADA COM SUCESSO - PRODUTO VERIFICADO");
		} else {
			System.out.println("[INFO] - FALHA AO BUSCAR PRODUTO - PRODUTO NÃO ENCONTRADO");
		}

		// REALIZANDO LOGOFF
		getDriver().findElement(By.id("linkSairHeader")).click();
		System.out.println("[INFO] - REALIZANDO LOGOFF");

	}

	@Test
	public void loginInvalido() throws InterruptedException {

		// ACEITANDO COOKIES
		getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
		System.out.println("[INFO] - ACEITANDO COOKIES");

		// INSERIR EMAIL PARA LOGIN
		String emailErrado = "desafiozup@outlook.comx";
		String senhaErrada = "desafio1993x";
		Thread.sleep(1000);
		getDriver().findElement(By.id("inputUsuarioLogin")).click();
		getDriver().findElement(By.id("inputUsuarioLogin")).sendKeys(emailErrado);
		System.out.println("[INFO] - INSERINDO USUÁRIO - LOGIN");

		// INSERIR SENHA PARA LOGIN
		getDriver().findElement(By.id("inputSenhaLogin")).click();
		getDriver().findElement(By.id("inputSenhaLogin")).sendKeys(senhaErrada);
		System.out.println("[INFO] - INSERINDO SENHA - LOGIN");

		// REALIZAR LOGIN
		Thread.sleep(1000);
		getDriver().findElement(By.id("botaoLogin")).click();
		System.out.println("[INFO] - REALIZANDO LOGIN");
		Thread.sleep(5000);

		// VERIFICA CARRINHO
		String loginInvalido = "Não foi possivel realizar o login";
		if (getDriver().getPageSource().contains(loginInvalido)) {
			System.out.println("[INFO] - REALIZANDO LOGIN INVALIDO - LOGIN INVALIDO");
		} else {
			System.out.println("[INFO] - FALHA AO VERIFICAR LOGIN INVALIDO");
		}
	}

}