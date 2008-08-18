package com.poprlz.user.entity;

import java.io.Serializable;

public class Permision implements Serializable {
	private Integer permisionId;
	private String permisionName;
	private String permisionContent;
	private Integer stutas;

	public Integer getPermisionId() {
		return permisionId;
	}

	public void setPermisionId(Integer permisionId) {
		this.permisionId = permisionId;
	}

	public String getPermisionName() {
		return permisionName;
	}

	public void setPermisionName(String permisionName) {
		this.permisionName = permisionName;
	}

	public String getPermisionContent() {
		return permisionContent;
	}

	public void setPermisionContent(String permisionContent) {
		this.permisionContent = permisionContent;
	}

 

	public Integer getStutas() {
		return stutas;
	}

	public void setStutas(Integer stutas) {
		this.stutas = stutas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((permisionContent == null) ? 0 : permisionContent.hashCode());
		result = prime * result
				+ ((permisionId == null) ? 0 : permisionId.hashCode());
		result = prime * result
				+ ((permisionName == null) ? 0 : permisionName.hashCode());
		result = prime * result + ((stutas == null) ? 0 : stutas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permision other = (Permision) obj;
		if (permisionContent == null) {
			if (other.permisionContent != null)
				return false;
		} else if (!permisionContent.equals(other.permisionContent))
			return false;
		if (permisionId == null) {
			if (other.permisionId != null)
				return false;
		} else if (!permisionId.equals(other.permisionId))
			return false;
		if (permisionName == null) {
			if (other.permisionName != null)
				return false;
		} else if (!permisionName.equals(other.permisionName))
			return false;
		if (stutas == null) {
			if (other.stutas != null)
				return false;
		} else if (!stutas.equals(other.stutas))
			return false;
		return true;
	}

}
