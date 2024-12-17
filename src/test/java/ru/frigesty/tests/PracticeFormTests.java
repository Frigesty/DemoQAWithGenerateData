package ru.frigesty.tests;

import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;
import ru.frigesty.utils.TestDataGenerator;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataGenerator gData = new TestDataGenerator();

    @Test
    void fullFillFormTest() {

        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(gData.firstName)
                        .setLastName(gData.lastName)
                        .setEmail(gData.userEmail)
                        .chooseGender(gData.userGender)
                        .setMobileNumber(gData.userNumber)
                        .setBirthDate(gData.dayOfBirth, gData.monthOfBirth, gData.yearOfBirth)
                        .setAndChooseSubject(gData.subject)
                        .chooseHobbies(gData.hobbies)
                        .uploadPicture(gData.pictures)
                        .setAddress(gData.currentAddress)
                        .chooseStateAndCity(gData.randomState, gData.randomCity)
                        .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name",gData.firstName + " " + gData.lastName)
                        .verifyResult("Student Email",gData.userEmail)
                        .verifyResult("Gender", gData.userGender)
                        .verifyResult("Mobile",gData.userNumber)
                        .verifyResult("Date of Birth", gData.dayOfBirth + " " + gData.monthOfBirth + "," +gData.yearOfBirth)
                        .verifyResult("Subjects",gData.subject)
                        .verifyResult("Hobbies",gData.hobbies)
                        .verifyResult("Picture",gData.pictures)
                        .verifyResult("Address",gData.currentAddress)
                        .verifyResult("State and City",gData.randomState + " " + gData.randomCity);
    }

    @Test
    void minimalFillFormTest() {

        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(gData.firstName)
                        .setLastName(gData.lastName)
                        .chooseGender(gData.userGender)
                        .setMobileNumber(gData.userNumber)
                        .setBirthDate(gData.dayOfBirth, gData.monthOfBirth, gData.yearOfBirth)
                        .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name",gData.firstName + " " + gData.lastName)
                        .verifyResult("Gender", gData.userGender)
                        .verifyResult("Mobile",gData.userNumber)
                        .verifyResult("Date of Birth",gData.dayOfBirth
                                + " "
                                + gData.monthOfBirth
                                + ","
                                + gData.yearOfBirth);
    }

    @Test
    void negativeFillFormTest() {

        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName("")
                        .setLastName("")
                        .setEmail("invalid-email")
                        .setMobileNumber("LL00011111")
                        .setBirthDate(gData.dayOfBirth, gData.monthOfBirth, gData.yearOfBirth)
                        .setAddress(gData.currentAddress)
                        .clickSubmit();

        registrationPage.firstNameFieldInvalidationCheck()
                        .lasNameFieldInvalidationCheck()
                        .userEmailFieldInvalidationCheck()
                        .genderFieldInvalidationCheck()
                        .mobileNumberFieldInvalidationCheck();
    }
}