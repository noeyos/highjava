package basic;

public class CustomerVo {

	private String custId; // 고객ID
	private String custName; // 고객명
	private String custAge; // 고객나이
	private String custEmail; // 고객이메일
	private String custTelno; // 고객전화번호

	// 생성자
	public CustomerVo(String custId, String custName, String custAge, String custEmail, String custTelno) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAge = custAge;
		this.custEmail = custEmail;
		this.custTelno = custTelno;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAge() {
		return custAge;
	}

	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustTelno() {
		return custTelno;
	}

	public void setCustTelno(String custTelno) {
		this.custTelno = custTelno;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("ID : " + custId);
		sb.append(" ,NAME : " + custName);
		sb.append(" ,AGE : " + custAge);
		sb.append(" ,EMAIL : " + custEmail);
		sb.append(" ,TELNO : " + custTelno);
		return sb.toString();
	}
}
