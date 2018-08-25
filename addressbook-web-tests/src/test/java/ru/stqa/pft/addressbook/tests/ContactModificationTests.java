package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    app.getContactHelper().goToEditPage();
    app.getContactHelper().fillContactForm(new ContactData("Tanya", "Marmuzevich", "murza", "A1QA", "Minsk, Rafieva str", "+375297634002", "tmarmuzevich@gmail.com", "1987", "null"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();

  }

  @Test

  public void testContactModificationFromDetailPage() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    app.getContactHelper().goToDetailsPage();
    app.getContactHelper().initModification();
    app.getContactHelper().fillContactForm(new ContactData("Tanya", "Marmuzevich", "murza", "A1QA", "Minsk, Rafieva str", "+375297634002", "tmarmuzevich@gmail.com", "1987", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();

  }
}
