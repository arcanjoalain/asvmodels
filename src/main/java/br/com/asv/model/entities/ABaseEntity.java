package br.com.asv.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.asv.base.model.entities.IBaseEntity;
import br.com.asv.base.model.enums.StatusEntityEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ABaseEntity<I extends Serializable> implements IBaseEntity<I>, Serializable {

 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_entity")
	private StatusEntityEnum statusEntity = StatusEntityEnum.ENABLED;

	@CreatedDate
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@CreatedBy
	@Column(name = "create_user_pid")
	private I createUserPid;

	
	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	@PreUpdate
	public void preUpdate() {
	}

	@PreRemove
	public void preRemove() {
	}

	@PostPersist
	public void postPersist() {

	}

	@PostUpdate
	public void postUpdate() {
	}

	@PostRemove
	public void postRemove() {
	}

	@PostLoad
	public void postLoad() {
	}


}
