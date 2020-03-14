package com.example.demo.util;

import java.io.Serializable;
import java.util.List;

/** 
* @author 作者 尚峰: 
* @version 创建时间：2018年3月21日 上午9:29:36 
* 类说明 
*/
public class PageEntity<T> implements Serializable {

	private Integer cpage;

	private Integer pageSize;

	private Integer start;

	private Long count;

	private List<T> data;

	private int code; // 状态码, 0表示成功

	private String msg; // 提示信息

	public PageEntity(Integer cpage, Integer pageSize) {
		super();
		if (cpage <= 0) {
			cpage = 1;
		}
		if (pageSize <= 0) {
			pageSize = 3;
		}
		this.cpage = cpage;
		this.pageSize = pageSize;
		this.start = (this.cpage - 1) * this.pageSize;
		this.code = 0;
	}

	public Integer getCpage() {
		return cpage;
	}

	public void setCpage(Integer cpage) {
		this.cpage = cpage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
