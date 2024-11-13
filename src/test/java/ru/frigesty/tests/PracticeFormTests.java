package ru.frigesty.tests;

import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullFillFormTest() {

        registrationPage.openPage()
                        .setFirstName("Airat")
                        .setLastName("Karimov")
                        .setEmail("karimov@yandex.ru")
                        .chooseGender("Male")
                        .setMobileNumber("8900011111")
                        .setBirthDate("2","August","2000")
                        .setAndChooseSubject("Maths")
                        .chooseHobbies("Sports")
                        .uploadPicture("Duck.png")
                        .setAddress("USA")
                        .chooseStateAndCity("NCR","Delhi")
                        .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name","Airat Karimov")
                        .verifyResult("Student Email","karimov@yandex.ru")
                        .verifyResult("Gender","Male")
                        .verifyResult("Mobile","8900011111")
                        .verifyResult("Date of Birth","2 August,2000")
                        .verifyResult("Subjects","Maths")
                        .verifyResult("Hobbies","Sports")
                        .verifyResult("Picture","Duck.png")
                        .verifyResult("Address","USA")
                        .verifyResult("State and City","NCR Delhi");
    }

    @Test
    void minimalFillFormTest() {

        registrationPage.openPage()
                        .setFirstName("Airat")
                        .setLastName("Karimov")
                        .chooseGender("Male")
                        .setMobileNumber("8900011111")
                        .setBirthDate("2", "August", "2000")
                        .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", "Airat Karimov")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "8900011111")
                        .verifyResult("Date of Birth", "2 August,2000");
    }

    @Test
    void negativeFillFormTest() {

        registrationPage.openPage()
                        .setFirstName("")
                        .setLastName("")
                        .setEmail("invalid-email")
                        .setMobileNumber("LL00011111")
                        .setBirthDate("2","August","2000")
                        .setAddress("USA")
                        .clickSubmit();

        registrationPage.firstNameFieldInvalidationCheck()
                        .lasNameFieldInvalidationCheck()
                        .userEmailFieldInvalidationCheck()
                        .genderFieldInvalidationCheck()
                        .mobileNumberFieldInvalidationCheck();
    }
}