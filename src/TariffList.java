
public class TariffList implements TariffPolicy {
	
	public class TariffNode{
		Tariff tariff;
		TariffNode next;
		public TariffNode() {
			this.tariff=null;
			this.next=null;
		}
		public TariffNode(Tariff tariff, TariffNode next) {
			this.tariff = tariff;
			this.next = next;
		}
		public TariffNode(TariffNode obj) {
			if(obj!=null) {
			this.tariff = new Tariff(obj.tariff);
			this.next = new TariffNode(obj.next);
			}
		}
		public TariffNode clone() {
			return new TariffNode(this);
		}
		public boolean equals(TariffNode node) {
			return this.tariff.equals(node.tariff)&&
					this.next.equals(node.next);
			}
		public Tariff getTariff() {
			return tariff;
		}
		public void setTariff(Tariff tariff) {
			this.tariff = tariff;
		}
		public TariffNode getNext() {
			return next;
		}
		public void setNext(TariffNode next) {
			this.next = next;
		}
		
	}
	private TariffNode head=null;
	private int size = 0;
	
		
	

	@Override
	public String evaluateTrade(double proposedTariff, double minimumTariff) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
