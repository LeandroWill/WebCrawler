import Model.Anel;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class GoogleSearch {

    public static void main(String[] args){


        //Procura o webdriver no computador
        File file = new File("C:\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        //Faz o Chrome abrir maximizado
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        //Abre o site desejado no Chrome
        WebDriver driver =  new ChromeDriver(options);
        driver.get("https://darksouls3.wiki.fextralife.com/Rings");

        List <Anel> aneis = new ArrayList<>();

        List <WebElement> aneisWebElements = driver.findElements(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr"));

        //Procura através das Tags do site os elementos desejados e salva na lista
        for (int qtdAnel = 1;qtdAnel<aneisWebElements.size();qtdAnel++){
            Anel anel = new Anel();

            String nomeAnel = aneisWebElements.get(qtdAnel).findElement(By.xpath("./td")).getText();
            anel.setNome(nomeAnel);

            String efeitoAnel = aneisWebElements.get(qtdAnel).findElement(By.xpath("./td[3]")).getText();
            anel.setEfeito(efeitoAnel);

            String localAnel = aneisWebElements.get(qtdAnel).findElement(By.xpath("./td[4]")).getText();
            anel.setLocal(localAnel);


            aneis.add(anel);

        }


        //aneis.stream().map(anel -> (anel.toString())).collect(Collectors.toList());

        Scanner entrada = new Scanner(System.in);
        String localEntrada;

        //Recebe a localização desejada e procura quais aneis podem se encontrados la
        System.out.println("Insira o local do Anel");
        localEntrada = entrada.next();

       for (Anel anel:aneis){
           if (anel.getLocal().contains(localEntrada)){
               System.out.println(anel.toString());
           }

       }

       // driver.close();
        driver.quit();

    }

    //TODO localizar aneis que ficam na msm regiao

}