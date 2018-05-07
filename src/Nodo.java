
public class Nodo 
{
	private Veicolo info;
	private Nodo link;
	
	public Nodo(Veicolo auto)
	{
		setInfo(auto);
		link=null;
	}

	public Veicolo getInfo() 
	{
		return info;
	}

	public void setInfo(Veicolo info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
}
