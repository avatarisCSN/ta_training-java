# Practical Task 1: WebDriver Introduction & Synchronization

Небольшой автотест на Java, Selenium WebDriver и JUnit 5 для страницы
[Dynamic Loading — Example 1](https://the-internet.herokuapp.com/dynamic_loading/1).

Тест:

1. программно запускает Chrome через Selenium Manager;
2. разворачивает окно браузера;
3. нажимает **Start**;
4. с помощью `WebDriverWait` ждёт исчезновения индикатора загрузки;
5. ждёт видимости результата и проверяет текст `Hello World!`;
6. всегда закрывает браузер в `@AfterEach`.

`Thread.sleep` не используется.

## Требования

- JDK 17 или новее;
- Google Chrome;
- доступ в интернет при первом запуске, чтобы Selenium Manager мог подобрать драйвер.

## Запуск

Windows:

```powershell
.\mvnw.cmd test
```

Linux/macOS:

```bash
./mvnw test
```

Также можно использовать установленный Maven:

```bash
mvn test
```

Для запуска без графического окна (например, в CI):

```bash
mvn -Dheadless=true test
```
