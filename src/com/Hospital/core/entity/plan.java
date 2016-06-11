package com.Hospital.core.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="plan")
public class plan implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8609404414658230278L;
private int id;
private String date;
private transient doctor doctor;
private byte time_1;
private byte time_2;
private byte time_3;
private byte time_4;
private byte time_5;
private byte time_6;
private byte time_7;
private byte time_8;
private byte time_9;
private byte time_10;
private byte time_11;
private byte time_12;
private byte time_13;
private byte time_14;
private byte time_15;
private byte time_16;
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
@Column(name = "id", unique = true, nullable =true,updatable=false)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public byte getTime_1() {
	return time_1;
}
public void setTime_1(byte time_1) {
	this.time_1 = time_1;
}
public byte getTime_2() {
	return time_2;
}
public void setTime_2(byte time_2) {
	this.time_2 = time_2;
}
public byte getTime_3() {
	return time_3;
}
public void setTime_3(byte time_3) {
	this.time_3 = time_3;
}
public byte getTime_4() {
	return time_4;
}
public void setTime_4(byte time_4) {
	this.time_4 = time_4;
}
public byte getTime_5() {
	return time_5;
}
public void setTime_5(byte time_5) {
	this.time_5 = time_5;
}
public byte getTime_6() {
	return time_6;
}
public void setTime_6(byte time_6) {
	this.time_6 = time_6;
}
public byte getTime_7() {
	return time_7;
}
public void setTime_7(byte time_7) {
	this.time_7 = time_7;
}
public byte getTime_8() {
	return time_8;
}
public void setTime_8(byte time_8) {
	this.time_8 = time_8;
}
public byte getTime_9() {
	return time_9;
}
public void setTime_9(byte time_9) {
	this.time_9 = time_9;
}
public byte getTime_10() {
	return time_10;
}
public void setTime_10(byte time_10) {
	this.time_10 = time_10;
}
public byte getTime_11() {
	return time_11;
}
public void setTime_11(byte time_11) {
	this.time_11 = time_11;
}
public byte getTime_12() {
	return time_12;
}
public void setTime_12(byte time_12) {
	this.time_12 = time_12;
}
public byte getTime_13() {
	return time_13;
}
public void setTime_13(byte time_13) {
	this.time_13 = time_13;
}
public byte getTime_14() {
	return time_14;
}
public void setTime_14(byte time_14) {
	this.time_14 = time_14;
}
public byte getTime_15() {
	return time_15;
}
public void setTime_15(byte time_15) {
	this.time_15 = time_15;
}
public byte getTime_16() {
	return time_16;
}
public void setTime_16(byte time_16) {
	this.time_16 = time_16;
}
@ManyToOne(targetEntity=doctor.class)
@JoinColumn(referencedColumnName="id",nullable=false)
public doctor getDoctor() {
	return doctor;
}
public void setDoctor(doctor doctor) {
	this.doctor = doctor;
}

}
