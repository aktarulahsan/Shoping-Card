package com.mysoft.auth.homebusiness;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Entity
@Immutable
@Table(name= "HR_BU")
public class HomeBusinessEntity {
	
	
@Column(name="BU_NO", insertable=false, updatable=false,nullable=false)
private Long id;

@Column(name="BU_NAME", insertable=false, updatable=false,nullable=false)
private String buName;


@Column(name="REPORT_HEADER", insertable=false, updatable=false,nullable=false)
private String reportHeader;

@Column(name="ACTIVE_STAT", insertable=false, updatable=false,nullable=false)
private Long activeStat;

@Column(name="SS_CREATOR", insertable=false, updatable=false,nullable=false)
private Long ssCreator;

@Column(name="SS_CREATED_ON", insertable=false, updatable=false,nullable=false)
private Date ssCreatedOn;

@Column(name="SS_CREATED_SESSION", insertable=false, updatable=false,nullable=false)
private Long ssCreatedSession;

@Column(name="SS_MODIFIER", insertable=false, updatable=false,nullable=false)
private Long ssModifier;

@Column(name="SS_MODIFIED_ON", insertable=false, updatable=false,nullable=false)
private Date ssModifiedOn;

@Column(name="SS_MODIFIED_SESSION", insertable=false, updatable=false,nullable=false)
private Long ssModifiedSession;

@Column(name="SS_UPLOADED_ON", insertable=false, updatable=false,nullable=false)
private Date ssUploadedOn;

@Column(name="COMPANY_NO", insertable=false, updatable=false,nullable=false)
private Long companyNO;

@Column(name="ACC_CC_NO", insertable=false, updatable=false,nullable=false)
private Long accCcNo;

@Column(name="ACC_SA_NO", insertable=false, updatable=false,nullable=false)
private Long accSaNo;

@Column(name="DIVISION_NO", insertable=false, updatable=false,nullable=false)
private Long divisionNO;

@Column(name="BU_HEAD", insertable=false, updatable=false,nullable=false)
private Long buHead;

@Column(name="BU_NO_PARENT", insertable=false, updatable=false,nullable=false)
private Long buNoParent;

@Column(name="CLINICAL_DEPT_FLAG", insertable=false, updatable=false,nullable=false)
private Long clinicalDeptFlag;

@Column(name="BU_ID", insertable=false, updatable=false,nullable=false)
private String buId;

	
	

}
