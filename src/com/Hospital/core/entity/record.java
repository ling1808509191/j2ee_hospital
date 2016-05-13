package com.Hospital.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class record {
private int id;
private int p_id;
private int d_id;
private byte time_go;
private boolean timeout;
private boolean re_exit;
private Date time_order;
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
@Column(name = "id", unique = true, nullable =true,updatable=false)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public int getD_id() {
	return d_id;
}
public void setD_id(int d_id) {
	this.d_id = d_id;
}
public byte getTime_go() {
	return time_go;
}
public void setTime_go(byte time_go) {
	this.time_go = time_go;
}
public boolean isTimeout() {
	return timeout;
}
public void setTimeout(boolean timeout) {
	this.timeout = timeout;
}
public boolean isRe_exit() {
	return re_exit;
}
public void setRe_exit(boolean re_exit) {
	this.re_exit = re_exit;
}
public Date getTime_order() {
	return time_order;
}
public void setTime_order(Date time_order) {
	this.time_order = time_order;
}

}
