package kr.or.ddit.basic;

import java.util.Objects;

public class Phone {
	private String name;
	private String tel;
	private String add;
	
	public Phone(String name, String tel, String add) {
		super();
		this.name = name;
		this.tel = tel;
		this.add = add;
	}
	
	public Phone() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(add, name, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(this.add, other.add) && Objects.equals(this.name, other.name) && Objects.equals(this.tel, other.tel);
	}
}
