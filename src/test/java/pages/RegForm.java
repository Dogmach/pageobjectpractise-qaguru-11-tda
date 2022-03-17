package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegForm {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    SelenideElement mainHeader = $(".main-header"),
            titleOfForm = $(".practice-form-wrapper"),
            submitBTN = $("#submit"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderMale = $("[for=gender-radio-1]"),
            phoneNumberInput = $("#userNumber"),
            bdayField = $(".react-datepicker__input-container"),
            subjectInput = $("#subjectsInput"),
            hobbyReading = $("[for=hobbies-checkbox-2]"),
            uploadPictureField = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelection = $("#state"),
            citySelection = $("#city"),
            resultHeader = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive"),
            stateSelectList = $("#stateCity-wrapper"),

    //actions
    @Step("Открываем тестируемую страницу")
    public RegForm openPage() {
        open("/automation-practice-form");
        mainHeader.shouldHave(text("Practice Form"));
        titleOfForm.shouldHave(text("Student Registration Form"));
        submitBTN.shouldHave(text("Submit"));
        return this;
    }

    @Step("Проставляем имя студента")
    public RegForm setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Проставляем фамилию студента")
    public RegForm setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Проставляем email студента")
    public RegForm setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Проставляем пол студента")
    public RegForm selectMaleGender() {
        genderMale.click();
        return this;
    }

    @Step("Проставляем телефон студента")
    public RegForm setPhone(String phone) {
        phoneNumberInput.setValue(phone);
        return this;
    }

    @Step("Проставляем дату рождения студента")
    public RegForm setBirthDate(String day, String month, String year) {
        bdayField.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Проставляем изучаемый предмет студентом")
    public RegForm setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Проставляем увлечение студента")
    public RegForm selectHobby() {
        hobbyReading.click();
        return this;
    }

    @Step("Загружаем пикчу студента")
    public RegForm uploadPicture(String picture) {
        uploadPictureField.uploadFromClasspath("./img/" + picture);
        return this;
    }

    @Step("Проставляем адрес студента")
    public RegForm setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Проставляем штат студента")
    public RegForm selectState(String state) {
        stateSelection.scrollIntoView(true);
        stateSelection.click();
        stateSelectList.$(byText(state)).click();
        return this;
    }

    /*@Step("Выбираем штат")
    public RegistrationPage selectState(String state) {
        stateSelect.click();
        stateSelectList.$(byText(state)).click();
        return this;
    }*/
    /*stateSelect = $("#state"),
    stateSelectList = $("#stateCity-wrapper"),*/

    @Step("Проставляем город студента")
    public RegForm selectCity(String city) {
        citySelection.click();
        $(byText(city)).click();
        return this;
    }

    @Step("Кликаем по кнопке \"Submit\"")
    public RegForm clickSubmitBTN() {
        submitBTN.click();
        return this;
    }

    @Step("Проверяем заголовок результата созданной формы")
    public RegForm checkResultHeader() {
        resultHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Проверяем проставленные значения для поля {fieldName}. \n" +
            "Значение должно быть: {value}")
    public RegForm checkResult(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
    @Step("Проверяем проставленные значения для поля {fieldName}. \n" +
            "Значение должно быть: пустым")
    public RegForm checkEmptyResult(String fieldName) {
        resultTable.$(byText(fieldName))
                .parent().shouldBe(empty);
        return this;
    }
}
