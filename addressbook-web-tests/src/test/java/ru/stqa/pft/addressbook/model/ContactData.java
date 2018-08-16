package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String nickname;
  private final String company;
  private final String address;
  private final String mobile;
  private final String email;
  private final String byear;

  public ContactData(String firstName, String lastName, String nickname, String company, String address, String mobile, String email, String byear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.byear = byear;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getByear() {
    return byear;
  }
}
