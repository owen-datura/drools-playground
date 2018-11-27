package io.datura.java.drools.calltest.data;

public class CallerDemographics {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private Region callingRegion;
	private CompanySize companySize;

	public enum Region {
		NORTH_AMERICA, CENTRAL_AMERICA, SOUTH_AMERICA, WESTERN_EUROPE, EASTERN_EUROPE, MENA, CHINA, JAPAN, ASIA,
		AUSTRALIA
	}

	public enum CompanySize {
		ONE_TO_TEN, TEN_TO_ONE_HUNDRED, ONE_HUNDRED_TO_1000, OVER_1000
	}

	public CallerDemographics() {
		super();
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Region getCallingRegion() {
		return callingRegion;
	}

	public void setCallingRegion(Region callingRegion) {
		this.callingRegion = callingRegion;
	}

	public CompanySize getCompanySize() {
		return companySize;
	}

	public void setCompanySize(CompanySize companySize) {
		this.companySize = companySize;
	}

	@Override
	public String toString() {
		return "CallerDemographics [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", callingRegion=" + callingRegion + ", companySize=" + companySize
				+ "]";
	}
}
