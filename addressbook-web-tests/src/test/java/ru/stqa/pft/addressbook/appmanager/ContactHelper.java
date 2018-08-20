package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper (FirefoxDriver wd) {
    super(wd);
  }

  public void enterCreationNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("company"),contactData.getCompany());

  }


  public void selectContact() {
    if (!wd.findElement(By.id("9")).isSelected()) {
      wd.findElement(By.id("9")).click();
    }
  }

  public void deleteSelectedContact() {
    click (By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }
  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void goToEditPage() {
    click (By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }


}
