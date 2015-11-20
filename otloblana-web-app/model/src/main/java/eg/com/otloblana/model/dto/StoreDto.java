package eg.com.otloblana.model.dto;

// Generated Nov 9, 2015 9:29:03 PM by Hibernate Tools 4.0.0

import com.fasterxml.jackson.annotation.JsonIgnore;
import eg.com.otloblana.common.dto.GenericDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * StoreDto generated by hbm2java
 */
public class StoreDto implements java.io.Serializable,GenericDto {

	private int id;
	private String name;
	@JsonIgnore
	private List<PriceListDto> priceListDtos = new ArrayList<PriceListDto>(0);

	public StoreDto() {
	}

	public StoreDto(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public StoreDto(int id, String name, List<PriceListDto> priceListDtos) {
		this.id = id;
		this.name = name;
		this.priceListDtos = priceListDtos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getPriceListDtos() {
		return this.priceListDtos;
	}

	public void setPriceListDtos(List priceListDtos) {
		this.priceListDtos = priceListDtos;
	}

}
