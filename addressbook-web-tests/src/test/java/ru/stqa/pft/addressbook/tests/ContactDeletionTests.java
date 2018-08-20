package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();
  }

  @Test
  public void testContactDeletionFromEditPage() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().goToEditPage();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
  }
}
