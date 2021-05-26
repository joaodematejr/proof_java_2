package br.com.cesusc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.validation.constraints.NotNull;

@Entity
public class Modality {

	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String description;

	@UpdateTimestamp
	private Date timeModification;
	@CreationTimestamp
	private Date timeCreation;
	@UpdateTimestamp
	private Date lastSync;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimeModification() {
		return timeModification;
	}

	public void setTimeModification(Date timeModification) {
		this.timeModification = timeModification;
	}

	public Date getTimeCreation() {
		return timeCreation;
	}

	public void setTimeCreation(Date timeCreation) {
		this.timeCreation = timeCreation;
	}

	public Date getLastSync() {
		return lastSync;
	}

	public void setLastSync(Date lastSync) {
		this.lastSync = lastSync;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastSync == null) ? 0 : lastSync.hashCode());
		result = prime * result + ((timeCreation == null) ? 0 : timeCreation.hashCode());
		result = prime * result + ((timeModification == null) ? 0 : timeModification.hashCode());
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
		Modality other = (Modality) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (lastSync == null) {
			if (other.lastSync != null)
				return false;
		} else if (!lastSync.equals(other.lastSync))
			return false;
		if (timeCreation == null) {
			if (other.timeCreation != null)
				return false;
		} else if (!timeCreation.equals(other.timeCreation))
			return false;
		if (timeModification == null) {
			if (other.timeModification != null)
				return false;
		} else if (!timeModification.equals(other.timeModification))
			return false;
		return true;
	}

}
