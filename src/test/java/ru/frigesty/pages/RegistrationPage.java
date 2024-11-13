package ru.frigesty.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.frigesty.pages.components.CalendarComponent;
import ru.frigesty.pages.components.ModalComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
                                  lastNameInput = $("#lastName"),
                                  userEmailInput = $("#userEmail"),
                                  genderWrapper = $("#genterWrapper"),
                                  mobileNumberInput = $("#userNumber"),
                                  birthDateInput = $("#dateOfBirthInput"),
                                  subjectsInput = $("#subjectsInput"),
                                  hobbiesWrapper = $("#hobbiesWrapper"),
                                  uploadPicture = $("#uploadPicture"),
                                  addressInput = $("#currentAddress"),
                                  stateInput = $("#state"),
                                  cityInput = $("#city"),
                                  stateCityWrapper = $("#stateCity-wrapper"),
                                  submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalComponent modalComponent = new ModalComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $(firstNameInput).setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        $(lastNameInput).setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage chooseGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setMobileNumber(String value) {
        mobileNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setAndChooseSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage chooseHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage chooseStateAndCity(String state, String city) {
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public RegistrationPage verifyRegistrationResultsModalAppears() {
        modalComponent.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        modalComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage firstNameFieldInvalidationCheck() {
        $(firstNameInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


        return this;
    }

    public RegistrationPage lasNameFieldInvalidationCheck() {
        $(lastNameInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    public RegistrationPage userEmailFieldInvalidationCheck() {
        $(userEmailInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    public RegistrationPage genderFieldInvalidationCheck() {
        ElementsCollection radioLabels = $$(".custom-radio label");
        for (SelenideElement label : radioLabels) {
            label.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        }
        return this;
    }

    public RegistrationPage mobileNumberFieldInvalidationCheck() {
        $(mobileNumberInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
}