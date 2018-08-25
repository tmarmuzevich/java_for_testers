package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoNewContactCreationPage();
    app.getContactHelper().createContact(new ContactData("Tanya", "Mrmuzevich",
            "murza", "A1QA", "Minsk, Rafieva str", "+375297634002",
            "tmarmuzevich@gmail.com", "1987", "Test1"));
  }
}
