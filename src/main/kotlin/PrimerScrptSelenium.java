import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimerScrptSelenium {
    public static void main(String[] args) {
        //WebDriver Configure:
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jorge\\Desktop\\Programación\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //Open web:
        driver.get("https://github.com/");

        //Print webTitle:
        System.out.println("Page title is: " + driver.getTitle());

        //Close webBrowser (buenas practicas)
        driver.quit();
    }

}

/// Mark: Principales métodos de localización de elementos web:
// Métodos para localizar elementos en Selenium:

// 1. Localizar por ID
// Localiza un elemento por su atributo "id" (rápido y eficiente).
//WebElement element = driver.findElement(By.id("elementId"));

// 2. Localizar por nombre
// Localiza un elemento por su atributo "name".
//WebElement element = driver.findElement(By.name("elementName"));

// 3. Localizar por clase
// Localiza un elemento por su atributo "class".
//WebElement element = driver.findElement(By.className("elementClass"));

// 4. Localizar por etiqueta (Tag Name)
// Localiza un elemento por su nombre de etiqueta (por ejemplo: "button", "input").
//WebElement element = driver.findElement(By.tagName("button"));

// 5. Localizar por XPath
// Localiza un elemento usando una ruta XPath, que puede ser muy flexible.
//WebElement element = driver.findElement(By.xpath("//button[@id='submitButton']"));
//WebElement element = driver.findElement(By.xpath("//button[text()='Enviar']"));

// 6. Localizar por CSS Selector
// Localiza un elemento usando un selector CSS, que es muy poderoso.
//WebElement element = driver.findElement(By.cssSelector(".buttonClass"));
//WebElement element = driver.findElement(By.cssSelector("#submitButton"));
//WebElement element = driver.findElement(By.cssSelector("input[name='username']"));

// 7. Localizar por texto de enlace (Link Text)
// Localiza un enlace utilizando su texto completo.
//WebElement element = driver.findElement(By.linkText("Click here"));

// 8. Localizar por texto parcial de enlace (Partial Link Text)
// Localiza un enlace utilizando solo una parte de su texto.
//WebElement element = driver.findElement(By.partialLinkText("Click"));

// 9. Localizar por elemento padre (XPath o CSS Selector)
// Localiza un elemento dentro de un contenedor usando la jerarquía del DOM.
//WebElement element = driver.findElement(By.xpath("//div[@class='parent']//button[@id='submitButton']"));
//WebElement element = driver.findElement(By.cssSelector(".parent > #submitButton"));

// 10. Localizar elementos en listas (por índice) (XPath o CSS Selector)
// Localiza un elemento dentro de una lista de elementos utilizando el índice.
//WebElement element = driver.findElement(By.xpath("(//button[@class='buttonClass'])[1]"));
//WebElement element = driver.findElement(By.cssSelector(".buttonClass:nth-of-type(2)"));

/// Mark: Acciones Básicas:

// Acciones básicas con Selenium:

// 1. Hacer clic en un elemento
// Realiza un clic en el elemento seleccionado.
//WebElement element = driver.findElement(By.id("elementId"));
//element.click();

// 2. Escribir texto en un campo de entrada (input)
// Envía texto al campo de entrada.
//WebElement inputField = driver.findElement(By.name("username"));
//inputField.sendKeys("miUsuario");

// 3. Limpiar un campo de entrada
// Limpia el texto actual en un campo de entrada (input).
//inputField.clear();

// 4. Obtener texto de un elemento
// Obtiene el texto visible de un elemento (por ejemplo, de un párrafo o un botón).
//WebElement element = driver.findElement(By.tagName("h1"));
//String text = element.getText();

// 5. Obtener atributo de un elemento
// Obtiene el valor de un atributo de un elemento (por ejemplo, "href" de un enlace).
//String href = element.getAttribute("href");

// 6. Obtener el valor de un campo de entrada
// Obtiene el valor actual de un campo de entrada (input).
//String value = inputField.getAttribute("value");

// 7. Esperar explícitamente (WebDriverWait)
// Espera explícitamente hasta que un elemento sea visible o esté presente en el DOM.
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

// 8. Desplegar una lista de opciones (Dropdown)
// Selecciona un valor de un elemento <select> (lista desplegable).
//Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//dropdown.selectByVisibleText("Opción 1");

// 9. Desplazarse a un elemento (scroll)
//WebElement element = driver.findElement(By.id("elementId"));
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

// 10. Realizar una acción de "hover" (mover el mouse sobre un elemento)
// Desplaza el cursor del ratón sobre un elemento, como un botón o un menú.
//Actions actions = new Actions(driver);
//WebElement element = driver.findElement(By.id("menuItem"));
//actions.moveToElement(element).perform();

// 11. Enviar una tecla al elemento (por ejemplo, "Enter", "Tab")
// Envía una tecla al campo de entrada o cualquier otro elemento.
//inputField.sendKeys(Keys.RETURN);  // Enviar "Enter"

// 12. Realizar una doble acción de clic (doble clic)
// Realiza un doble clic en un elemento.
//actions.doubleClick(element).perform();

// 13. Hacer clic con el botón derecho (clic derecho)
// Realiza un clic derecho en un elemento.
//actions.contextClick(element).perform();

// 14. Arrastrar y soltar un elemento (drag and drop)
// Arrastra un elemento a una nueva ubicación.
//WebElement source = driver.findElement(By.id("source"));
//WebElement target = driver.findElement(By.id("target"));
//actions.dragAndDrop(source, target).perform();

// 15. Enviar una combinación de teclas (por ejemplo, "Ctrl + A")
// Envía una combinación de teclas al elemento seleccionado.
//actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();


/// Esperas implicitas y explicitas:

/*
En Selenium, las esperas explícitas e implícitas se utilizan para manejar la sincronización entre el script de prueba y la página web.
A continuación te doy ejemplos de ambas.
Las esperas implícitas establecen un tiempo máximo que Selenium esperará antes de lanzar una excepción si no encuentra un elemento en la página.
Se configura una vez y se aplica a todas las búsquedas de elementos.

 driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS)

 Las esperas explícitas se utilizan para esperar que un elemento específico cumpla una condición dada, como ser visible o clickeable,
 antes de interactuar con él. A diferencia de las esperas implícitas, las explícitas son más específicas y controladas.

 // Crear una instancia de WebDriverWait (espera explícita)
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    try {
            // Esperar hasta que el elemento sea visible
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someElement")));

            // Interactuar con el elemento
            element.click();
        } catch (TimeoutException e) {
            System.out.println("El elemento no apareció dentro del tiempo esperado.");
        }

Las esperas fluidas (o Fluent Wait) en Selenium son una variante de las esperas explícitas, pero con una mayor flexibilidad.
Te permiten especificar no solo el tiempo máximo de espera, sino también el intervalo entre cada intento de verificar una condición,
y cómo manejar ciertas excepciones durante ese tiempo de espera.

¿Cómo funciona una espera fluida?

Tiempo máximo de espera: Definir el tiempo máximo que Selenium debe esperar para que se cumpla una condición (como un elemento sea visible o clickeable).
Intervalo entre verificaciones: Definir el intervalo de tiempo entre los intentos para verificar la condición (por ejemplo, 500 milisegundos).
Manejo de excepciones: Puedes indicar qué excepciones, si las hay, deben ser ignoradas durante el proceso de espera.

¿Cuándo usarla?
Las esperas fluidas son útiles cuando necesitas mayor control sobre el proceso de espera y quieres personalizar el comportamiento de las excepciones
o los intervalos entre las verificaciones. Son particularmente útiles si estás trabajando con aplicaciones que pueden ser lentas o tener comportamientos
asíncronos.

        // Crear una instancia de FluentWait
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
            .pollingEvery(Duration.ofMillis(500)) // Intervalo de espera entre cada intento
            .ignoring(org.openqa.selenium.NoSuchElementException.class); // Ignorar excepciones específicas

        // Usar la espera fluida para esperar a que un elemento sea visible
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("someElement"));
 */