
public class Tariff {
	private String destinationCountry;
	private String originCountry;
	private String productCategory;
	private double minimumTariff;
	
	
	
	public Tariff(String destinationCountry, String originCountry, String productCategory, double minimumTariff) {
		this.destinationCountry = destinationCountry;
		this.originCountry = originCountry;
		this.productCategory = productCategory;
		this.minimumTariff = minimumTariff;
	}
	
	public Tariff(Tariff obj) {
		this.destinationCountry=obj.destinationCountry;
		this.minimumTariff=obj.minimumTariff;
		this.originCountry=obj.originCountry;
		this.productCategory=obj.productCategory;
	}
	public Tariff clone() {
		return new Tariff(this);
		
	}
	
	public boolean equals(Tariff obj) {
		return this.destinationCountry.equals(obj.destinationCountry)&&
		this.minimumTariff==obj.minimumTariff&&
		this.originCountry.equals(obj.originCountry)&&
		this.productCategory.equals(obj.productCategory);
	}
	
	@Override
	public String toString() {
		return "Tariff [destinationCountry=" + destinationCountry + ", originCountry=" + originCountry
				+ ", productCategory=" + productCategory + ", minimumTariff=" + minimumTariff + "]";
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getMinimumTariff() {
		return minimumTariff;
	}
	public void setMinimumTariff(double minimumTariff) {
		this.minimumTariff = minimumTariff;
	}
	
	

}
