package guru.qa.tests;

import guru.qa.pages.PracticeFormPage;
import guru.qa.utils.DataGenerationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class PracticeFormWithPageObjectDataGenerationTests extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    DataGenerationUtils dataGenerationUtils = new DataGenerationUtils();

    @Test
    @DisplayName("Generation data Faker. Style step")
    void fullTestPracticeForm() {

        String
                picturePathForUpload = "img/picture.png",
                pictureNameForCheck = "picture.png",
                firstName = dataGenerationUtils.getFirstName(),
                lastName = dataGenerationUtils.getLastName(),
                userEmail = dataGenerationUtils.getUserEmail(),
                userNumber = dataGenerationUtils.getUserNumber(),
                gender = dataGenerationUtils.getUserGender(),
                birthDay = dataGenerationUtils.getUserBirthDay(),
                birthYear = dataGenerationUtils.getUserBirthYear(),
                birthDayMonth = dataGenerationUtils.getUserBirthMonth(),
                subject = dataGenerationUtils.getUserSubject(),
                hobby = dataGenerationUtils.getUserHobby(),
                currentAddress = dataGenerationUtils.getUserAddress(),
                state = dataGenerationUtils.getUserState(),
                city = dataGenerationUtils.getUserCity(state);

        step("Открытие формы, удаление банера и футера", () -> {
            practiceFormPage
                    .openPage()
                    .deleteBannerAndFooter();
        });

        step("Заполнение формы", () -> {
            practiceFormPage
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setUserNumber(userNumber)
                    .setGender(gender)
                    .setBirth(birthYear, birthDayMonth, birthDay)
                    .setSubjects(subject)
                    .setHobbies(hobby)
                    .uploadPicture(picturePathForUpload)
                    .setCurrentAddress(currentAddress)
                    .setStateAndCity(state, city);
        });
        step("Отправка формы", () -> {
            practiceFormPage
                    .submit();
        });
        step("Проверка", () -> {
            practiceFormPage
                    .checkModalDialogeTitle("Thanks for submitting the form")
                    .checkResult(List.of(firstName, lastName,
                            userEmail, userNumber, gender,
                            birthDay + " " + birthDayMonth + "," + birthYear, subject, hobby,
                            pictureNameForCheck, currentAddress,
                            state + " " + city));
            ;
        });

    }

}
