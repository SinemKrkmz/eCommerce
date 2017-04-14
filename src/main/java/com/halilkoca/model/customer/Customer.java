package com.halilkoca.model.customer;

import java.util.Date;

import com.halilkoca.model.gender.Gender;

public class Customer {
	
	private int idCustomer;
	private Gender gender;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private Date birthday;
	private String company;
	private String password;
	private Date lastPassGenerated;
	private String phoneMobile;
	private int newsletter;
	private String ipRegistrationNewsletter;
	private Date newsletterDateAdd;
	private String website;
	private double outstandingAllowAmount;
	private int showPublicPrices;
	private int maxPaymentDays;
	private String secureKey;
	private String note;
	private int active;
	private int isGuest;
	private int deleted;
	private Date dateAdded;
	private Date dateUpdated;
	private String resetPasswordToken;
	private Date resetPasswordValidaty;
	
	public Customer() {
		
	}

	public Customer(Gender gender, String company, String firstName, String lastName, String username, String email,
			String password, Date birthday, String phoneMobile, int newsletter, String ipRegistrationNewsletter,
			Date newsletterDateAdd, String website, double outstandingAllowAmount,
			int showPublicPrices, int maxPaymentDays, String secureKey, String note, int active, int isGuest,
			int deleted, Date dateAdded, Date dateUpdated) {
		super();
		
		this.gender = gender;
		this.company = company;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.phoneMobile = phoneMobile;
		this.newsletter = newsletter;
		this.ipRegistrationNewsletter = ipRegistrationNewsletter;
		this.newsletterDateAdd = newsletterDateAdd;
		this.website = website;
		this.note = note;
		this.outstandingAllowAmount = outstandingAllowAmount;
		this.showPublicPrices = showPublicPrices;
		this.maxPaymentDays = maxPaymentDays;
		this.secureKey = secureKey;
		this.active = active;
		this.isGuest = isGuest;
		this.deleted = deleted;
		this.dateAdded = dateAdded;
		this.dateUpdated = dateUpdated;		
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public Date getLastPassGenerated() {
		return lastPassGenerated;
	}

	public void setLastPassGenerated(Date lastPassGenerated) {
		this.lastPassGenerated = lastPassGenerated;
	}

	public String getIpRegistrationNewsletter() {
		return ipRegistrationNewsletter;
	}

	public void setIpRegistrationNewsletter(String ipRegistrationNewsletter) {
		this.ipRegistrationNewsletter = ipRegistrationNewsletter;
	}

	public Date getNewsletterDateAdd() {
		return newsletterDateAdd;
	}

	public void setNewsletterDateAdd(Date newsletterDateAdd) {
		this.newsletterDateAdd = newsletterDateAdd;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getOutstandingAllowAmount() {
		return outstandingAllowAmount;
	}

	public void setOutstandingAllowAmount(double outstandingAllowAmount) {
		this.outstandingAllowAmount = outstandingAllowAmount;
	}

	public int getMaxPaymentDays() {
		return maxPaymentDays;
	}

	public void setMaxPaymentDays(int maxPaymentDays) {
		this.maxPaymentDays = maxPaymentDays;
	}

	public String getSecureKey() {
		return secureKey;
	}

	public void setSecureKey(String secureKey) {
		this.secureKey = secureKey;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Date getResetPasswordValidaty() {
		return resetPasswordValidaty;
	}

	public void setResetPasswordValidaty(Date resetPasswordValidaty) {
		this.resetPasswordValidaty = resetPasswordValidaty;
	}

	public int getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}

	public int getShowPublicPrices() {
		return showPublicPrices;
	}

	public void setShowPublicPrices(int showPublicPrices) {
		this.showPublicPrices = showPublicPrices;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getIsGuest() {
		return isGuest;
	}

	public void setIsGuest(int isGuest) {
		this.isGuest = isGuest;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	
	
	
	

}
