package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.LogHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)

@CucumberOptions(

        features="src/test/java/features",
        glue={"seleniumgluecode"},
        plugin = {"json:test/report/cucumber_report.json"},
        snippets = CAMELCASE,
        tags={"~@browser","@test2,@test1"}
)

public class Testrunner {
    private static final Logger LOGGER= LogHelper.getLogger();
    @AfterClass
    public static void finish(){
        try {
            LOGGER.log(Level.INFO,"Generando reporte...");
            //System.out.println("Generando reporte");
            String[] cmd={"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            LOGGER.log(Level.INFO,"Reporte generado satisfactoriamente");
            //System.out.println("Reporte generado satisfactoriamente");
        }catch (Exception ex){
            LOGGER.log(Level.WARNING,"No se pudo generar el reporte");
            ex.printStackTrace();
        }
    }
}