package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterCreationNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  public void gotoNewContactCreationPage() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void goToEditPage(int index) {
    wd.findElements(By.xpath("//td[8]")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void goToDetailsPage(int index) {
    wd.findElements(By.xpath("//td[7]")).get(index).click();
  }

  public void initModification() {
    click(By.name("modifiy"));
  }


  public void createContact(ContactData contact) {
    gotoNewContactCreationPage();
    fillContactForm(contact, true);
    enterCreationNewContact();
    goToHomePage();
  }

  private void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastName = element.findElement(By.xpath("//td[2]")).getText();
      String firstName = element.findElement(By.xpath("//td[3]")).getText();
      ContactData contact = new ContactData(id, firstName, lastName, null, null, null, null, null, null, null);
      contacts.add(contact);
    }

    return contacts;
  }
}
