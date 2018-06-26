package com.demo.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AutoSignInIdDoPK implements Serializable {

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 2713178264137136552L;

	@Column(name = "DRIVER_ID", length = 100)
	private String driverId;

	@Column(name = "MUWI", length = 150)
	private String muwi;

	@Column(name = "SIGNIN_START_TIME")
//	@Temporal(TemporalType.TIMESTAMP)
	private String signInStart;

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getMuwi() {
		return muwi;
	}

	public void setMuwi(String muwi) {
		this.muwi = muwi;
	}

	public String getSignInStart() {
		return signInStart;
	}

	public void setSignInStart(String signInStart) {
		this.signInStart = signInStart;
	}

	@Override
	public String toString() {
		return "AutoSignInIdDoPK [driverId=" + driverId + ", muwi=" + muwi + ", signInStart=" + signInStart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
		result = prime * result + ((muwi == null) ? 0 : muwi.hashCode());
		result = prime * result + ((signInStart == null) ? 0 : signInStart.hashCode());
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
		AutoSignInIdDoPK other = (AutoSignInIdDoPK) obj;
		if (driverId == null) {
			if (other.driverId != null)
				return false;
		} else if (!driverId.equals(other.driverId))
			return false;
		if (muwi == null) {
			if (other.muwi != null)
				return false;
		} else if (!muwi.equals(other.muwi))
			return false;
		if (signInStart == null) {
			if (other.signInStart != null)
				return false;
		} else if (!signInStart.equals(other.signInStart))
			return false;
		return true;
	}

}
