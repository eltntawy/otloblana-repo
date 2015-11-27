package eg.com.otloblana.model.dto;

// Generated Nov 9, 2015 9:29:03 PM by Hibernate Tools 4.0.0

import eg.com.otloblana.common.dto.GenericDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * AddonDto generated by hbm2java
 */
public class AddonDto implements java.io.Serializable,GenericDto {

	private int id;
	private String nameAr;
	private String nameEn;
	private List<OrderDetailDto> orderDetailDtos = new ArrayList(0);

	public AddonDto() {
	}

	public AddonDto(int id, String nameAr, String nameEn) {
		this.id = id;
		this.nameAr = nameAr;
		this.nameEn = nameEn;
	}

	public AddonDto(int id, String nameAr, String nameEn, List orderDetailDtos) {
		this.id = id;
		this.nameAr = nameAr;
		this.nameEn = nameEn;
		this.orderDetailDtos = orderDetailDtos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameAr() {
		return this.nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public List getOrderDetailDtos() {
		return this.orderDetailDtos;
	}

	public void setOrderDetailDtos(List orderDetailDtos) {
		this.orderDetailDtos = orderDetailDtos;
	}

}
