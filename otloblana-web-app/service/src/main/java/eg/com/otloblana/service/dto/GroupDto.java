package eg.com.otloblana.service.dto;

// Generated Nov 9, 2015 9:29:03 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * GroupDto generated by hbm2java
 */
public class GroupDto implements java.io.Serializable {

	private int id;
	private UserDto userDto;
	private String name;
	private String location;
	private Set memberDtos = new HashSet(0);

	public GroupDto() {
	}

	public GroupDto(int id, UserDto userDto, String name) {
		this.id = id;
		this.userDto = userDto;
		this.name = name;
	}

	public GroupDto(int id, UserDto userDto, String name, String location, Set memberDtos) {
		this.id = id;
		this.userDto = userDto;
		this.name = name;
		this.location = location;
		this.memberDtos = memberDtos;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set getMemberDtos() {
		return this.memberDtos;
	}

	public void setMemberDtos(Set memberDtos) {
		this.memberDtos = memberDtos;
	}

}