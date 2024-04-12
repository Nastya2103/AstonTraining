package MobileTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Tests {
    private AppiumDriver driver;

    @BeforeEach
    @Step("Включение приложения Калькулятор на эмуляторе мобильного телефона")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 8 API 31");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterEach
    @Step("Выключение приложения Калькулятор на эмуляторе мобильного телефона")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Тест расчета суммы в калькуляторе.")
    @Step("Клики по кнопкам: '8', '+', '7', '='.")
    public void checkSum() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultSum = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        String expectedResultSum = "15";
        Assertions.assertEquals(expectedResultSum, actualResultSum);
    }

    @Test
    @DisplayName("Тест расчета вычитания в калькуляторе.")
    @Step("Клики по кнопкам: '9', '-', '4', '='.")
    public void checkSubtracting() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultSub = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        String expectedResultSub = "5";

        Assertions.assertEquals(expectedResultSub, actualResultSub);
    }

    @Test
    @DisplayName("Тест расчета деления в калькуляторе.")
    @Step("Клики по кнопкам: '9', '/', '3', '='.")
    public void checkDividing() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultDiv = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        String expectedResultDiv = "3";

        Assertions.assertEquals(expectedResultDiv, actualResultDiv);
    }

    @Test
    @DisplayName("Тест расчета умножения в калькуляторе.")
    @Step("Клики по кнопкам: '5', '*', '5', '='.")
    public void checkMultiplying() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultMulti = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        String expectedResultMulti = "25";

        Assertions.assertEquals(expectedResultMulti, actualResultMulti);
    }

    @Test
    @DisplayName("Тест расчета деления на ноль в калькуляторе.")
    @Step("Клики по кнопкам: '5', '/', '0', '='.")
    public void checkDividingByZero() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultDivZero = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
        String expectedResultDivZero = "Can't divide by 0";

        Assertions.assertEquals(expectedResultDivZero, actualResultDivZero);
    }

    @Test
    @DisplayName("Тест расчета умножения отрицательного числа в калькуляторе.")
    @Step("Клики по кнопкам: '4', '*', '-', '8', '='.")
    public void checkMultiplyingNegativeNumber() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultMultiNeg = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        String expectedResultMultiNeg = "−32";

        Assertions.assertEquals(expectedResultMultiNeg, actualResultMultiNeg);
    }

    @Test
    @DisplayName("Тест расчета вычитания с дробным числом в калькуляторе.")
    @Step("Клики по кнопкам: '9', '-', '6', '.', '4', '='.")
    public void checkSubtractingFractionalNumber() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/dec_point")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResultFrac = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        String actualResultFrac2 = driver.findElement(By.id("com.google.android.calculator:id/symbolic")).getText();
        String expectedResultFrac = "2.6";
        String expectedResultFrac2 = "2 3⁄5";

        Assertions.assertEquals(expectedResultFrac, actualResultFrac);
        Assertions.assertEquals(expectedResultFrac2, actualResultFrac2);
    }
}


