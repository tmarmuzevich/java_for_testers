package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();
  }

  @Test
  public void testContactDeletionFromEditPage() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    app.getContactHelper().goToEditPage();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
  }
}
