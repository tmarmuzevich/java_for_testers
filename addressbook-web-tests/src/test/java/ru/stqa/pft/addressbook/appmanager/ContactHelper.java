package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterCreationNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  public void creation() {
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void goToEditPageById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void goToDetailsPage(int index) {
    wd.findElements(By.xpath("//td[7]")).get(index).click();
  }

  public void goToDetailsPageById(int id) {
    wd.findElement(By.xpath("//a[@href='view.php?id=" + id + "']")).click();
  }

  public void initModification() {
    click(By.name("modifiy"));
  }


  public void create(ContactData contact) {
    creation();
    fillContactForm(contact, true);
    enterCreationNewContact();
    goToHomePage();
  }

  public void modify(ContactData contact) {
    goToEditPageById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
  }

  public void modifyFromDetailPage(ContactData contact) {
    goToDetailsPageById(contact.getId());
    initModification();
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeAlert();
    goToHomePage();
  }

  public void deleteFromEditPage(ContactData contact) {
    goToEditPageById(contact.getId());
    deleteContact();
    goToHomePage();
  }


  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }

    return contacts;
  }


}
