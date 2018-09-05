package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  //@Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Marmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testContactDeletionFromEditPage() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().goToEditPage(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
