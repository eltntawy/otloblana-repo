package eg.com.otloblana.service.dto;

// Generated Nov 9, 2015 9:29:03 PM by Hibernate Tools 4.0.0

/**
 * PriceListDto generated by hbm2java
 */
public class PriceListDto implements java.io.Serializable {

	private int id;
	private StoreDto storeDto;
	private ProductDto productDto;
	private float price;

	public PriceListDto() {
	}

	public PriceListDto(int id, StoreDto storeDto, ProductDto productDto, float price) {
		this.id = id;
		this.storeDto = storeDto;
		this.productDto = productDto;
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StoreDto getStoreDto() {
		return this.storeDto;
	}

	public void setStoreDto(StoreDto storeDto) {
		this.storeDto = storeDto;
	}

	public ProductDto getProductDto() {
		return this.productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}