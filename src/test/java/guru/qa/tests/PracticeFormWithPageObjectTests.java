package guru.qa.tests;

import guru.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectTests extends BaseTest {
    PracticeFormPage practicFormPage = new PracticeFormPage();

    @Test
    void fullTestPracticeForm() {
        practicFormPage.openPage()
                .deleteBannerAndFooter()
                .setFirstName("firstName")
                .setLastName("lastName")
                .setUserEmail("aaa@bbb.cc")
                .setUserNumber("1234567890")
                .setGender("Female")
                .setBirth("2022", "July", "27")
                .setSubjects("Chemistry")
                .setHobbies("Reading")
                .uploadPicture("img/picture.png")
                .setCurrentAddress("Russia")
                .setStateAndCity("Uttar Pradesh", "Agra")
                .submit()
                .checkModalDialogeTitle("Thanks for submitting the form")



                .checkResult(List.of("firstName", "lastName",
                        "aaa@bbb.cc", "1234567890", "Female",
                        "27 July,2022", "Chemistry", "Reading",
                        "picture.png", "Russia",
                        "Uttar Pradesh Agra"));


    }
}