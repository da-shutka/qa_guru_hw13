package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.OutputComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress");

    OutputComponent output = new OutputComponent();

    @Step("Открыть текстовую регистрационную форму")
    public TextBoxPage openPage() {
        open("/text-box");
        $("h1").shouldHave(text("Text Box"));
        return this;
    }

    @Step("Убрать рекламу")
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввести полное имя")
    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    @Step("Ввести электронную почту")
    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Ввести адрес местонахождения")
    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Ввести адрес проживания")
    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    @Step("Нажать Submit")
    public void submit() {
        $("#submit").click();
    }

    @Step("Проверить успешность регистрации")
    public TextBoxPage checkResult(String key, String value) {
        output.checkOutputRow(key, value);
        return this;
    }
}
