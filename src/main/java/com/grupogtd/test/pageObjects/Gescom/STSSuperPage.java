package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class STSSuperPage {
    @FindBy(how = How.ID, using =  "uso")
    public WebElement cbbUso;

    @FindBy(how = How.ID, using =  "tipoServicio")
    public WebElement cbbTipoServicio;

    @FindBy(how = How.ID, using =  "cantTipoServicio")
    public WebElement cbbCantTipoServicio;

    @FindBy(how = How.ID, using =  "velocidad")
    public WebElement cbbVelocida;

    @FindBy(how = How.ID, using =  "botonAgregar")
    public WebElement btnAgregar;

    @FindBy(how = How.ID, using =  "botonQuitar")
    public WebElement btnQuitar;

    @FindBy(how = How.ID, using =  "botonGuardar")
    public WebElement btnGuardarPrimario;

    @FindBy(how = How.ID, using =  "botonGuardarCF")
    public WebElement btnGuardarFinal;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[2]/td[2]")
    public WebElement txtTipoServicioAgregado1;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[3]/td[2]")
    public WebElement txtTipoServicioAgregado2;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[4]/td[2]")
    public WebElement txtTipoServicioAgregado3;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[5]/td[2]")
    public WebElement txtTipoServicioAgregado4;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[2]/td[1]/input")
    public WebElement rdTipoServicioAgregado1;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[3]/td[1]/input")
    public WebElement rdTipoServicioAgregado2;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[4]/td[1]/input")
    public WebElement rdTipoServicioAgregado3;

    @FindBy(how = How.XPATH, using =  "//div[@id='scrolltable']/table/tbody/tr[5]/td[1]/input")
    public WebElement rdTipoServicioAgregado4;


    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[1]/input")
    public WebElement chkBajaFibraFTTH;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'ADSL')]/../td[1]/input")
    public WebElement chkBajaADSL;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TELEVISION')]/../td[1]/input")
    public WebElement chkBajaTelevision;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[1]/input")
    public WebElement chkBajaVozFTTH;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'INT FTTH')]/../td[1]/input")
    public WebElement chkBajaIntFTTH;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TV FTTH')]/../td[1]/input")
    public WebElement chkBajaTvFTTH;

    @FindBy(how = How.XPATH, using =  "//*[@id='SegmentoTextoPrincipal']/div/text()")
    public WebElement txtInteraccion;

    @FindBy(how = How.XPATH, using =  "//*[@id='SegmentoBotones']/table/tbody/tr/td[1]/a/button")
    public WebElement btnInteraccionSi;

    @FindBy(how = How.XPATH, using =  "//*/div[@id = 'SegmentoBotones']/table/tbody/tr/td/a/button[contains(.,'No')]")
    public WebElement btnInteraccionNo;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[10]/select")
    public WebElement entregaFibra;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[12]/select")
    public WebElement empresaFibra;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[13]/select")
    public WebElement famMotivoFibra;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[14]/select")
    public WebElement motivoFibra;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[10]/select")
    public WebElement entregaVoz;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[12]/select")
    public WebElement empresaVoz;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[13]/select")
    public WebElement famMotivoVoz;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[14]/select")
    public WebElement motivoVoz;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'ADSL')]/../td[10]/select")
    public WebElement entregaADSL;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'ADSL')]/../td[12]/select")
    public WebElement empresaADSL;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'ADSL')]/../td[13]/select")
    public WebElement famMotivoADSL;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'ADSL')]/../td[14]/select")
    public WebElement motivoADSL;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TELEVISION')]/../td[10]/select")
    public WebElement entregaTelevision;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TELEVISION')]/../td[12]/select")
    public WebElement empresaTelevision;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TELEVISION')]/../td[13]/select")
    public WebElement famMotivoTelevision;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TELEVISION')]/../td[14]/select")
    public WebElement motivoTelevision;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'INT FTTH')]/../td[10]/select")
    public WebElement entregaInt;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'INT FTTH')]/../td[12]/select")
    public WebElement empresaInt;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'INT FTTH')]/../td[13]/select")
    public WebElement famMotivoInt;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'INT FTTH')]/../td[14]/select")
    public WebElement motivoInt;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TV FTTH')]/../td[10]/select")
    public WebElement entregaTv;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TV FTTH')]/../td[12]/select")
    public WebElement empresaTv;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TV FTTH')]/../td[13]/select")
    public WebElement famMotivoTv;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/table/tbody/tr/td[contains(.,'TV FTTH')]/../td[14]/select")
    public WebElement motivoTv;

    @FindBy(how = How.ID, using =  "botonDesconectar")
    public WebElement desconectarBtn;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[3]/fieldset/table[2]/tbody/tr/td[1]/input")
    public WebElement direccionOrigenRd;

    @FindBy(how = How.XPATH, using =  "//*[@id='tLineasActivas']/tbody/tr/td[contains(.,'ADSL')]/../td[1]/input")
    public WebElement adslTrasladoChk;

    @FindBy(how = How.XPATH, using =  "//*[@id='tLineasActivas']/tbody/tr/td[contains(.,'TELEVISION')]/../td[1]/input")
    public WebElement tvTrasladoChk;

    @FindBy(how = How.ID, using =  "botonSeleccionar")
    public WebElement nuevaDirDeTrasladoBtn;

    @FindBy(how = How.ID, using =  "botonTrasladar")
    public WebElement trasladarBtn;

    @FindBy(how = How.XPATH, using =  "//*[@id='jspGenericMessage']/div[2]/div[3]/table/tbody/tr/td[1]/a/button")
    public WebElement frameAceptarBaja;


    public void agregarTVFTTHAction(WebDriver driver, Logger LOGGER, String usoServicio, String tipoServicio) throws InterruptedException{
        boolean add = false;
        do{
            new Select(cbbUso).selectByVisibleText(usoServicio);
            LOGGER.log(Level.INFO,"Uso Comercial");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbTipoServicio).selectByVisibleText(tipoServicio);
            LOGGER.log(Level.INFO,"Tipo Servicio TV FTTH");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbCantTipoServicio).selectByVisibleText("1");
            LOGGER.log(Level.INFO,"Cantidad = 1");
            btnAgregar.sendKeys(Keys.ENTER);
            LOGGER.log(Level.INFO,"Agregar");
            WaitTool.waitToLoad(driver, LOGGER);
            try {
                if(txtTipoServicioAgregado1.getText().equals(tipoServicio)){
                    LOGGER.log(Level.INFO,"TV FTTH Agregada correctamente");
                    add = true;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"No se agrego TV FTTH, intentando nuevamente");
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }while(!add);
        try {
            if(txtTipoServicioAgregado2.getText().equalsIgnoreCase(tipoServicio)){
                eliminarServicioPostuladoAction(driver, LOGGER, rdTipoServicioAgregado2);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void agregarINTFTTHAction(WebDriver driver, Logger LOGGER, String usoServicio, String tipoServicio, String velocidadServicio) throws InterruptedException{
        boolean add = false;
        do{
            new Select(cbbUso).selectByVisibleText(usoServicio);
            LOGGER.log(Level.INFO,"Uso Comercial");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbTipoServicio).selectByVisibleText(tipoServicio);
            LOGGER.log(Level.INFO,"Tipo Servicio INT FTTH");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbCantTipoServicio).selectByVisibleText("1");
            LOGGER.log(Level.INFO,"Cantidad = 1");
            new Select(cbbVelocida).selectByVisibleText(velocidadServicio);
            LOGGER.log(Level.INFO,"Velocidad = 2000/1500");
            btnAgregar.sendKeys(Keys.ENTER);
            LOGGER.log(Level.INFO,"Agregar");
            WaitTool.waitToLoad(driver, LOGGER);
            try {
                if(txtTipoServicioAgregado2.getText().equals(tipoServicio)){
                    LOGGER.log(Level.INFO,"INT FTTH Agregada correctamente");
                    add = true;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"No se agrego INT FTTH, intentando nuevamente");
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }while(!add);
        try {
            if(txtTipoServicioAgregado3.getText().equalsIgnoreCase(tipoServicio)){
                eliminarServicioPostuladoAction(driver, LOGGER, rdTipoServicioAgregado3);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void agregarVOZFTTHAction(WebDriver driver, Logger LOGGER, String usoServicio, String tipoServicio) throws InterruptedException{
        boolean add = false;
        do{
            new Select(cbbUso).selectByVisibleText(usoServicio);
            LOGGER.log(Level.INFO,"Uso Comercial");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbTipoServicio).selectByVisibleText(tipoServicio);
            LOGGER.log(Level.INFO,"Tipo Servicio VOZ FTTH");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbCantTipoServicio).selectByVisibleText("1");
            LOGGER.log(Level.INFO,"Cantidad = 1");
            btnAgregar.sendKeys(Keys.ENTER);
            LOGGER.log(Level.INFO,"Agregar");
            WaitTool.waitToLoad(driver, LOGGER);
            try {
                if(txtTipoServicioAgregado3.getText().equals(tipoServicio)){
                    LOGGER.log(Level.INFO,"VOZ FTTH Agregada correctamente");
                    add = true;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"No se agrego VOZ FTTH, intentando nuevamente");
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }while(!add);
        try {
            if(txtTipoServicioAgregado4.getText().equalsIgnoreCase(tipoServicio)){
                eliminarServicioPostuladoAction(driver, LOGGER, rdTipoServicioAgregado4);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }
    public void agregarADSLAction(WebDriver driver, Logger LOGGER, String tipoUso, String tipoServicio, String velocidad) throws InterruptedException{
        boolean add = false;
        do{
            new Select(cbbUso).selectByVisibleText(tipoUso);
            LOGGER.log(Level.INFO,"Uso Comercial");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbTipoServicio).selectByVisibleText(tipoServicio);
            LOGGER.log(Level.INFO,"Tipo Servicio ADSL");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbCantTipoServicio).selectByVisibleText("1");
            LOGGER.log(Level.INFO,"Cantidad = 1");
            new Select(cbbVelocida).selectByVisibleText(velocidad);
            LOGGER.log(Level.INFO,"2000/600");
            btnAgregar.sendKeys(Keys.ENTER);
            LOGGER.log(Level.INFO,"Agregar");
            WaitTool.waitToLoad(driver, LOGGER);
            try {
                if(txtTipoServicioAgregado1.getText().equals("ADSL")){
                    LOGGER.log(Level.INFO,"ADSL Agregada correctamente");
                    add = true;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"No se agrego ADSL, intentando nuevamente");
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }while(!add);
        try {
            if(txtTipoServicioAgregado2.getText().equalsIgnoreCase("ADSL")){
                eliminarServicioPostuladoAction(driver, LOGGER, rdTipoServicioAgregado2);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void agregarMovilAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        boolean add = false;
        do{
            new Select(cbbUso).selectByVisibleText("RESIDENCIAL");
            LOGGER.log(Level.INFO,"Uso residencial");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbTipoServicio).selectByVisibleText("MOVIL VOZ POSTPAGO");
            LOGGER.log(Level.INFO,"Tipo Servicio MOVIL VOZ POSTPAGO");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbCantTipoServicio).selectByVisibleText("1");
            LOGGER.log(Level.INFO,"Cantidad = 1");
            btnAgregar.sendKeys(Keys.ENTER);
            LOGGER.log(Level.INFO,"Agregar");
            WaitTool.waitToLoad(driver, LOGGER);
            try {
                if(txtTipoServicioAgregado1.getText().equals("MOVIL VOZ POSTPAGO")){
                    LOGGER.log(Level.INFO,"MOVIL VOZ POSTPAGO Agregada correctamente");
                    add = true;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"No se agrego MOVIL VOZ POSTPAGO, intentando nuevamente");
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }while(!add);
        try {
            if(txtTipoServicioAgregado2.getText().equalsIgnoreCase("MOVIL VOZ POSTPAGO")){
                eliminarServicioPostuladoAction(driver, LOGGER, rdTipoServicioAgregado2);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void agregarTVCUAction(WebDriver driver, Logger LOGGER, String tipoUso, String tipoServicio) throws InterruptedException{
        boolean add = false;
        do{
            new Select(cbbUso).selectByVisibleText(tipoUso);
            LOGGER.log(Level.INFO,"Uso Comercial");
            WaitTool.waitToLoad(driver, LOGGER);
            Thread.sleep(2000);
            new Select(cbbTipoServicio).selectByVisibleText(tipoServicio);
            LOGGER.log(Level.INFO,"Tipo Servicio TELEVISION");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(cbbCantTipoServicio).selectByVisibleText("1");
            LOGGER.log(Level.INFO,"Cantidad = 1");
            btnAgregar.sendKeys(Keys.ENTER);
            WaitTool.waitForAlertDismiss(driver, LOGGER);
            LOGGER.log(Level.INFO,"Agregar");
            try {
                if(txtTipoServicioAgregado2.getText().equals(tipoServicio)){
                    LOGGER.log(Level.INFO,"TELEVISION Agregada correctamente");
                    add = true;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"No se agrego TELEVISION C/RET, intentando nuevamente");
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }while(!add);
        try {
            if(txtTipoServicioAgregado3.getText().equalsIgnoreCase("TELEVISION C/RET")){
                eliminarServicioPostuladoAction(driver, LOGGER, rdTipoServicioAgregado3);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void eliminarServicioPostuladoAction(WebDriver driver, Logger LOGGER, WebElement radio) throws InterruptedException{
        do{
            radio.sendKeys(Keys.SPACE);
        }while (!radio.isSelected());
        LOGGER.log(Level.INFO,"Quitando servicio agregado por error");
        btnQuitar.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void guardarAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        LOGGER.log(Level.INFO,"Guardando servicios");
        btnGuardarPrimario.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnGuardarFinal.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
    }

    public void desconectarIntAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        chkBajaFibraFTTH.sendKeys(Keys.SPACE);
        WindowHandTool.windowhandle(driver, LOGGER, "Selecciona Tipo Servicio");
        WaitTool.waitToLoad(driver, LOGGER);
        frameAceptarBaja.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Selecciona Tipo Servicio");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(entregaInt).selectByVisibleText("NO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(empresaInt).selectByVisibleText("NO DICE");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(famMotivoInt).selectByVisibleText("OTRO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(motivoInt).selectByVisibleText("OTRO Sin Motivo");

        WaitTool.waitToLoad(driver, LOGGER);
        new Select(entregaFibra).selectByVisibleText("NO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(empresaFibra).selectByVisibleText("NO DICE");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(famMotivoFibra).selectByVisibleText("OTRO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(motivoFibra).selectByVisibleText("OTRO Sin Motivo");

        WaitTool.waitToLoad(driver, LOGGER);
        new Select(entregaTv).selectByVisibleText("NO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(empresaTv).selectByVisibleText("NO DICE");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(famMotivoTv).selectByVisibleText("OTRO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(motivoTv).selectByVisibleText("OTRO Sin Motivo");

        WaitTool.waitToLoad(driver, LOGGER);
        new Select(entregaVoz).selectByVisibleText("NO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(empresaVoz).selectByVisibleText("NO DICE");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(famMotivoVoz).selectByVisibleText("OTRO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(motivoVoz).selectByVisibleText("OTRO Sin Motivo");
    }

    public void desconectarADSLTelevisionAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        chkBajaADSL.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(entregaADSL).selectByVisibleText("NO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(empresaADSL).selectByVisibleText("NO DICE");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(famMotivoADSL).selectByVisibleText("OTRO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(motivoADSL).selectByVisibleText("OTRO Sin Motivo");
        WaitTool.waitToLoad(driver, LOGGER);
        chkBajaTelevision.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(entregaTelevision).selectByVisibleText("NO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(empresaTelevision).selectByVisibleText("NO DICE");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(famMotivoTelevision).selectByVisibleText("OTRO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(motivoTelevision).selectByVisibleText("OTRO Sin Motivo");
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void desconectarBajaTriplayAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Selecciona Tipo Servicio");
        desconectarIntAction(driver, LOGGER);
        desconectarBtn.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(1000);
        WaitTool.waitForAlert(driver, LOGGER);
    }

    public void desconectarBajaTriplayCUAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Selecciona Tipo Servicio");
        desconectarADSLTelevisionAction(driver, LOGGER);
        desconectarBtn.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(1000);
        WaitTool.waitForAlert(driver, LOGGER);
    }


    public void TrasladoMigracionAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Selecciona Tipo Servicio");
        direccionOrigenRd.sendKeys(Keys.SPACE);
        nuevaDirDeTrasladoBtn.sendKeys(Keys.ENTER);
        CuentaServicioPage cuentaServicioPage = PageFactory.initElements(driver, CuentaServicioPage.class);
        cuentaServicioPage.selecionarCuentaServicioAction(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Selecciona Tipo Servicio");
        adslTrasladoChk.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        tvTrasladoChk.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        trasladarBtn.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnGuardarPrimario.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitForAlert(driver, LOGGER);
    }
}
