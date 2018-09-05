package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().goToEditPage(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Tanya", "Marmuzevich",
            "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
            "tmarmuzevich@gmail.com", "1987", "null");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

  @Test

  public void testContactModificationFromDetailPage() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
              "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
              "tmarmuzevich@gmail.com", "1987", "Test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().goToDetailsPage(before.size() - 1);
    app.getContactHelper().initModification();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Tanya", "Marmuzevich",
            "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
            "tmarmuzevich@gmail.com", "1987", "null");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
