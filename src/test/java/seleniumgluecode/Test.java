package seleniumgluecode;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;


public class Test extends TestBase {

    private int start;
    private int left;

    @Given("^El usuario se encuentra en la pagina home de imalittletester$")
    public void el_usuario_se_encuentra_en_la_pagina_home_de_imalittletester() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue(homePage.homePageisDisplayed());
    }

    @When("^Hace click sobre el boton The little tester comics$")
    public void hace_click_sobre_el_boton_The_little_tester_comics() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnTitleComics();
    }

    @Then("^Se debe redirigir a la pantalla comic$")
    public void se_debe_redirigir_a_la_pantalla_comic() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue("No se redirecciono correctamente a la pagina de Comics",comicsPage.isTitleComicsDisplayed());

    }
    @Given("^Hay (\\d+) cervezas$")
    public void hayCervezas(int start) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.start=start;

    }

    @When("^tomo (\\d+) cervezas$")
    public void tomoCervezas(int drink) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.left=this.start-drink;

    }

    @Then("^Deberian quedar (\\d+) cervezas$")
    public void deberianQuedarCervezas(int left) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(left,this.left);
    }
    @Given("^Un blog llamado \"([^\"]*)\" con el siguiente contenido$")
    public void unBlogLlamadoConElSiguienteContenido(String conComillasDobles, String contenido) throws Throwable {
        System.out.println(conComillasDobles);
        System.out.println(contenido);
    }
    @Given("^Los siguientes usuarios existentes$")
    public void losSiguientesUsuariosExistentes(DataTable table) throws Throwable {
       List<List<String>>rows = table.asLists(String.class);
       List<List<String>> rowsWithoutHeading=rows.subList(1,rows.size());
        for (List<String>row:rowsWithoutHeading)
            System.out.println("nombre"+row.get(0)+"email: "+row.get(1)+"twitter: "+row.get(2));
    }

}
