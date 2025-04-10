import java.util.NoSuchElementException;

public class TariffList implements TariffPolicy {
	
	public class TariffNode{
		private Tariff tariff;
		private TariffNode next;
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
	private TariffNode head;
	private int size;
	
	public TariffList() {
		head = null;
		size = 0;
	}
	
	public TariffList(TariffList obj) {
		this.head = obj.head;
		this.size = obj.size;
	}
	
	public void addToStart(Tariff t) {
		TariffNode tariff = new TariffNode(t,null);
		tariff.next = head;
		head = tariff;
		size++;
	}
	
	public void insertAtIndex(Tariff newTariff, int index) throws NoSuchElementException{
		//check if index is valid
		if(index < 0 || index >= this.size) {
			throw new NoSuchElementException("Invalid index: " + index);
		}
		//if inserting as first element use addToStart()
		if(index == 0) {
			this.addToStart(newTariff);
		}
		//Other cases
		else {
			TariffNode newNode = new TariffNode(newTariff,null);
		TariffNode position = head;
		for(int j = 0; j < index-1; j++) {
			position = position.next;
		}
		newNode.next = position.next;
		position.next = newNode;
		}
		size++;
	}
	
	public void removeFromIndex(int index) throws NoSuchElementException{
		//check if index is valid
		if(index < 0 || index >= size) {
			throw new NoSuchElementException("Invalid index: " + index);
		}
		//If only one element
		TariffNode position = head;
		if(position.next == null) {
			head = null;
		}
		//Other cases
		else {
			for(int j = 0; j < index-1; j++) {
			position = position.next;
		}
		position.next = position.next.next;
		position.next.next = null;
		}
		size--;
	}
	
	public void deleteFromStart() {
		TariffNode temporary = head;
		head = head.next;
		temporary.next = null;
		size--;
	}
	
	public void replaceAtIndex(Tariff newTariff, int index) {
		//check if index is valid
		if(index < 0 || index >= size) {
			return;
		}
		TariffNode position = head;
		for(int j = 0; j < index; ) {
			position = position.next;
		}
		position.setTariff(newTariff);
	}
	
	public TariffNode find(String origin, String destination, String category) {
		for(int i = 0; i < size; i++) {
			
		}
	}
	

	@Override
	public String evaluateTrade(double proposedTariff, double minimumTariff) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
