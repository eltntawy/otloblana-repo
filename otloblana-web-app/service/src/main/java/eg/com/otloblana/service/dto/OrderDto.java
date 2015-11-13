package eg.com.otloblana.service.dto;

// Generated Nov 9, 2015 9:29:03 PM by Hibernate Tools 4.0.0

import eg.com.otloblana.common.dto.GenericDto;

import java.util.HashSet;
import java.util.Set;

/**
 * OrderDto generated by hbm2java
 */
public class OrderDto implements java.io.Serializable,GenericDto {

	private int id;
	private UserDto userDto;
	private String number;
	private Set orderDetailDtos = new HashSet(0);

	public OrderDto() {
	}

	public OrderDto(int id, UserDto userDto) {
		this.id = id;
		this.userDto = userDto;
	}

	public OrderDto(int id, UserDto userDto, String number, Set orderDetailDtos) {
		this.id = id;
		this.userDto = userDto;
		this.number = number;
		this.orderDetailDtos = orderDetailDtos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDto getUserDto() {
		return this.userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set getOrderDetailDtos() {
		return this.orderDetailDtos;
	}

	public void setOrderDetailDtos(Set orderDetailDtos) {
		this.orderDetailDtos = orderDetailDtos;
	}

}
